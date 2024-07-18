import java.util.ArrayList;
import java.util.Date;
import java.io.File;
public class Demo {
    static double foo(int a, int b){
        a = a + 10;
        return (a+b)*1.0/2;

    }
    static void caution(Rectangle r){
        r.setLength(50);
    }
    public static void main(String[] args) {
        // File f = new File(); 
        ArrayList<Product> pItems = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            FoodItem foodItem = new FoodItem("Item " + 1, i*10, "Item " + 1, new Date(), "Item " + 1, "Item " + 1);
            pItems.add(foodItem);
        }
        System.out.println(getAveragePrice(pItems));
    }
    

    
    public static double getAveragePrice(ArrayList<Product> listProducts)
    {
        double sum = 0;
        for (Product product : listProducts) {
            sum += product.getPrice();
        }
        return sum/listProducts.size();
    }
}
