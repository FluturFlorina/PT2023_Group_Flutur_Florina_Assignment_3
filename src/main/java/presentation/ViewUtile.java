package presentation;

import dataAccesLayes.ConnectionFactory;
import model.Tabel;

import javax.swing.*;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Clasa ViewUtile oferă metode utile pentru operațiuni specifice în interfața grafică a aplicației.
 * Aceasta include metode pentru autentificare, încărcare a combobox-urilor, generarea de liste și crearea de tabele.
 */
public class ViewUtile<T> {
    public Connection conexiune;
    public PreparedStatement prepstat;
    public ResultSet rezultat;
    public ViewUtile() {
    }
    /**
     * Realizează autentificarea utilizatorului pe baza numelui și parolei furnizate.
     *
     * @param nume   numele utilizatorului
     * @param parola parola utilizatorului
     * @return true dacă autentificarea este reușită, false în caz contrar
     */
    public boolean logareMet(String nume, String parola) {
        conexiune = ConnectionFactory.getConnection();
        String instr = "select * from Angajat";
        List num = new ArrayList<String>();
        List par = new ArrayList<String>();
        try {
            prepstat = conexiune.prepareStatement(instr);
            rezultat = prepstat.executeQuery();
            while (rezultat.next()) {
                num.add(rezultat.getString("nume"));
                par.add(rezultat.getString("parola"));
            }
            for (int i = 0; i < num.size(); i++) {
                if (nume.equals(num.get(i)) && parola.equals(par.get(i))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(conexiune);
            ConnectionFactory.close(prepstat);
            ConnectionFactory.close(rezultat);
        }
        return false;
    }
    /**
     * Încarcă elementele combobox-urilor cu date din baza de date.
     *
     * @param clienti  combobox pentru clienți
     * @param produse  combobox pentru produse
     */
    public void incarcare(JComboBox clienti, JComboBox produse) {
        conexiune = ConnectionFactory.getConnection();
        clienti.removeAllItems();
        produse.removeAllItems();
        try {
            String instr = "select nume from Clients";
            prepstat = conexiune.prepareStatement(instr);
            rezultat = prepstat.executeQuery();
            while (rezultat.next()) {
                clienti.addItem(rezultat.getString("nume"));
            }
            instr = "select nume from Products";
            prepstat = conexiune.prepareStatement(instr);
            rezultat = prepstat.executeQuery();
            while (rezultat.next()) {
                produse.addItem(rezultat.getString("nume"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(conexiune);
            ConnectionFactory.close(prepstat);
            ConnectionFactory.close(rezultat);
        }
    }
    /**
     * Generează o listă de obiecte pe baza clasei specificate.
     *
     * @param clasa clasa obiectelor din listă
     * @return lista generată
     */
    public List<T> generarelista(Class clasa) {
        conexiune = ConnectionFactory.getConnection();
        Field[] var = clasa.getDeclaredFields();
        String[] list1 = new String[var.length];
        for (int i = 0; i < var.length; i++) {
            list1[i] = var[i].getName();
        }
        List<T> lista = new ArrayList<T>();
        String instr = "select * from " + (clasa.getSimpleName());
        try {
            T test;
            prepstat = conexiune.prepareStatement(instr);
            rezultat = prepstat.executeQuery();
            while (rezultat.next()) {
                for (int i = 0; i < var.length; i++) {
                    test = (T) rezultat.getObject(list1[i]);
                    lista.add(test);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    /**
     * Generează un tabel JTable pe baza unei liste de obiecte și a clasei specificate.
     *
     * @param obj   lista de obiecte
     * @param clasa clasa obiectelor din listă
     * @return tabelul generat
     */
    public JTable generareTabel(List<T> obj, Class clasa) {
        JTable a = new JTable();
        Tabel model = new Tabel();
        Field[] var = clasa.getDeclaredFields();
        String[] list1 = new String[var.length];
        for (int i = 0; i < var.length; i++) {
            list1[i] = var[i].getName();
        }
        model.setColumnNames(list1);
        int linii = 0;
        String instr = "select count(id) as nr from " + (clasa.getSimpleName());
        try {
            prepstat = conexiune.prepareStatement(instr);
            rezultat = prepstat.executeQuery();
            while (rezultat.next()) {
                linii = rezultat.getInt("nr");
            }
            Object[][] date = new Object[linii][var.length];
            int i = 0, j = 0, k = 0;
            while (i < obj.size()) {
                if (j == var.length) {
                    j = 0;
                    k++;
                }
                date[k][j] = obj.get(i);
                i++;
                j++;
            }
            model.setData(date);
            a.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(conexiune);
            ConnectionFactory.close(prepstat);
            ConnectionFactory.close(rezultat);
        }
        return a;
    }
}
