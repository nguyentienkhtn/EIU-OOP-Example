package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;


public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;


    public LoginView() {
        
        setTitle("Login");
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Username(user id):"));
        usernameField = new JTextField(20);
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField(20);
        add(passwordField);

        loginButton = new JButton("Login");
        add(loginButton);
    
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void addLoginButtonListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }
    

}

    // public static void main(String[] args) {
    //     User us = new User("12", "Tien Nguyen");
    //     us.setPassword(utilities.PasswordUtil.hashPassword("@123"));
    //     try {
    //         FileOutputStream fileOutputStream = new FileOutputStream("userData.dat");
    //         ObjectOutputStream is = new ObjectOutputStream(fileOutputStream);
    //         is.writeObject(us);
            
    //     } catch (IOException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
        
    //     new LoginView().setVisible(true);
    // }

