package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.EBook;
import model.Format;
import model.Service;
import model.User;

public class ServiceBorrowView extends JFrame{
    private Service service;
    private User borrowingUser;
    private JLabel userInfor;
    private JLabel serviceInfor;
    private JButton borrowButton;
    private JLabel result;
    
    public ServiceBorrowView(){

    }

    public ServiceBorrowView(Service service, User borrowingUser) {
        this.service = service;
        this.borrowingUser = borrowingUser;

        userInfor = new JLabel(borrowingUser.toString());
        serviceInfor = new JLabel(service.toString());
        borrowButton = new JButton("Borrow/Book this service");
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

    public static void main(String[] args) {
        User test = new User("12", "Tien Nguyen");
        Service ebook = new EBook("123", "OOP with Java", null, Format.CHM);
        new ServiceBorrowView(ebook, test).setVisible(true);
    }
    
}
