import java.util.List;
import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Add authors
        Author author1 = new Author("J.K. Rowling", "1965-07-31");
        Author author2 = new Author("George Orwell", "1903-06-25");
        Author author3 = new Author("J.R.R. Tolkien", "1892-01-03");

        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addAuthor(author3);

        // Add library items
        LibraryItem item1 = new LibraryItem("1", "Harry Potter and the Philosopher's Stone", author1, "9780747532699", "Bloomsbury", 5);
        LibraryItem item2 = new LibraryItem("2", "Harry Potter and the Chamber of Secrets", author1, "9780747538493", "Bloomsbury", 4);
        LibraryItem item3 = new LibraryItem("3", "1984", author2, "9780451524935", "Secker & Warburg", 6);
        LibraryItem item4 = new LibraryItem("4", "Animal Farm", author2, "9780451526342", "Secker & Warburg", 3);
        LibraryItem item5 = new LibraryItem("5", "The Hobbit", author3, "9780261102217", "George Allen & Unwin", 2);
        LibraryItem item6 = new LibraryItem("6", "The Fellowship of the Ring", author3, "9780261103573", "George Allen & Unwin", 4);
        LibraryItem item7 = new LibraryItem("7", "The Two Towers", author3, "9780261103580", "George Allen & Unwin", 4);
        LibraryItem item8 = new LibraryItem("8", "The Return of the King", author3, "9780261103597", "George Allen & Unwin", 4);
        LibraryItem item9 = new LibraryItem("9", "The Silmarillion", author3, "9780261102736", "George Allen & Unwin", 3);
        LibraryItem item10 = new LibraryItem("10", "Fantastic Beasts and Where to Find Them", author1, "9781408880715", "Bloomsbury", 3);

        library.addItem(item1);
        library.addItem(item2);
        library.addItem(item3);
        library.addItem(item4);
        library.addItem(item5);
        library.addItem(item6);
        library.addItem(item7);
        library.addItem(item8);
        library.addItem(item9);
        library.addItem(item10);
        // Add patrons
        Patron patron1 = new Patron("Alice", "123 Main St", "555-1234");
        Patron patron2 = new Patron("Bob", "456 Elm St", "555-5678");
        library.addPatron(patron1);
        library.addPatron(patron2);
        // Patron1 borrows some items
        library.borrowItem("Alice", "1");
        library.borrowItem("Alice", "3");
        // Patron2 borrows some items
        library.borrowItem("Bob", "5");
        library.borrowItem("Bob", "6");
        // Main menu
        while (true) {
            System.out.println("Library Management System:");
            System.out.println("1. Add Library Item");
            System.out.println("2. Edit Library Item");
            System.out.println("3. Delete Library Item");
            System.out.println("4. Add Author");
            System.out.println("5. Edit Author");
            System.out.println("6. Delete Author");
            System.out.println("7. Add Patron");
            System.out.println("8. Edit Patron");
            System.out.println("9. Delete Patron");
            System.out.println("10. Borrow Item");
            System.out.println("11. Return Item");
            System.out.println("12. Search Patron Borrowed Books");
            System.out.println("13. Search Library Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    // Add Library Item
                    System.out.print("Enter item ID: ");
                    String itemId = scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String authorName = scanner.nextLine();
                    Author author = library.findAuthorByName(authorName);
                    if (author == null) {
                        System.out.println("Author not found. Please add the author first.");
                        break;
                    }
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter number of copies: ");
                    int numCopies = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    LibraryItem newItem = new LibraryItem(itemId, title, author, isbn, publisher, numCopies);
                    library.addItem(newItem);
                    System.out.println("Library item added successfully.");
                    break;
                case 2:
                    // Edit Library Item
                    System.out.print("Enter Item ID to edit: ");
                    String itemIdToEdit = scanner.nextLine();
                    LibraryItem itemToEdit = library.findItemById(itemIdToEdit);
                    if (itemToEdit != null) {
                        System.out.print("Enter new title: ");
                        itemToEdit.setTitle(scanner.nextLine());
                        System.out.print("Enter new ISBN: ");
                        itemToEdit.setIsbn(scanner.nextLine());
                        System.out.print("Enter new publisher: ");
                        itemToEdit.setPublisher(scanner.nextLine());
                        System.out.print("Enter new number of copies: ");
                        itemToEdit.setNumCopies(scanner.nextInt());
                        scanner.nextLine();  // consume newline
                        System.out.println("Item updated successfully.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 3:
                    // Delete Library Item
                    System.out.print("Enter Item ID to delete: ");
                    String itemIdToDelete = scanner.nextLine();
                    LibraryItem itemToDelete = library.findItemById(itemIdToDelete);
                    if (itemToDelete != null) {
                        library.removeItem(itemToDelete);
                        System.out.println("Item deleted successfully.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 4:
                    // Add Author
                    System.out.print("Enter author name: ");
                    String newAuthorName = scanner.nextLine();
                    System.out.print("Enter author date of birth (YYYY-MM-DD): ");
                    String dob = scanner.nextLine();
                    Author newAuthor = new Author(newAuthorName, dob);
                    library.addAuthor(newAuthor);
                    System.out.println("Author added successfully.");
                    break;
                case 5:
                    // Edit Author
                    System.out.print("Enter Author name to edit: ");
                    String authorNameToEdit = scanner.nextLine();
                    Author authorToEdit = library.findAuthorByName(authorNameToEdit);
                    if (authorToEdit != null) {
                        System.out.print("Enter new date of birth: ");
                        authorToEdit.setDateOfBirth(scanner.nextLine());
                        System.out.println("Author updated successfully.");
                    } else {
                        System.out.println("Author not found.");
                    }
                    break;
                case 6:
                    // Delete Author
                    System.out.print("Enter Author name to delete: ");
                    String authorNameToDelete = scanner.nextLine();
                    Author authorToDelete = library.findAuthorByName(authorNameToDelete);
                    if (authorToDelete != null) {
                        library.removeAuthor(authorToDelete);
                        System.out.println("Author deleted successfully.");
                    } else {
                        System.out.println("Author not found.");
                    }
                    break;
                case 7:
                    // Add Patron
                    System.out.print("Enter patron name: ");
                    String patronName = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    Patron newPatron = new Patron(patronName, address, phoneNumber);
                    library.addPatron(newPatron);
                    System.out.println("Patron added successfully.");
                    break;
                case 8:
                    // Edit Patron
                    System.out.print("Enter Patron name to edit: ");
                    String patronNameToEdit = scanner.nextLine();
                    Patron patronToEdit = library.findPatronByName(patronNameToEdit);
                    if (patronToEdit != null) {
                        System.out.print("Enter new address: ");
                        patronToEdit.setAddress(scanner.nextLine());
                        System.out.print("Enter new phone number: ");
                        patronToEdit.setPhoneNumber(scanner.nextLine());
                        System.out.println("Patron updated successfully.");
                    } else {
                        System.out.println("Patron not found.");
                    }
                    break;
                case 9:
                    // Delete Patron
                    System.out.print("Enter Patron name to delete: ");
                    String patronNameToDelete = scanner.nextLine();
                    Patron patronToDelete = library.findPatronByName(patronNameToDelete);
                    if (patronToDelete != null) {
                        library.removePatron(patronToDelete);
                        System.out.println("Patron deleted successfully.");
                    } else {
                        System.out.println("Patron not found.");
                    }
                    break;
                case 10:
                    // Borrow Item
                    System.out.print("Enter Patron name: ");
                    String patronNameToBorrow = scanner.nextLine();
                    System.out.print("Enter Item ID to borrow: ");
                    String itemIdToBorrow = scanner.nextLine();
                    library.borrowItem(patronNameToBorrow, itemIdToBorrow);
                    break;
                case 11:
                    // Return Item
                    System.out.print("Enter Patron name: ");
                    String patronNameToReturn = scanner.nextLine();
                    System.out.print("Enter Item ID to return: ");
                    String itemIdToReturn = scanner.nextLine();
                    library.returnItem(patronNameToReturn, itemIdToReturn);
                    break;
                case 12:
                    System.out.print("Enter patron name: ");
                    patronName = scanner.nextLine();
                    System.out.print("Search by (1) Title (2) Author (3) ISBN: ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    List<LibraryItem> borrowedItems = null;
                    switch (searchChoice) {
                        case 1:
                            System.out.print("Enter title: ");
                            String searchTitle = scanner.nextLine();
                            borrowedItems = library.searchBorrowedItemsByTitle(patronName, searchTitle);
                            break;
                        case 2:
                            System.out.print("Enter author name: ");
                            String searchAuthorName = scanner.nextLine();
                            borrowedItems = library.searchBorrowedItemsByAuthor(patronName, searchAuthorName);
                            break;
                        case 3:
                            System.out.print("Enter ISBN: ");
                            String searchIsbn = scanner.nextLine();
                            borrowedItems = library.searchBorrowedItemsByIsbn(patronName, searchIsbn);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    if (borrowedItems != null) {
                        for (LibraryItem item : borrowedItems) {
                            System.out.println("ID: " + item.getId() + ", Title: " + item.getTitle() + ", Author: " + item.getAuthor().getName() + ", ISBN: " + item.getIsbn());
                        }
                    } else {
                        System.out.println("No items found.");
                    }
                    break;
                case 13:
                    System.out.print("Search by (1) Title (2) Author (3) ISBN: ");
                    searchChoice = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    List<LibraryItem> libraryItems = null;
                    switch (searchChoice) {
                        case 1:
                            System.out.print("Enter title: ");
                            String searchTitle = scanner.nextLine();
                            libraryItems = library.searchItemsByTitle(searchTitle);
                            break;
                        case 2:
                            System.out.print("Enter author name: ");
                            String searchAuthorName = scanner.nextLine();
                            libraryItems = library.searchItemsByAuthor(searchAuthorName);
                            break;
                        case 3:
                            System.out.print("Enter ISBN: ");
                            String searchIsbn = scanner.nextLine();
                            libraryItems = library.searchItemsByIsbn(searchIsbn);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    if (libraryItems != null) {
                        for (LibraryItem item : libraryItems) {
                            System.out.println("ID: " + item.getId() + ", Title: " + item.getTitle() + ", Author: " + item.getAuthor().getName() + ", ISBN: " + item.getIsbn());
                        }
                    } else {
                        System.out.println("No items found.");
                    }
                    break;
                case 0:
                    // Exit
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}