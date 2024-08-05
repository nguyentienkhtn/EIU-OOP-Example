package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import model.User;
import utilities.PasswordUtil;
import view.LoginView;
import view.ServiceSearch;

public class LoginController {
    private List<User> users;
    private LoginView view;
    
    public LoginController(List<User> users, LoginView view) {
        this.users = users;
        this.view = view;
        this.view.addLoginButtonListener(new LoginAction());
    }

    private class LoginAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String userName = view.getUsername();
            char[] password = view.getPassword().toCharArray();
            StringBuilder passBuilder = new StringBuilder();
            for (char c : password) {
                passBuilder.append(c);
            }
            String hashedPassword = PasswordUtil.hashPassword(passBuilder.toString());
            
            User user = new User(userName);
            user.setPassword(hashedPassword);
            if(users.contains(user)){
                view.dispose();//close current window
                new ServiceSearch(user).setVisible(true);;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong credentials!");
            }
        }
    }  
} 
