package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Library;
import model.User;
import utilities.PasswordUtil;
import view.LoginView;

public class LoginController {
    private Library model;
    
    private LoginView view;
    
    public LoginController(Library model, LoginView view) {
        this.model = model;
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
            
            
            User user = new User(userName);
            user.setPassword(passBuilder.toString());
            if(model.containsUser(user)){
                view.dispose();//close current window
                
                MainController.setLoggedInUser(user);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong credentials!");
            }
        }
    }  
} 
