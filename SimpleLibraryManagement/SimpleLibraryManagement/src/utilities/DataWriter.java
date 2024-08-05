package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.EBook;
import model.Format;
import model.PrintedBook;
import model.Room;
import model.Service;

public class DataWriter {
    public static void main(String[] args) {
        try (FileOutputStream fileOut = new FileOutputStream("services.dat");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            List<Service> services = new ArrayList<>();
            services.add(new EBook("12", "Introduction to computer programming", "Tony", Format.CHM));
            services.add(new PrintedBook("2", "To Kill a Mockingbird", "Harper Lee", 1));
            services.add(new PrintedBook("2", "To Kill a Mockingbird", "Harper Lee", 2));
            services.add(new Room("103", "Study room with computers", 10));
            for (Service service : services) {
                out.writeObject(service);
            }
            

            System.out.println("Serialized data is saved in services.dat");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
