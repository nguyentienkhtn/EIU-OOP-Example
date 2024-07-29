package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import model.PrintedBook;

public class PrintedBookView extends BookView{
    PrintedBook printedBook;
    
    public void seteBook(PrintedBook printedBook) {
        this.printedBook = printedBook;
    }

    
    public PrintedBookView(){
        
    }

    @Override
    public JPanel display() {
        JPanel contentPanel = new JPanel(new GridLayout(4, 2));
        contentPanel.add(isbnJLabel);
        contentPanel.add(new JLabel(printedBook.getIsbn()));
        contentPanel.add(authorLabel);
        contentPanel.add(new JLabel(printedBook.getAuthor()));
        contentPanel.add(titleLabel);
        contentPanel.add(new JLabel(printedBook.getTitle()));
        contentPanel.add(new JLabel("Is borrowed"));
        contentPanel.add(new JLabel(Boolean.toString(printedBook.isBorrowed()));
        return contentPanel;        

    }
}
