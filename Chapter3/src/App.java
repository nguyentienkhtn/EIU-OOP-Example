public class App {
    public static void main(String[] args) 
    {
        // due to polymorphism
        Submit s = new Solution(); 
        s.addYourSignature();

        Submit s2 = new Submit() {// annonymous inner class

            @Override
            public void addYourSignature() {
                System.out.println("I'm so lazy, you are, too");
            }
            
        };
        s2.addYourSignature();

    }
}
