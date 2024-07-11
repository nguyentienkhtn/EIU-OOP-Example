public class Square extends Rectangle{
    
    public Square(int side){
        super(side, side);
    }
    public void setSide(int side){
        setLength(side);
        setWidth(side);
    }
}
