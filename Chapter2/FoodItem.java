// Subclass FoodItem
import java.util.Date;

public class FoodItem extends Product {
    private Date expirationDate;
    private String ingredients;
    private String nutritionalInformation;

    public FoodItem(String name, double price, String description, Date expirationDate, String ingredients, String nutritionalInformation) {
        super(name, price, description);
        this.expirationDate = expirationDate;
        this.ingredients = ingredients;
        this.nutritionalInformation = nutritionalInformation;
    }

    // Getters and setters
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getNutritionalInformation() {
        return nutritionalInformation;
    }

    public void setNutritionalInformation(String nutritionalInformation) {
        this.nutritionalInformation = nutritionalInformation;
    }

    // Method to check if the food item is expired
    public boolean isExpired() {
        return new Date().after(expirationDate);
    }
    
    @Override
    public void applyDiscount(double percentage) {
        setPrice(getPrice()*.80);
    }

    
}
