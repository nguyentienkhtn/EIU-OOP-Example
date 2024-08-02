package view;

import javax.swing.*;

import model.User;
import utilities.PasswordUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private Map<String, User>userData;

    public LoginView() {
        userData = DataLoader.loadUserData("userData.dat");
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
        addLoginButtonListener(new LoginAction());
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
    private class LoginAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String userName = usernameField.getText();
            char[] password = passwordField.getPassword();
            StringBuilder passBuilder = new StringBuilder();
            for (char c : password) {
                passBuilder.append(c);
            }
            String hashedPassword = PasswordUtil.hashPassword(passBuilder.toString());
            User user = userData.get(userName);
            String rightPassword = user.getHashedPassword();
            if(hashedPassword.equals(rightPassword)){
                dispose();//close current window
                new ServiceSearch(user).setVisible(true);;
            }
        }
    
        
    }

    public static void main(String[] args) {
        User us = new User("12", "Tien Nguyen");
        us.setPassword(utilities.PasswordUtil.hashPassword("@123"));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("userData.dat");
            ObjectOutputStream is = new ObjectOutputStream(fileOutputStream);
            is.writeObject(us);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        new LoginView().setVisible(true);
    }
}
