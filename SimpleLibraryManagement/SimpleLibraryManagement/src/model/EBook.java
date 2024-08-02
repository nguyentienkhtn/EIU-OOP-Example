package model;


public class EBook extends Book{
    private static final long serialVersionUID = 1L;
    private Format format;
    
    public EBook(String isbn, String title, String author, Format format) {
        super(isbn, title, author);
        this.format = format;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + "isbn: " + getIsbn() + " title: " + getTitle() + " author: " + getAuthor() + " format: " + format.name();
    }

    @Override
    public void setIsAvailable(boolean isBorrowed) {
        
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    public Format getFormat() {
        return format;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof EBook))
            return false;
        else{
            EBook eBook = (EBook)obj;
            return (this.getIsbn().equals(eBook.getIsbn())) && this.getFormat().equals(eBook.getFormat());
        }
    }

    @Override
    public void setDueDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDueDate'");
    }
    
    
}
