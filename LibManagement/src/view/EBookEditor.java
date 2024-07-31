package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.EBook;
import model.Format;

public class EBookEditor extends BookEditor{
    private  JComboBox<Format> formatComboBox;   
    public EBookEditor() {
        // this.eBook = eBook;
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream("ebook.dat");
                    ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
                    EBook eBook = new EBook(isbn.getText(), title.getText(), author.getText(), (Format) formatComboBox.getSelectedItem());
                    System.out.println(eBook);
                    os.writeObject(eBook);
                } catch (Exception ex) {
                    // TODO: handle exception
                }
                 
            }
            
        });
        cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                isbn.setText("");
                author.setText("");
                title.setText("");

            }
            
        });
    }

    @Override
    public JPanel editor() {
        JPanel contentPanel = new JPanel(new GridLayout(5, 2));
        Format[]formats = {Format.CHM, Format.EPUB, Format.PDF};
        formatComboBox = new JComboBox<>(formats);
        contentPanel.add(isbnJLabel);
        contentPanel.add(isbn);
        contentPanel.add(authorLabel);
        contentPanel.add(author);
        contentPanel.add(titleLabel);
        contentPanel.add(title);
        contentPanel.add(new JLabel("Format"));
        contentPanel.add(formatComboBox);
        contentPanel.add(saveButton);
        contentPanel.add(cancelButton);
        return contentPanel;
    }
     
    

}
