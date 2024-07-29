package model;

public class EBook extends Book{
    private Format format;

    public EBook(String isbn, String title, String author, Format format) {
        super(isbn, title, author);
        this.format = format;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + "isbn: " + getIsbn() + " title: " + getTitle() + " author: " + getAuthor() + "format: " + format.name();
    }

    @Override
    public void setBorrowed(boolean isBorrowed) {
        
    }

    @Override
    public boolean isBorrowed() {
        return false;
    }

    public Format getFormat() {
        return format;
    }
    
}
