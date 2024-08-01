package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComponent;
import model.Book;
import model.EBook;

public class BookSearch extends JFrame{
    private JLabel title;
    private JTextField searchTextField;
    private JButton searchButton;
    private JPanel resultPanel;
    private List<Book> searchResult;
    public BookSearch(){
        setLayout(new BorderLayout());
        title = new JLabel("Welcome to ABC library");
        // title.setFont(new Font("Time New Romans", 5, 18));
        
        JPanel search = new JPanel(new GridLayout(1, 2));
        searchTextField = new JTextField(50);
        searchButton = new JButton("Search");
        // searchButton.setFont(new Font(getName(), 3, 15));
        // searchButton.setMaximumSize(new Dimension(20, 20));
        search.add(searchTextField);
        search.add(searchButton);

        resultPanel = new JPanel(new GridLayout(5, 1));
        searchResult = new ArrayList<>();

        add(title, BorderLayout.NORTH);
        add(search, BorderLayout.CENTER);
        resultPanel.add(new JLabel("Popular books"), LEFT_ALIGNMENT);
        add(resultPanel, BorderLayout.SOUTH);
        
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void addSearchButtonListener(ActionListener e){
        searchButton.addActionListener(e);
    }
    public void addResultToPanel(JComponent x){
        this.resultPanel.add(x);

    }

    public static void main(String[] args) {
        BookSearch search = new BookSearch();
        search.setVisible(true);
        EBook e = new EBook("123", "java introduction", "Tien Nguyen", model.Format.CHM);
        search.addResultToPanel(new JLabel(e.toString()));
        search.getContentPane().revalidate();
        search.getContentPane().repaint();
        
    }
}
