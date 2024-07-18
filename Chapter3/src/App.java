public class App {
    public static void main(String[] args) 
    {
        Calc abc = (a,b) -> a*b; //lambda expression
        
        Calc def = new Calc() {
            @Override
            public int mult(int a, int b) {
                return a*b;
            }
        };
        int result = abc.mult(10, 5);
        System.out.println(result);

    }
}
