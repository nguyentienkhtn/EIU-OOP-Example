package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class BookEditor {
    protected JButton saveButton;
    protected JButton cancelButton;
    protected JTextField isbn;
    protected JTextField author;
    protected JTextField title;
    protected JLabel isbnJLabel;
    protected JLabel authorLabel;
    protected JLabel titleLabel;
    protected JLabel dueDateLabel;
    
    public BookEditor() {
        isbn = new JTextField();
        author = new JTextField();
        title = new JTextField();
        isbnJLabel = new JLabel("ISBN");
        authorLabel = new JLabel("Author");
        titleLabel = new JLabel("Title");
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        
    }
    public abstract JPanel editor();
}
