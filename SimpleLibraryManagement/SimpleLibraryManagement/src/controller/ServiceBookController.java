package controller;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Library;
import view.ServiceBookView;



public class ServiceBookController {
    private Library model;
    private ServiceBookView view;
    


    public ServiceBookController(Library model, ServiceBookView view) {
        this.model = model;
        this.view = view;
        this.view.addServiceBookingButtonListener(new BookButonListener());
    }



    private class  BookButonListener implements ActionListener{
       
        @Override
        public void actionPerformed(ActionEvent e) {
            model.bookService(view.getBorrowingUser(), view.getSelectedService(), 1);
            view.setBookingButtonEnable(false);
            JOptionPane.showMessageDialog(view, "Booked service: " + view.getSelectedService());  
            // view.dispose();
                    
        }
            
    }
}
