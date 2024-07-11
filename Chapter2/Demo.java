import java.util.ArrayList;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Rectangle rectangle 
            = new Rectangle(50, 20);
        
        Square square = new Square(50);
        System.out.println(square.getLength());
        square.println();

        Product aProduct = 
            new FoodItem("Chicken", 10.5, "Chicken", new Date(), "Chicken", "Chicken");
        // FoodItem foodItem = new Product(null, 0, null);
        // ArrayList<Product> lItems = new ArrayList<>();
        // for (int i = 0; i < 5; i++) {
        //     FoodItem foodItem = new FoodItem("Item " + 1, i*10, "Item " + 1, new Date(), "Item " + 1, "Item " + 1);
        //     lItems.add(foodItem);
        // }
        // System.out.println(getAveragePrice(lItems));
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
