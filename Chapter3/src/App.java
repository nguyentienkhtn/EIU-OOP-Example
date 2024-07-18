public class App {
    public static void main(String[] args) 
    {
        Calc abc = (a,b) -> a*b; //lambda expression

        int result = abc.mult(10, 5);
        System.out.println(result);

    }
}
