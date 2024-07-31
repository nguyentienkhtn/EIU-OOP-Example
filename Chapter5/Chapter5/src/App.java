import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("data.txt");
        Scanner scanner = new Scanner(f);
        // try {
        //     Scanner scanner = new Scanner(f);
        //     int s = scanner.nextInt();
        //     scanner.close();
        // } 
        // catch (Exception e) {
        //     System.out.println("Er error kia");
        //     System.out.println(e.getLocalizedMessage());
        //     e.printStackTrace();
        // }
        System.out.println("hello");
        

    }
}
