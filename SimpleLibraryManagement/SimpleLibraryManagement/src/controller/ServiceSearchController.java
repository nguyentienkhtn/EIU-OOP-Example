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
        this.view.addBookServiceAction(new BookListener());
    }
    private class SearchAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField searchTextField = view.getSearchTextField();
            List<Service> searchResults = new ArrayList<>();
            String keyString = searchTextField.getText();
            searchResults = model.search(keyString);
            view.displayResult(searchResults);   
        }
       
    
        
    }

    private class BookListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Service selectedService = view.getSelectedService();
            if (selectedService != null) {
                view.dispose();
                MainController.setServiceBookingView(view.getUser(), selectedService);

            }

        }
        
    }
}
