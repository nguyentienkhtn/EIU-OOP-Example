package view;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
        try {
            BufferedImage img = ImageIO.read(getClass().getResource("../resources/ebook.bmp"));
            ImageIcon icon = new ImageIcon(img);
            addPrintedBook = new JButton(icon);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
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
