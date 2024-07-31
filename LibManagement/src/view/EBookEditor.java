package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import model.EBook;
import model.Format;

public class EBookEditor extends BookEditor{
    private  JComboBox<Format> formatComboBox;
    private Map<String, EBook> availableEBookMap;   
    public EBookEditor() {
        // this.eBook = eBook;
        loadData();
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if(availableEBookMap.get(isbn.getText()) == null)
                    {
                        FileOutputStream fileOutputStream = new FileOutputStream("ebooks.dat");
                        ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
                        EBook eBook = new EBook(isbn.getText(), title.getText(), author.getText(), (Format) formatComboBox.getSelectedItem());
                        System.out.println(eBook);
                        os.writeObject(eBook);
                        availableEBookMap.put(eBook.getIsbn(), eBook);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ebook existed!!");
                    }
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

    @Override
    public void loadData() {
        availableEBookMap = new HashMap<>();
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ebooks.dat"))) {
            while (true) {
                try {
                    EBook book = (EBook)ois.readObject();
                    
                    availableEBookMap.put(book.getIsbn(), book);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            
        }
    }
     
    

}
