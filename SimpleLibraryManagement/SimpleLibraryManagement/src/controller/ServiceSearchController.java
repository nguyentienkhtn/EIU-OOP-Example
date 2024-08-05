package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Library;
import view.ServiceSearchView;

public class ServiceSearchController {
    private Library model;
    private ServiceSearchView view;
    public ServiceSearchController(Library model, ServiceSearchView view) {
        this.model = model;
        this.view = view;
    }
    private class SearchAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    
        
    }

}
