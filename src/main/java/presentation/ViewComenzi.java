package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;
/**
 * Clasa ViewComenzi reprezintă o interfață grafică pentru gestionarea comenzilor.
 * Aceasta conține componente precum meniuri dropdown, câmpuri de text și buton.
 */
public class ViewComenzi {
    public JFrame frame;

    public JComboBox clientif;
    public JComboBox produsef;
    public JTextField cantitatef;
    public JTextField pretf;
    public JButton buton;
    public ViewComenzi()
    {
        init();
    }
    public void init()
    {
        frame=new JFrame();
        frame.setTitle("Comenzi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 300, 235, 190);
        frame.getContentPane().setLayout(null);

        JLabel clienti=new JLabel("Clienti");
        clienti.setBounds(0, 0, 100, 30);
        frame.getContentPane().add(clienti);

        clientif=new JComboBox();
        clientif.setBounds(100, 0, 100, 30);
        frame.getContentPane().add(clientif);

        JLabel produse=new JLabel("Produse");
        produse.setBounds(0, 30, 100, 30);
        frame.getContentPane().add(produse);

        produsef=new JComboBox();
        produsef.setBounds(100, 30, 100, 30);
        frame.getContentPane().add(produsef);

        JLabel cantitate=new JLabel("Cantitate");
        cantitate.setBounds(0, 60, 100, 30);
        frame.getContentPane().add(cantitate);

        cantitatef=new JTextField();
        cantitatef.setBounds(100, 60, 100, 30);
        frame.getContentPane().add(cantitatef);

        JLabel pret=new JLabel("Pret");
        pret.setBounds(0, 90, 100, 30);
        frame.getContentPane().add(pret);

        pretf=new JTextField();
        pretf.setBounds(100, 90, 100, 30);
        frame.getContentPane().add(pretf);


        buton=new JButton("Enter");
        buton.setBounds(100, 120, 100, 30);
        frame.getContentPane().add(buton);
    }
    public void butonf1(ActionListener e)
    {
        buton.addActionListener(e);
    }

}
