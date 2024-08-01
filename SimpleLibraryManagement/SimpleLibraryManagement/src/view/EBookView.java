package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;


import model.EBook;


public class EBookView extends BookView{
    EBook eBook;
    
    public void seteBook(EBook eBook) {
        this.eBook = eBook;
    }

    
    public EBookView(){
        
    }
    

    public EBookView(EBook eBook) {
        this.eBook = eBook;
    }


    @Override
    public JPanel display() {
        JPanel contentPanel = new JPanel(new GridLayout(4, 2));
        contentPanel.add(isbnJLabel);
        contentPanel.add(new JLabel(eBook.getIsbn()));
        contentPanel.add(authorLabel);
        contentPanel.add(new JLabel(eBook.getAuthor()));
        contentPanel.add(titleLabel);
        contentPanel.add(new JLabel(eBook.getTitle()));
        contentPanel.add(new JLabel("Format"));
        contentPanel.add(new JLabel(eBook.getFormat().toString()));
        return contentPanel;        

    }
}
