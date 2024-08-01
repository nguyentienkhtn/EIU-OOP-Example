import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) throws Exception {
        JTextField userName = new JTextField();
        JTextField password = new JTextField();
        JButton logIn = new JButton("Login");
        JButton cancel = new JButton("Cancel");
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout layout = new GridLayout(3, 2);
        JPanel contentPanel = new JPanel(layout);
        contentPanel.add(new JLabel("Username"));
        contentPanel.add(userName);
        contentPanel.add(new JLabel("Password"));
        contentPanel.add(password);
        contentPanel.add(logIn);
        contentPanel.add(cancel);
        logIn.addActionListener( 
            e-> {JOptionPane.showMessageDialog(null, "Hello");}
        );

        frame.setContentPane(contentPanel);
        frame.setVisible(true);
        System.out.println("Hello, World!");
    }
}
