import java.util.ArrayList;
import java.util.List;

/**
 * Represents a patron of the library.
 */
public class Patron {
    private String name;
    private String address;
    private String phoneNumber;
    private List<LibraryItem> borrowedItems;

    /**
     * Constructs a Patron with the specified details.
     *
     * @param name        the name of the patron
     * @param address     the address of the patron
     * @param phoneNumber the phone number of the patron
     */
    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new ArrayList<>();
    }

    // Getters and setters

    /**
     * Gets the name of the patron.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the patron.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address of the patron.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the patron.
     *
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the phone number of the patron.
     *
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the patron.
     *
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the list of items borrowed by the patron.
     *
     * @return the borrowedItems
     */
    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    /**
     * Borrows a library item.
     *
     * @param item the item to borrow
     */
    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    /**
     * Returns a library item.
     *
     * @param item the item to return
     */
    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
    }
}