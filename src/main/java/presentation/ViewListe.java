package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;
/**
 * Clasa ViewListe reprezintă o interfață grafică pentru afișarea listelor de clienți, produse și comenzi.
 * Aceasta conține componente precum butoane și tabele pentru vizualizarea datelor.
 */
public class ViewListe {
    public JFrame frame;
    public JButton buton1;
    public JButton buton2;
    public JTable tabel1;
    public JTable tabel2;
    public JTable tabel3;
    public ViewListe()
    {
        init();
    }

    public void init()
    {
        frame=new JFrame();
        frame.setTitle("Listare clienti, produse si comenzi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(700, 100, 915, 360);
        frame.getContentPane().setLayout(null);

        JScrollPane scroll1=new JScrollPane();
        scroll1.setBounds(0, 20, 300, 300);
        frame.getContentPane().add(scroll1);
        tabel1=new JTable();
        scroll1.setViewportView(tabel1);

        JScrollPane scroll2=new JScrollPane();
        scroll2.setBounds(300, 20, 300, 300);
        frame.getContentPane().add(scroll2);
        tabel2=new JTable();
        scroll2.setViewportView(tabel2);

        JScrollPane scroll3=new JScrollPane();
        scroll3.setBounds(600, 20, 300, 300);
        frame.getContentPane().add(scroll3);
        tabel3=new JTable();

        scroll3.setViewportView(tabel3);

    }
    public void metoda1(ActionListener e)
    {
        buton1.addActionListener(e);
    }
    public void metoda2(ActionListener e)
    {
        buton2.addActionListener(e);
    }

}
