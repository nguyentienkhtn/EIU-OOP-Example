package controller;

import java.util.ArrayList;
import java.util.List;

import model.Library;
import model.Service;
import model.User;
import view.LoginView;
import view.ServiceBookView;
import view.ServiceSearchView;

public class MainController {
    private static Library model;
    private static LoginView loginView;
    private static ServiceSearchView searchView;
    private static ServiceBookView serviceBookView;
    private static LoginController loginController;
    private static ServiceSearchController searchController;
    private static ServiceBookController bookingController;

    private static User loggedInUser;
    public static void main(String[] args) {
        
        
        model = new Library();
        model.loadServicesFromFile("services.dat");;
        model.loadUsersFromFile("users.dat");
        List<Service> loadedServices = model.getServices();
        loginView = new LoginView();
        loginController = new LoginController(model, loginView);
        
        searchView = new ServiceSearchView();
        

        
        
        
        loginView.setVisible(true);



    }
    public static void setLoggedInUser(User loggedInUser) {
        MainController.loggedInUser = loggedInUser;
        searchView = new ServiceSearchView();
        searchView.setLoggedInUser(loggedInUser);
        searchController = new ServiceSearchController(model, searchView);
        searchView.setVisible(true);

    }
    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setServiceBookingView(User user, Service selectedService){
        serviceBookView = new ServiceBookView();
        serviceBookView.setBorrowingUser(user);
        serviceBookView.setSelectedService(selectedService);
        serviceBookView.setVisible(true);
        bookingController = new ServiceBookController(model, serviceBookView);
    }

    
}
