package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class BookView extends JPanel{
    protected JTextField isbn;
    protected JTextField author;
    protected JTextField title;
    protected JLabel isbnJLabel;
    protected JLabel authorLabel;
    protected JLabel titleLabel;
    protected JLabel dueDateLabel;
    public BookView() {
        isbn = new JTextField();
        author = new JTextField();
        title = new JTextField();
        isbnJLabel = new JLabel("ISBN");
        authorLabel = new JLabel("Author");
        titleLabel = new JLabel("Title");

    }
    public abstract JPanel display();
    
}
