package swing;

// LibraryView.java
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LibraryView extends JFrame {
    private JTextField bookIdField;
    private JTextField bookTitleField;
    private JTextField bookAuthorField;
    private JButton addBookButton;
    private JButton listBooksButton;
    private JTextArea booksTextArea;

    public LibraryView() {
        setTitle("Library Management System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        bookIdField = new JTextField(20);
        bookTitleField = new JTextField(20);
        bookAuthorField = new JTextField(20);
        addBookButton = new JButton("Add Book");
        listBooksButton = new JButton("List Books");
        booksTextArea = new JTextArea(10, 30);
        booksTextArea.setEditable(false);

        add(new JLabel("Book ID:"));
        add(bookIdField);
        add(new JLabel("Book Title:"));
        add(bookTitleField);
        add(new JLabel("Book Author:"));
        add(bookAuthorField);
        add(addBookButton);
        add(listBooksButton);
        add(new JScrollPane(booksTextArea));
    }

    // Getters for the components

    public JTextField getBookIdField() { return bookIdField; }
    public JTextField getBookTitleField() { return bookTitleField; }
    public JTextField getBookAuthorField() { return bookAuthorField; }
    public JButton getAddBookButton() { return addBookButton; }
    public JButton getListBooksButton() { return listBooksButton; }
    public JTextArea getBooksTextArea() { return booksTextArea; }

    public void displayBooks(List<Book> books) {
        booksTextArea.setText("");
        for (Book book : books) {
            booksTextArea.append("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + "\n");
        }
    }
}
