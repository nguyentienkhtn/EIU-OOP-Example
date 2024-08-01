package view;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class Dashboard extends JFrame{
    private JButton bookBorrowButton;
    private JButton roomBookingButton;
    private JLabel welcomeLabel;
    public Dashboard() throws IOException{
        setSize(400, 400);
        setLayout(new GridLayout(2, 1));
        
        BufferedImage ebookImg = ImageIO.read(getClass().getResource("../resources/ebook.bmp"));
        ImageIcon ebookIcon = new ImageIcon(ebookImg);
        bookBorrowButton = new JButton("Borrow book", ebookIcon);
        
        BufferedImage roomImg = ImageIO.read(getClass().getResource("../resources/user.bmp"));
        ImageIcon roomIcon = new ImageIcon(roomImg);
        roomBookingButton = new JButton("Book room", roomIcon);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(bookBorrowButton);
        buttonPanel.add(roomBookingButton);
        welcomeLabel = new JLabel("Welcome to ABC library");
        
        add(welcomeLabel);
        add(buttonPanel);
        
        setTitle("Library dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        
    }
    public void addRoomBookingButtonListener(ActionListener roomBookingListener) {
        roomBookingButton.addActionListener(roomBookingListener);
    }

    public void addBookBorrowingButtonListener(ActionListener bookBorrowButtonListener){
        bookBorrowButton.addActionListener(bookBorrowButtonListener);
    }

    public static void main(String[] args) throws IOException {
        new Dashboard().setVisible(true);
    }
}
