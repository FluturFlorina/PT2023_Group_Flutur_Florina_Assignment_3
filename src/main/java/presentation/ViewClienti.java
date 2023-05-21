package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * Clasa ViewClienti reprezintă o interfață grafică pentru manipularea datelor despre clienți.
 * Aceasta conține componente precum etichete, câmpuri de text, meniu dropdown și buton.
 */
public class ViewClienti {
    public JFrame frame;

    public JTextField numevf;
    public JTextField numenf;
    public JTextField emailf;
    public JTextField emailnouf;
    public JTextField agef;
    public JTextField agenouf;


    public JComboBox operatii;

    public JButton buton;

    public ViewClienti()
    {
        init();
        operatii.addItem("new");
        operatii.addItem("edit");
        operatii.addItem("delete");
    }
    public void init()
    {
        frame=new JFrame();
        frame.setTitle("Clienti");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 300, 275, 260);
        frame.getContentPane().setLayout(null);

        JLabel numev=new JLabel("NumeVechi");
        numev.setBounds(0, 0, 130, 30);
        frame.getContentPane().add(numev);

        numevf=new JTextField();
        numevf.setBounds(100, 0, 130, 30);
        frame.getContentPane().add(numevf);

        JLabel numen=new JLabel("NumeNou");
        numen.setBounds(0, 30, 130, 30);
        frame.getContentPane().add(numen);

        numenf=new JTextField();
        numenf.setBounds(100, 30, 130, 30);
        frame.getContentPane().add(numenf);

        JLabel em=new JLabel("EmailVechi");
        em.setBounds(0, 60, 130, 30);
        frame.getContentPane().add(em);

        emailf=new JTextField();
        emailf.setBounds(100, 60, 130, 30);
        frame.getContentPane().add(emailf);

        JLabel em1=new JLabel("Emailnou");
        em1.setBounds(0, 90, 130, 30);
        frame.getContentPane().add(em1);

        emailnouf=new JTextField();
        emailnouf.setBounds(100, 90, 130, 30);
        frame.getContentPane().add(emailnouf);

        JLabel email=new JLabel("VarstaVeche");
        email.setBounds(0, 120, 130, 30);
        frame.getContentPane().add(email);

        agef=new JTextField();
        agef.setBounds(100, 120, 130, 30);
        frame.getContentPane().add(agef);

        JLabel age=new JLabel("VarstaNoua");
        age.setBounds(0, 150, 160, 30);
        frame.getContentPane().add(age);

        agenouf=new JTextField();
        agenouf.setBounds(100, 150, 130, 30);
        frame.getContentPane().add(agenouf);

        operatii=new JComboBox();
        operatii.setBounds(0, 180, 130, 30);
        frame.getContentPane().add(operatii);

        buton=new JButton("Enter");
        buton.setBounds(120, 180, 130, 30);
        frame.getContentPane().add(buton);
    }
    public void butonf1(ActionListener e)
    {
        buton.addActionListener(e);
    }
}
