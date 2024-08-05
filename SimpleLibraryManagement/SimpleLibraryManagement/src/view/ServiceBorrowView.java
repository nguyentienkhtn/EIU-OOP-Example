package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Service;
import model.User;

public class ServiceBorrowView extends JFrame{
    private Service service;
    private User borrowingUser;
    private JLabel userInfor;
    private JLabel serviceInfor;
    private JButton borrowButton;
    private JLabel result;
    
    public ServiceBorrowView(Service service, User borrowingUser) {
        this.service = service;
        this.borrowingUser = borrowingUser;

        userInfor = new JLabel(borrowingUser.toString());
        serviceInfor = new JLabel(service.toString());
        borrowButton = new JButton("Borrow this book");
        result = new JLabel();
        if(!service.isAvailable()){
            borrowButton.setEnabled(false);
            result.setText("Cannot use this service");
        }
            
        
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(new JLabel("Please check the following information!"));
        getContentPane().add(Box.createVerticalStrut(10));
        getContentPane().add(userInfor);
        getContentPane().add(Box.createVerticalStrut(10));
        getContentPane().add(serviceInfor);
        getContentPane().add(Box.createVerticalStrut(10));
        getContentPane().add(borrowButton);
        getContentPane().add(Box.createVerticalStrut(10));
        getContentPane().add(result);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addBookBorrowingButtonListener();
        
    }
    public void addBookBorrowingButtonListener(){
        borrowButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                borrowingUser.addBookedService(service);
                service.setIsAvailable(false);
                System.out.println(service);
                serviceInfor.setText(service.toString());
                result.setText("Successful! You can go to the counter to get the service");
                borrowButton.setEnabled(false);
                getContentPane().revalidate();
                getContentPane().repaint();
                pack();
            }
            
        });
    }
    public Service getService() {
        return service;
    }
    public User getBorrowingUser() {
        return borrowingUser;
    }
    
}
