package swing;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library model = new Library();
        LibraryView view = new LibraryView();
        LibraryController controller = new LibraryController(model, view);

        view.setVisible(true);
    }
}
