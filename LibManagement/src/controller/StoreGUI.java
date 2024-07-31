package controller;

import javax.swing.*;

import model.Book;
import model.EBook;
import model.Format;
import model.PrintedBook;
import view.AdminDashboard;
import view.EBookEditor;
import view.PrintedBookEditor;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StoreGUI extends JFrame {
    private JPanel mainPanel;
    
    

    public StoreGUI(List<Book> books) {
        
        setTitle("Store Management");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(new AdminDashboard().getMainPanel());
        // for (Book book : books) {
        //     if (book instanceof EBook) {
        //         // EBookView ebookPanel = new EBookView();
        //         // ebookPanel.seteBook((EBook)book);
        //         EBookEditor ebookPanel = new EBookEditor();
        //         mainPanel.add(ebookPanel.editor());
        //     } else if (book instanceof PrintedBook) {
        //         // PrintedBookView printedBookPanel = new PrintedBookView();
        //         // printedBookPanel.setPrintedBook((PrintedBook) book);
        //         PrintedBookEditor printedBookPanel = new PrintedBookEditor();
        //         mainPanel.add(printedBookPanel.editor());
        //     }
        //     mainPanel.add(new JSeparator());
        // }
    }

    

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            List<Book> books = new ArrayList<>();
            books.add(new EBook("E001", "Java Programming", "ABC", Format.CHM));
            books.add(new PrintedBook("P001", "Effective Java", "Addison-Wesley", 01));
            books.add(new PrintedBook("P001", "Effective Java", "Addison-Wesley", 02));
            StoreGUI storeGUI = new StoreGUI(books);
            storeGUI.setVisible(true);
        });
    }
}
