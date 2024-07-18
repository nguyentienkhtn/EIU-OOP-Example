public class Rectangle {
    private int width;
    private int length;
    protected void println(){
        System.out.println("hello from father");
    }

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }
    public Rectangle (Rectangle rectangle){
        this.width = rectangle.getWidth();
        this.length = rectangle.getLength();
        // copy constructor
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public int getArea(){
        return width * length;
    }
    

}
