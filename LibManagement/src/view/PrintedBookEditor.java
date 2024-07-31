package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PrintedBookEditor extends BookEditor{
        
    public PrintedBookEditor() {
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
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
        isbn.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'insertUpdate'");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'removeUpdate'");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onTextChanged();
            }

            
            
        });
    }
    private void onTextChanged() {
        
    }
    @Override
    public JPanel editor() {
        JPanel contentPanel = new JPanel(new GridLayout(4, 2));
        contentPanel.add(isbnJLabel);
        contentPanel.add(isbn);
        contentPanel.add(authorLabel);
        contentPanel.add(author);
        contentPanel.add(titleLabel);
        contentPanel.add(title);
        contentPanel.add(saveButton);
        contentPanel.add(cancelButton);
        return contentPanel;
    }
    
}
