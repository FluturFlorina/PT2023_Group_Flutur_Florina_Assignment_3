package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;
/**
 * Clasa ViewLogare reprezintă o interfață grafică pentru logare.
 * Aceasta conține componente precum câmpuri de introducere pentru utilizator și parolă.
 */
public class ViewLogare {
    public JFrame frame;

    public JTextField userf;
    public JPasswordField passf;

    public JButton buton;
    public ViewLogare()
    {
        init();
    }
    public void init()
    {
        frame=new JFrame();
        frame.setTitle("Logare");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 150, 275, 150);
        frame.getContentPane().setLayout(null);

        JLabel user=new JLabel("User");
        user.setBounds(35, 10, 100, 20);
        frame.getContentPane().add(user);

        userf=new JTextField();
        userf.setBounds(100, 0, 150, 40);
        frame.getContentPane().add(userf);

        JLabel pass=new JLabel("Pass");
        pass.setBounds(35, 50, 100, 20);
        frame.getContentPane().add(pass);

        passf=new JPasswordField();
        passf.setBounds(100, 40, 150, 40);
        frame.getContentPane().add(passf);

        buton=new JButton("Enter");
        buton.setBounds(100, 80, 150, 20);
        frame.getContentPane().add(buton);

    }
    public void butonf1(ActionListener e)
    {
        buton.addActionListener(e);
    }
}
