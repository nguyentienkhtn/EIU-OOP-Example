package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Collections;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


import model.PrintedBook;

public class PrintedBookEditor extends BookEditor{
    private Map<String, PrintedBook> availablePrintedBookMap;
    private JLabel copyIDLabel;

    public PrintedBookEditor() {
        loadData();
        copyIDLabel = new JLabel();
         
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream("printedBooks.dat");
                    ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
                    PrintedBook printedBook = new PrintedBook(isbn.getText(), title.getText(), author.getText(), Integer.parseInt(copyIDLabel.getText()));
                    System.out.println(printedBook);
                    os.writeObject(printedBook);
                    availablePrintedBookMap.put(printedBook.getIsbn() + Integer.toString(printedBook.getCopyID()), printedBook);
                    os.close();
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
                copyIDLabel.setText("");
            }
            
        });
        isbn.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                if(isbn.getText().length() > 0)
                    onTextChanged(isbn.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(isbn.getText().length() > 0)
                    onTextChanged(isbn.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(isbn.getText().length() > 0)
                    onTextChanged(isbn.getText());
            }

            
            
        });
    }
    private void onTextChanged(String isbn) {
        
        Set<String> keys = availablePrintedBookMap.keySet();
        List<String> copyIDStrings = new ArrayList<>();
        List<Integer> copyIDs = new ArrayList<>();
        for (String key : keys) {
            if (key.startsWith(isbn)) {
                copyIDStrings.add(key.substring(isbn.length()));
            }
        }
        if(copyIDStrings.size() > 0){
            for (String id : copyIDStrings) {
                copyIDs.add(Integer.parseInt(id));
            }
            
            Collections.sort(copyIDs);
            int currentCopyId = copyIDs.get(copyIDs.size() - 1);
            copyIDLabel.setText(""+(currentCopyId + 1));
            String temp = isbn+currentCopyId;
            PrintedBook printedBook = availablePrintedBookMap.get(temp); // put the existing book to GUI so the user can update the book
            author.setText(printedBook.getAuthor());
            title.setText(printedBook.getTitle());

        }
        else{
            author.setText("");
            title.setText("");
            copyIDLabel.setText(""+ 1);
        }
             
    }
    
    /** 
     * @return JPanel
     */
    @Override
    public JPanel editor() {
        JPanel contentPanel = new JPanel(new GridLayout(5, 2));
        contentPanel.add(isbnJLabel);
        contentPanel.add(isbn);
        contentPanel.add(authorLabel);
        contentPanel.add(author);
        contentPanel.add(titleLabel);
        contentPanel.add(title);
        contentPanel.add(new JLabel("Copy Id"));
        contentPanel.add(copyIDLabel);
        contentPanel.add(saveButton);
        contentPanel.add(cancelButton);
        return contentPanel;
    }

    public void loadData() {
        availablePrintedBookMap = new HashMap<>();
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("printedBooks.dat"))) {
            while (true) {
                try {
                    PrintedBook book = (PrintedBook) ois.readObject();
                    availablePrintedBookMap.put(book.getIsbn() + book.getCopyID(), book);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } 
        catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        }
        catch(IOException e2){
            System.out.println("printedBooks file does not exist, I will create one");
            try {
                new File("printedBooks.dat").createNewFile();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        
    }
    
}
