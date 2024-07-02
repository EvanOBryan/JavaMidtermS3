import java.util.ArrayList;
import java.util.List;

/**
 * Represents the library containing items, authors, and patrons.
 */
public class Library {
    private List<LibraryItem> items;
    private List<Author> authors;
    private List<Patron> patrons;

    /**
     * Constructs a Library.
     */
    public Library() {
        items = new ArrayList<>();
        authors = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    /**
     * Adds a library item.
     *
     * @param item the item to add
     */
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    /**
     * Removes a library item.
     *
     * @param item the item to remove
     */
    public void removeItem(LibraryItem item) {
        items.remove(item);
    }

    /**
     * Finds a library item by its ID.
     *
     * @param id the ID of the item
     * @return the library item, or null if not found
     */
    public LibraryItem findItemById(String id) {
        for (LibraryItem item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Adds an author.
     *
     * @param author the author to add
     */
    public void addAuthor(Author author) {
        authors.add(author);
    }

    /**
     * Removes an author.
     *
     * @param author the author to remove
     */
    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    /**
     * Finds an author by name.
     *
     * @param name the name of the author
     * @return the author, or null if not found
     */
    public Author findAuthorByName(String name) {
        for (Author author : authors) {
            if (author.getName().equals(name)) {
                return author;
            }
        }
        return null;
    }

    /**
     * Adds a patron.
     *
     * @param patron the patron to add
     */
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    /**
     * Removes a patron.
     *
     * @param patron the patron to remove
     */
    public void removePatron(Patron patron) {
        patrons.remove(patron);
    }

    /**
     * Finds a patron by name.
     *
     * @param name the name of the patron
     * @return the patron, or null if not found
     */
    public Patron findPatronByName(String name) {
        for (Patron patron : patrons) {
            if (patron.getName().equals(name)) {
                return patron;
            }
        }
        return null;
    }

    /**
     * Borrows an item for a patron.
     *
     * @param patronName the name of the patron
     * @param itemId     the ID of the item
     */
    public void borrowItem(String patronName, String itemId) {
        Patron patron = findPatronByName(patronName);
        LibraryItem item = findItemById(itemId);
        if (patron != null && item != null && item.getNumCopies() > 0) {
            patron.borrowItem(item);
            item.setNumCopies(item.getNumCopies() - 1);
        }
    }

    /**
     * Returns an item for a patron.
     *
     * @param patronName the name of the patron
     * @param itemId     the ID of the item
     */
    public void returnItem(String patronName, String itemId) {
        Patron patron = findPatronByName(patronName);
        LibraryItem item = findItemById(itemId);
        if (patron != null && item != null && patron.getBorrowedItems().contains(item)) {
            patron.returnItem(item);
            item.setNumCopies(item.getNumCopies() + 1);
        }
    }

    /**
     * Searches for items by title.
     *
     * @param title the title to search for
     * @return the list of matching items
     */
    public List<LibraryItem> searchItemsByTitle(String title) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Searches for items by author name.
     *
     * @param authorName the author name to search for
     * @return the list of matching items
     */
    public List<LibraryItem> searchItemsByAuthor(String authorName) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getAuthor().getName().equalsIgnoreCase(authorName)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Searches for items by ISBN.
     *
     * @param isbn the ISBN to search for
     * @return the list of matching items
     */
    public List<LibraryItem> searchItemsByIsbn(String isbn) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getIsbn().equals(isbn)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Searches for borrowed items by title for a patron.
     *
     * @param patronName the name of the patron
     * @param title      the title to search for
     * @return the list of matching borrowed items
     */
    public List<LibraryItem> searchBorrowedItemsByTitle(String patronName, String title) {
        Patron patron = findPatronByName(patronName);
        if (patron == null) {
            return null;
        }
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : patron.getBorrowedItems()) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Searches for borrowed items by author name for a patron.
     *
     * @param patronName the name of the patron
     * @param authorName the author name to search for
     * @return the list of matching borrowed items
     */
    public List<LibraryItem> searchBorrowedItemsByAuthor(String patronName, String authorName) {
        Patron patron = findPatronByName(patronName);
        if (patron == null) {
            return null;
        }
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : patron.getBorrowedItems()) {
            if (item.getAuthor().getName().equalsIgnoreCase(authorName)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Searches for borrowed items by ISBN for a patron.
     *
     * @param patronName the name of the patron
     * @param isbn       the ISBN to search for
     * @return the list of matching borrowed items
     */
    public List<LibraryItem> searchBorrowedItemsByIsbn(String patronName, String isbn) {
        Patron patron = findPatronByName(patronName);
        if (patron == null) {
            return null;
        }
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : patron.getBorrowedItems()) {
            if (item.getIsbn().equals(isbn)) {
                result.add(item);
            }
        }
        return result;
    }
}