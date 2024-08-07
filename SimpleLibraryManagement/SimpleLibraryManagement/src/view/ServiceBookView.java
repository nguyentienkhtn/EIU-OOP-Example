package view;


import java.awt.event.ActionListener;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Service;
import model.User;

public class ServiceBookView extends JFrame{
    private Service selectedService;
    private User borrowingUser;
    private JLabel userInfor;
    private JLabel serviceInfor;
    private JButton borrowButton;
    private JLabel result;
 

    public ServiceBookView() {
        

        userInfor = new JLabel();
        serviceInfor = new JLabel();
        borrowButton = new JButton("Borrow/Book this service");
        result = new JLabel();
        
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
        
        
    }

    public void addServiceBookingButtonListener(ActionListener actionListener){
        borrowButton.addActionListener(actionListener);
    }
    public Service getSelectedService() {
        return selectedService;
    }
    public User getBorrowingUser() {
        return borrowingUser;
    }
    

    public void setSelectedService(Service selectedService) {
        this.selectedService = selectedService;
        serviceInfor.setText(selectedService.toString());
        if(!selectedService.isAvailable()){
            borrowButton.setEnabled(false);
            result.setText("Cannot use this service");
        }
    }

    public void setBorrowingUser(User borrowingUser) {
        this.borrowingUser = borrowingUser;
        userInfor.setText(borrowingUser.getName());

    }

    public void setBookingButtonEnable(boolean status){
        borrowButton.setEnabled(status);
        getContentPane().revalidate();
        getContentPane().repaint();
        pack();
    }

    
    
}
