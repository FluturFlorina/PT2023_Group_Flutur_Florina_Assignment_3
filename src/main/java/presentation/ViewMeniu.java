package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;
/**
 * Clasa ViewMeniu reprezintă interfața grafică a meniului principal al aplicației.
 * Aceasta conține butoane pentru navigarea către diferite funcționalități, precum gestionarea clienților, produselor, comenzilor etc.
 */
public class ViewMeniu {
    public JFrame frame;

    public JButton clienti;
    public JButton produse;
    public JButton comenzi;
    public JButton afisare;
    public JButton intoarcere;
    public ViewMeniu()
    {
        init();
    }
    public void init()
    {
        frame=new JFrame();
        frame.setTitle("Meniul principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,275,190);
        frame.getContentPane().setLayout(null);

        clienti=new JButton("Clienti");
        clienti.setBounds(0, 0, 275, 30);
        frame.getContentPane().add(clienti);

        produse=new JButton("Produse");
        produse.setBounds(0, 30, 275, 30);
        frame.getContentPane().add(produse);

        comenzi=new JButton("Comenzi");
        comenzi.setBounds(0, 60, 275, 30);
        frame.getContentPane().add(comenzi);

        afisare=new JButton("Liste Clienti/Produse");
        afisare.setBounds(0, 90, 275, 30);
        frame.getContentPane().add(afisare);

        intoarcere=new JButton("Iesire");
        intoarcere.setBounds(0, 120, 275, 30);
        frame.getContentPane().add(intoarcere);

    }

    public void butonf1(ActionListener e)
    {
        clienti.addActionListener(e);
    }
    public void butonf2(ActionListener e)
    {
        produse.addActionListener(e);
    }
    public void butonf3(ActionListener e)
    {
        comenzi.addActionListener(e);
    }
    public void butonf4(ActionListener e)
    {
        afisare.addActionListener(e);
    }
    public void butonf5(ActionListener e)
    {
        intoarcere.addActionListener(e);
    }

}
