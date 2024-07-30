public class Demo {
    public static void main(String[] args) {
        
        Point<Number> point = new Point<>(10.0, 5.0);       
        display(point); 
        Point<Double> point2 = new Point<>(10.0, 5.0);       
        display(point2); 
    }

    static void display(Point<? extends Number> p){
        double x = p.getX().doubleValue();
        System.out.println(p);
    }
}
