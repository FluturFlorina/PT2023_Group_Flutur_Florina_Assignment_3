package dataAccesLayes;

import javax.swing.*;
import java.sql.*;

public class ConnectionFactory {

        private static final String DRIVER="com.mysql.cj.jdbc.Driver";
        private static final String DBURL="jdbc:mysql://localhost/tema3";
        private static final String USER="root";
        private static final String PASS="25012002Ff@";
        private static dataAccesLayes.ConnectionFactory inst=new dataAccesLayes.ConnectionFactory();
    /**
     * Creates a new database connection.
     *
     * @return the database connection
     */
        private ConnectionFactory()
        {
            try
            {
                Class.forName(DRIVER);
            }
            catch(ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }

        private Connection creare()
        {
            Connection conexiune=null;
            try
            {
                Class.forName(DRIVER);
                conexiune= DriverManager.getConnection(DBURL, USER, PASS);
            }
            catch(ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                return null;
            }
            return conexiune;
        }

    /**
     * Retrieves the database connection.
     *
     * @return the database connection
     */
        public static Connection getConnection()
        {
            return inst.creare();
        }
    /**
     * Closes the database connection.
     *
     * @param conexiune the database connection to be closed
     */
        public static void close(Connection conexiune)
        {
            if(conexiune==null)
            {
                JOptionPane.showMessageDialog(null, "An error occured while trying to connect to the database");
            }
            else
            {
                try
                {
                    conexiune.close();
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    conexiune=null;
                }
            }
        }
    /**
     * Closes the prepared statement.
     *
     * @param instr the prepared statement to be closed
     */
        public static void close(Statement instr)
        {
            if(instr==null)
            {
                JOptionPane.showMessageDialog(null, "An error occured while trying to close the Statement");
            }
            else
            {
                try
                {
                    instr.close();
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    instr=null;
                }
            }
        }
    /**
     * Closes the statement.
     *
     * @param instr the statement to be closed
     */
        public static void close(PreparedStatement instr)
        {
            if(instr==null)
            {
                JOptionPane.showMessageDialog(null, "An error occured while trying to close the PreparedStatement");
            }
            else
            {
                try
                {
                    instr.close();
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    instr=null;
                }
            }
        }
    /**
     * Closes the result set.
     *
     * @param rezultat the result set to be closed
     */
        public static void close(ResultSet rezultat)
        {
            if(rezultat==null)
            {
                JOptionPane.showMessageDialog(null, "An error occured while trying to close the ResultSet");
            }
            else
            {
                try
                {
                    rezultat.close();
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    rezultat=null;
                }
            }
        }


}
