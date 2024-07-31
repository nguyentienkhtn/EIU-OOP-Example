package view;
import javax.swing.*;
public class AdminDashboard extends JPanel{
    private JPanel mainPanel;
    private JButton addPrintedBook;
    private JButton addEBook;
    private JButton addRoom;
    
    public AdminDashboard() {

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new JLabel("Welcome admin!"));        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        addPrintedBook = new JButton("Add printed book");
        addEBook = new JButton("Add e book");
        addRoom = new JButton("Add room");
        buttonPanel.add(addPrintedBook);
        buttonPanel.add(addEBook);
        buttonPanel.add(addRoom);
        mainPanel.add(buttonPanel);
        
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    
    

}
