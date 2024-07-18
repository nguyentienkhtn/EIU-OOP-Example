public class App {
    public static void main(String[] args) 
    {
        Interface3 i = () -> 
        {  
            System.out.println("So so"); 
            System.out.println("So so");
        };
        Calc2 calc2 = (a, b) -> {
            int c = b*a;
            System.out.println(c);
        };
        calc2.mult(10, 10);

        Calc abc = (a,b) -> a*b; //lambda expression
        
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
