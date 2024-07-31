package controller;

import javax.swing.*;

import model.Book;
import model.EBook;
import model.Format;
import model.PrintedBook;
import view.EBookEditor;
import view.EBookView;
import view.PrintedBookEditor;
import view.PrintedBookView;

import java.awt.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreGUI extends JFrame {
    private JPanel mainPanel;

    public StoreGUI(List<Book> books) {
        Map<String, PrintedBook> availablePrintedBookMap = new HashMap<>();
        List<PrintedBook> availablePrintedBookList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("printedBooks.dat"))) {
            while (true) {
                try {
                    PrintedBook book = (PrintedBook) ois.readObject();
                    availablePrintedBookList.add(book);
                    availablePrintedBookMap.put(book.getIsbn()+book.getCopyID(), book);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, EBook> availableEBookMap = new HashMap<>();
        List<EBook> availableEBookList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ebooks.dat"))) {
            while (true) {
                try {
                    EBook book = (EBook) ois.readObject();
                    availableEBookList.add(book);
                    availableEBookMap.put(book.getIsbn(), book);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        setTitle("Store Management");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane, BorderLayout.CENTER);

        for (Book book : books) {
            if (book instanceof EBook) {
                // EBookView ebookPanel = new EBookView();
                // ebookPanel.seteBook((EBook)book);
                EBookEditor ebookPanel = new EBookEditor();
                mainPanel.add(ebookPanel.editor());
            } else if (book instanceof PrintedBook) {
                // PrintedBookView printedBookPanel = new PrintedBookView();
                // printedBookPanel.setPrintedBook((PrintedBook) book);
                PrintedBookEditor printedBookPanel = new PrintedBookEditor();
                mainPanel.add(printedBookPanel.editor());
            }
            mainPanel.add(new JSeparator());
        }
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
