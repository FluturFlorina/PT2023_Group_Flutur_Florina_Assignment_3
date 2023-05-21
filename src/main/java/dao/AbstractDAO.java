package dao;

import dataAccesLayes.ConnectionFactory;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clasa AbstractDAO oferă funcționalități de bază pentru operațiile CRUD (Create, Read, Update, Delete) în baza de date.
 *
 * @param <T> Tipul de entitate manipulată.
 */

public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    private final Class<T> type;
    /**
     * Constructorul clasei AbstractDAO.
     * Obține tipul de entitate prin reflexie.
     */
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }
    private String createInsertQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName());

        // Obține toate câmpurile declarate în clasă
        Field[] fields = type.getDeclaredFields();

        // Construiește lista de nume de câmpuri
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields) {
            if (!field.getName().equals("id")) { // Excludem prima coloană (cheia primară)
                fieldNames.add(field.getName());
            }
        }

        sb.append(" (");
        sb.append(String.join(", ", fieldNames));
        sb.append(") VALUES (");

        // Adaugă semnele de întrebare pentru valorile parametrizate
        sb.append(String.join(", ", Collections.nCopies(fieldNames.size(), "?")));
        sb.append(")");

        return sb.toString();
    }
    /**
     * Inserează o entitate în baza de date.
     *
     * @param t Entitatea care urmează să fie inserată.
     * @return Entitatea inserată.
     */
    public T insert(T t) {
        Connection dbConnection = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement insertStatement = null;
        int i = 1;
        try {
            insertStatement = dbConnection.prepareStatement(createInsertQuery(), Statement.RETURN_GENERATED_KEYS);
            for (Field f : type.getDeclaredFields()) {
                if (!f.equals(type.getDeclaredFields()[0])) {
                    f.setAccessible(true);
                    Object obj = f.get(t);
                    insertStatement.setString(i, obj.toString());
                    i++;
                }
            }
            insertStatement.executeUpdate();
            rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                Field f = type.getDeclaredField("id");
                f.setAccessible(true);
                f.set(t, id);
            }
            return t;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DAO:insert " + e.getMessage());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return null;
    }

    private String createUpdateQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        for (Field f : type.getDeclaredFields()) {
            if (!f.equals(type.getDeclaredFields()[0])) {
                sb.append(f.getName());
                sb.append("=?, ");
            }
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append(" WHERE ");
        sb.append("nume = ?");
        return sb.toString();
    }
    /**
     * Actualizează o entitate în baza de date.
     *
     * @param t         Entitatea actualizată.
     * @param nume_nou  Noul nume pentru actualizare.
     * @return Entitatea actualizată.
     */
   public T update(T t, String nume_nou) {
       Connection connection = null;
       PreparedStatement updateStatement = null;
       String query = createUpdateQuery();

       try {
           connection = ConnectionFactory.getConnection();
           updateStatement = connection.prepareStatement(query);
           Field[] fields = t.getClass().getDeclaredFields();
           int parameterIndex = 1; // Counter for setting parameter values

           for (Field field : fields) {
               field.setAccessible(true);
               Object value = field.get(t);
               if (!field.getName().equals("id")) {
                   if (field.getType() == String.class) {
                       updateStatement.setString(parameterIndex, (String) value);
                   } else if (field.getType() == int.class) {
                       updateStatement.setInt(parameterIndex, (int) value);
                   }
                   parameterIndex++;
               }
           }

           // Set the nume parameter value
           updateStatement.setString(parameterIndex, nume_nou);
           updateStatement.executeUpdate();
           return t;
       } catch (SQLException | IllegalAccessException e) {
           LOGGER.log(Level.WARNING, type.getName() + "DAO:Update " + e.getMessage());
       } finally {
           ConnectionFactory.close(updateStatement);
           ConnectionFactory.close(connection);
       }
       return null;
   }

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }
    private String createDeleteQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE nume = ?");
        return sb.toString();
    }
    /**
     * Șterge o entitate din baza de date după nume.
     *
     * @param nume Numele entității care urmează să fie ștearsă.
     */
    public void delete(String nume) {
        Connection connection = null;
        PreparedStatement deleteStatement = null;
        String query = createDeleteQuery();
        try {
            connection = ConnectionFactory.getConnection();
            deleteStatement = connection.prepareStatement(query);
            deleteStatement.setString(1, nume);
            System.out.println(deleteStatement.toString());
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:Delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(connection);
        }

    }
    /**
     * Găsește o entitate din baza de date după nume.
     *
     * @param nume Numele entității căutate.
     * @return Entitatea găsită.
     */
    public T findById(String nume) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("nume");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, nume);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

}
