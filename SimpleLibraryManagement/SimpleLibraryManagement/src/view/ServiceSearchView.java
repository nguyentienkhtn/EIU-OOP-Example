package view;
import java.util.List;

import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import javax.swing.JScrollPane;

import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import model.Service;
import model.User;

public class ServiceSearchView extends JFrame{
    final int MAX_ROW_DISPLAY = 10;
    private JLabel title;
    private JTextField searchTextField;
    private JButton searchButton;
    private JLabel resultNoti;
    private JList<Service> resultList;
    private DefaultListModel<Service> listModel;
    private User user;
    private JSplitPane bookPane;
    private JButton bookServiceButton;


    public ServiceSearchView(){
        
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        title = new JLabel();
        searchTextField = new JTextField();
        searchButton = new JButton("Search for a service");
        resultNoti = new JLabel();
        JSplitPane searchPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, searchTextField, searchButton);
        searchPane.setDividerLocation(300); // Set the initial position of the divider
        searchPane.setResizeWeight(0.7); // Allocate 70% of space to the left panel

        listModel = new DefaultListModel<>();
        resultList = new JList<>(listModel);
        resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getContentPane().add(title);
        getContentPane().add(Box.createVerticalStrut(10));
        add(searchPane);
        getContentPane().add(Box.createVerticalStrut(10));
        add(resultNoti);
        getContentPane().add(Box.createVerticalStrut(10));
        JScrollPane listScrollPane = new JScrollPane(resultList);
        add(listScrollPane);
        getContentPane().add(Box.createVerticalStrut(10));
        bookServiceButton = new JButton("Book");
        bookPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JLabel("Select one service and press the Book button"), bookServiceButton);
        bookPane.setDividerLocation(300); // Set the initial position of the divider
        bookPane.setResizeWeight(0.7); // Allocate 70% of space to the left panel
        
        setSize(500, 280);
        // pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    public void setLoggedInUser(User user){
        this.user = user;
        title.setText("Hello " +user.getName() + "! Welcome to ABC library");
        getContentPane().revalidate();
        getContentPane().repaint();

    }
    public JTextField getSearchTextField() {
        return searchTextField;
    }

    public void addSearchButtonListener(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }

    public void displayResult(List<Service> searchResults){
        if (searchResults.size() !=0) {
            resultNoti.setText("Great! We found some results");
            for (Service service : searchResults) {
                listModel.addElement(service);
                
            }
            getContentPane().add(bookPane);
            getContentPane().revalidate();
            getContentPane().repaint();
            pack();
            
        }
        else
            resultNoti.setText("Unfortunately, no result found!");
            
    }

    public Service getSelectedService(){
        return resultList.getSelectedValue();
    }

    public void addBookServiceAction(ActionListener actionListener){
        bookServiceButton.addActionListener(actionListener);

    }

    public User getUser()
    {
        return user;
    }

}
