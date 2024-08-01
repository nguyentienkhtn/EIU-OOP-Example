package view;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class AdminDashboard extends JPanel{
    private JPanel mainPanel;
    private JButton addPrintedBook;
    private JButton addEBook;
    private JButton addUser;
    
    public AdminDashboard() {

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new JLabel("Welcome admin!"));        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        try {
            BufferedImage ebookImg = ImageIO.read(getClass().getResource("../resources/ebook.bmp"));
            ImageIcon ebookIcon = new ImageIcon(ebookImg);
            addEBook = new JButton("Add ebook", ebookIcon);
            BufferedImage printedBookImg = ImageIO.read(getClass().getResource("../resources/printedBook.bmp"));
            ImageIcon printedIcon = new ImageIcon(printedBookImg);
            addPrintedBook = new JButton("Add printed book", printedIcon);
            BufferedImage userImg = ImageIO.read(getClass().getResource("../resources/user.bmp"));
            ImageIcon userIcon = new ImageIcon(userImg);
            addUser = new JButton("Add user", userIcon);
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        buttonPanel.add(addPrintedBook);
        buttonPanel.add(addEBook);
        buttonPanel.add(addUser);
        mainPanel.add(buttonPanel);
        
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    
    

}
