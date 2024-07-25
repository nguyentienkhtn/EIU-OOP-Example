import java.util.ArrayDeque;
import java.util.Deque;
public class App {
    public static void main(String[] args) 
    {
        Deque<String> deque = new ArrayDeque<>();

        // Add elements at the end
        deque.addLast("Element 1");
        deque.addLast("Element 2");
        deque.addLast("Element 3");

        // Add elements at the front
        deque.addFirst("Element 0");

        // Display the elements
        System.out.println("Deque: " + deque);

        // Remove elements from the front
        System.out.println("Removed from front: " + deque.removeFirst());

        // Remove elements from the end
        System.out.println("Removed from end: " + deque.removeLast());

        // Display the elements
        System.out.println("Deque after removals: " + deque);
        // Interface3 i = () -> 
        // {  
        //     System.out.println("So so"); 
        //     System.out.println("So so");
        // };
        // Calc2 calc2 = (a, b) -> {
        //     int c = b*a;
        //     System.out.println(c);
        // };
        // calc2.mult(10, 10);

        // Calc abc = (a,b) -> a*b; //lambda expression
        
        // Calc def = new Calc() {
        //     @Override
        //     public int mult(int a, int b) {
        //         return a*b;
        //     }
        // };
        // int result = abc.mult(10, 5);
        // System.out.println(result);

    }
}
