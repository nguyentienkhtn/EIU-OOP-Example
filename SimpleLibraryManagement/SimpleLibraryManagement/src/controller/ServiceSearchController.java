package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

import model.Library;
import model.Service;
import view.ServiceSearchView;

public class ServiceSearchController {
    private Library model;
    private ServiceSearchView view;
    public ServiceSearchController(Library model, ServiceSearchView view) {
        this.model = model;
        this.view = view;
        this.view.addSearchButtonListener(new SearchAction());
    }
    private class SearchAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField searchTextField = view.getSearchTextField();
            DefaultListModel<Service> listModel = view.getListModel();
            List<Service> searchResults = new ArrayList<>();
            String keyString = searchTextField.getText();
            listModel.clear();
            searchResults.clear();
            searchResults = model.search(keyString);
            view.displayResult(searchResults);   
        }
       
    
        
    }
}
