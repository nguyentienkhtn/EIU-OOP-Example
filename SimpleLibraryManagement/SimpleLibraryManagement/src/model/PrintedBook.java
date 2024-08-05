package model;

public class PrintedBook extends Book{
    private static final long serialVersionUID = 1L;
    private int copyID;
    public PrintedBook(String isbn, String title, String author, int copyID) {
        super(isbn, title, author);
        this.copyID = copyID;
        super.setIsAvailable(true);
    }
    
    public int getCopyID() {
        return copyID;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof PrintedBook))
            return false;
        else{
            PrintedBook pBook = (PrintedBook)obj;
            return (this.getIsbn().equals(pBook.getIsbn())) && (this.getCopyID() == pBook.getCopyID());
        }
    }
    
    
    

    @Override
    public String toString() {
        return "PrintedBook [isbn=" + getIsbn() + ", title=" + getTitle() + ", author="+getAuthor() + ",copy id=" + getCopyID() + ", available=" + isAvailable() + "]";
    }
    
    
}
