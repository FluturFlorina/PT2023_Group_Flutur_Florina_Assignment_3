package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;
/**
 * Clasa ViewProduse reprezintă interfața grafică pentru gestionarea produselor în aplicație.
 * Aceasta oferă funcționalități de adăugare, editare și ștergere a produselor, utilizând câmpuri de text și butoane.
 */
public class ViewProduse {
    public JFrame frame;
    public JTextField numevf;
    public JTextField numenf;
    public JTextField cantnou;
    public JTextField pretnou;
    public JTextField cantf;
    public JTextField pretf;
    public JComboBox operatii;
    public JButton buton;
    public ViewProduse()
    {
        init();
        operatii.addItem("new");
        operatii.addItem("edit");
        operatii.addItem("delete");
    }
    public void init()
    {
        frame=new JFrame();
        frame.setTitle("Produse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 100, 235, 180);
        frame.getContentPane().setLayout(null);

        JLabel numev=new JLabel("NumeVechi");
        numev.setBounds(0, 0, 100, 20);
        frame.getContentPane().add(numev);

        numevf=new JTextField();
        numevf.setBounds(100,0,100,20);
        frame.getContentPane().add(numevf);

        JLabel numen=new JLabel("NumeNou");
        numen.setBounds(0, 20, 100, 20);
        frame.getContentPane().add(numen);

        numenf=new JTextField();
        numenf.setBounds(100,20,100,20);
        frame.getContentPane().add(numenf);

        JLabel cant=new JLabel("Cantitate");
        cant.setBounds(0, 40, 100, 20);
        frame.getContentPane().add(cant);

        cantf=new JTextField();
        cantf.setBounds(100,40,100,20);
        frame.getContentPane().add(cantf);

        JLabel cantitate=new JLabel("CantitateNou");
        cantitate.setBounds(0, 60, 100, 20);
        frame.getContentPane().add(cantitate);

        cantnou=new JTextField();
        cantnou.setBounds(100,60,100,20);
        frame.getContentPane().add(cantnou);

        JLabel pret=new JLabel("Pret");
        pret.setBounds(0, 80, 100, 20);
        frame.getContentPane().add(pret);

        pretf=new JTextField();
        pretf.setBounds(100,80,100,20);
        frame.getContentPane().add(pretf);

        JLabel pret1=new JLabel("PretNou");
        pret1.setBounds(0, 100, 100, 20);
        frame.getContentPane().add(pret1);

        pretnou=new JTextField();
        pretnou.setBounds(100,100,100,20);
        frame.getContentPane().add(pretnou);

        operatii=new JComboBox();
        operatii.setBounds(0, 120, 100, 20);
        frame.getContentPane().add(operatii);

        buton=new JButton("Enter");
        buton.setBounds(100, 120, 100, 20);
        frame.getContentPane().add(buton);
    }
    public void butonf1(ActionListener e)
    {
        buton.addActionListener(e);
    }

}
