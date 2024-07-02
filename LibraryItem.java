/**
 * Represents an item in the library.
 */
public class LibraryItem {
    private String id;
    private String title;
    private Author author;
    private String isbn;
    private String publisher;
    private int numCopies;

    /**
     * Constructs a LibraryItem with the specified details.
     *
     * @param id        the unique identifier of the item
     * @param title     the title of the item
     * @param author    the author of the item
     * @param isbn      the ISBN of the item
     * @param publisher the publisher of the item
     * @param numCopies the number of copies available
     */
    public LibraryItem(String id, String title, Author author, String isbn, String publisher, int numCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.numCopies = numCopies;
    }

    // Getters and setters

    /**
     * Gets the unique identifier of the item.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the item.
     *
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the title of the item.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the item.
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the author of the item.
     *
     * @return the author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Sets the author of the item.
     *
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * Gets the ISBN of the item.
     *
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the item.
     *
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets the publisher of the item.
     *
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets the publisher of the item.
     *
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets the number of copies available.
     *
     * @return the numCopies
     */
    public int getNumCopies() {
        return numCopies;
    }

    /**
     * Sets the number of copies available.
     *
     * @param numCopies the numCopies to set
     */
    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }
}