package swing;

// LibraryController.java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryController {
    private Library model;
    private LibraryView view;

    public LibraryController(Library model, LibraryView view) {
        this.model = model;
        this.view = view;

        view.getAddBookButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        view.getListBooksButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listBooks();
            }
        });
    }

    private void addBook() {
        String id = view.getBookIdField().getText();
        String title = view.getBookTitleField().getText();
        String author = view.getBookAuthorField().getText();

        Book book = new Book(id, title, author);
        model.addBook(book);

        view.getBookIdField().setText("");
        view.getBookTitleField().setText("");
        view.getBookAuthorField().setText("");
    }

    private void listBooks() {
        view.displayBooks(model.getBooks());
    }
}
