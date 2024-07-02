import java.util.ArrayList;
import java.util.List;

/**
 * Represents an author of library items.
 */
public class Author {
    private String name;
    private String dateOfBirth;
    private List<LibraryItem> items;

    /**
     * Constructs an Author with the specified name and date of birth.
     *
     * @param name        the name of the author
     * @param dateOfBirth the date of birth of the author
     */
    public Author(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.items = new ArrayList<>();
    }

    // Getters and setters

    /**
     * Gets the name of the author.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the author.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the date of birth of the author.
     *
     * @return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the author.
     *
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the list of items written by the author.
     *
     * @return the items
     */
    public List<LibraryItem> getItems() {
        return items;
    }

    /**
     * Adds a library item to the author's list of items.
     *
     * @param item the item to add
     */
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    /**
     * Removes a library item from the author's list of items.
     *
     * @param item the item to remove
     */
    public void removeItem(LibraryItem item) {
        items.remove(item);
    }
}