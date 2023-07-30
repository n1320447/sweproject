import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Library {
    Scanner scanner;
    int userCount = 0;
    int itemCount = 0;
    int day = 0;
    List<User> users = new ArrayList<>();
    List<Staff> staff = new ArrayList<>();
    List<Book> books = new ArrayList<>();

    List<AudioVideoMaterial> avMaterials = new ArrayList<>();
    List<ItemRequest> itemRequestList = new ArrayList<>();
    List<Magazines> magazines = new ArrayList<>();
// Add methods to handle magazines as needed.
    Library(){
        scanner = new Scanner(System.in);
        System.out.println("new library made");

        //create 2 users as soon as library object is created.
        /*User newUser = new User("nestor1", "password1", "nestor@gmail.com", "Nestor", "Govea");
        users.add(newUser);
        User newUser2 = new User("mike2", "mpassword", "mike@gmail.com", "Mike", "Smith");
        users.add(newUser2);*/
        addUser("nestor1", "password1", "nestor@gmail.com", "Nestor", "Govea", 22);
        addUser("mike2", "mpassword", "mike@gmail.com", "Mike", "Smith", 10);


        // increment userCount by 2
        // userCount += 2;

        //add in list of books
            // Create and add books
        // Book book1 = new Book("Book Title 1", "Author 1", 2000, false, 5);
        // books.add(book1);
        
        // Book book2 = new Book("Book Title 2", "Author 2", 2010, false, 3.2);
        // books.add(book2);

        

        Book book1 = new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954, false, 5);
        books.add(book1);

        Book book2 = new Book("The Two Towers", "J.R.R. Tolkien", 1954, false, 3.2);
        books.add(book2);

        Book book3 = new Book("The Return of the King", "J.R.R. Tolkien", 1955, false, 4.8);
        books.add(book3);




        

        //add in list of AV Materials

        // Set the library in needed classes
        Return.setLibrary(this);
        Checkout.setLibrary(this);

        users.get(0).getLibraryCard().checkOutBook(book1, getDay());
        users.get(0).getLibraryCard().changeFines(50);
        addRequest(users.get(0).getLibraryCard(), book2);

        System.out.println(users.get(0).getLibraryCard().getFines());
        System.out.println(itemRequestList);
    }

    public void libraryMenu(){
        int choice = 0;
        

        while (choice != 9) {
        System.out.println("Please choose what to do by the number.");
        System.out.println("1. Create Account");
        System.out.println("2. View which items are checked out.");
        System.out.println("3. Get number of Accounts in System.");
        System.out.println("4. Checkout an Item");
        System.out.println("5. Add item to library (book or audio/visual)");
        System.out.println("6. Add Magazine to library");
        System.out.println("7. Return book");
        System.out.println("8. Get Fines.");
        System.out.println("9. Exit");
        
        choice = getUserChoice();


        System.out.println("You selected option: " + choice);

        
        switch (choice) {
            case 1:
                System.out.println(" Create Account.");
                System.out.println();
                String userName = "";
                String passWord = "";
                String email = "";
                System.out.println("enter username");
                scanner = new Scanner(System.in);
                userName = scanner.nextLine();
                System.out.println("Enter password.");
                scanner = new Scanner(System.in);
                userName = scanner.nextLine();
                System.out.println("enter email.");
                scanner = new Scanner(System.in);
                email = scanner.nextLine();

                System.out.println("Select account type:");
                System.out.println("1. User");
                System.out.println("2. Staff");
                int accountType = scanner.nextInt();
                scanner.nextLine();
        
                switch (accountType) {
                    case 1:
                        System.out.println("Creating User account.");
                        System.out.println();
                        System.out.println("Enter first name:");
                        String firstName = scanner.nextLine();
        
                        System.out.println("Enter last name:");
                        String lastName = scanner.nextLine();

                        System.out.println("Enter age:");
                        int age = Integer.parseInt(scanner.nextLine());

                        addUser(userName, passWord, email, firstName, lastName, age);

                        // Add any additional logic for User account creation
                        break;
                    case 2:
                        System.out.println("Creating Staff account.");
                        System.out.println();
                        System.out.println("Enter staff ID:");
                        String staffId = scanner.nextLine();
        
                        System.out.println("Enter department:");
                        String department = scanner.nextLine();
        
                        Staff newStaff = new Staff(userName, passWord, email, staffId, department);
                        staff.add(newStaff);
                        // Add any additional logic for Staff account creation
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a valid number.");
                        System.out.println();
                        break;
                }

                userCount += 1;
                // Account newAccount = new Account(userName, passWord, email);
                break;
            case 2:
                // System.out.println(books);
                Boolean atLeast1CheckedOut = false;
                System.out.println("Is a staff or user requesting checked out books?");
                System.out.println("1. Staff");
                System.out.println("2. User");
                int choice2 = getUserChoice();
                
                switch(choice2){
                    case 1:
                        //staff
                        System.out.println("enter staff code:");
                        int code = getUserChoice();
                        //check code for a match somewhere
                        for (int i = 0; i < books.size(); i++) {
                    
                            if(books.get(i).isCheckedOut() == true){
                                // System.out.println(books.get(i).getTitle());
                                System.out.println(users.get(i));
                                users.get(i).getLibraryCard().displayCheckedout();
                                System.out.println("");
                                atLeast1CheckedOut = true;
                            }
                
                        }
                    break;

                    case 2:
                    //user
                        User userChoice = selectUser();
                        userChoice.getLibraryCard().displayCheckedout();
                    break;
                }
     
                if (!atLeast1CheckedOut){
                    System.out.println("no books are checked out currently.");
                }
                
                break;
            case 3:
                System.out.println(" User count is: " + getNumberOfUsers());
                System.out.println();
                System.out.println(users);
                break;
            case 4:
                System.out.println("Please select what type of checkout.");
                System.out.println("1. Checkout Book");
                System.out.println("2. Renew Book");
                int checkoutType = scanner.nextInt();
                scanner.nextLine();

                switch(checkoutType){
                    case 1:
                        // System.out.println(books);
                        // System.out.println(books);
                        System.out.println("Please select a User to check out a book for.");
                        User selectedUser = selectUser();
                        Book selectedBook = selectBook();
                        // System.out.println(book);
                        // System.out.println(selectedUser);

                        System.out.println(selectedUser.getLibraryCard());
                        if (selectedUser != null){
                            selectedUser.getLibraryCard().checkOutBook(selectedBook, getDay());
                        }
                        break;
                    case 2:
                        System.out.println("Please select a User to renew a book for.");
                        User userChoice = selectUser();
                        Book bookChoice = selectBook();

                        System.out.println(userChoice.getLibraryCard());
                        if (userChoice != null){
                            userChoice.getLibraryCard().renewBook(bookChoice, getDay());
                        }
                }

                break;
            case 5:
                System.out.println(" Add Item.");
                System.out.println();

                String title = "";
                String lastName = "";
                int year = 0;
                String bestseller = "";
                double value = 0;

                System.out.println("please enter the title.");
                scanner = new Scanner(System.in);
                title = scanner.nextLine();

                System.out.println("please enter last name of author/director.");
                scanner = new Scanner(System.in);
                lastName = scanner.nextLine();

                System.out.println("please enter the year the item was released.");
                scanner = new Scanner(System.in);
                year = Integer.parseInt(scanner.nextLine());

                System.out.println("please enter the value of the item.");
                scanner = new Scanner(System.in);
                value = Double.parseDouble(scanner.nextLine());

                System.out.println("Please choose if item will be a book or audio/video item.");
                System.out.println("1. Book");
                System.out.println("2. Audio/Video");

                scanner = new Scanner(System.in);
                if(scanner.nextInt() == 1){
                    //Item newItem = new Item(lastName, choice, Item.ItemType.BOOK);
                    System.out.println("Is this book a bestseller? (y/n)");
                    scanner = new Scanner(System.in);
                    bestseller = scanner.nextLine();

                    Book newItem;
                    if(bestseller.contains("y") || bestseller.contains("Y"))
                        newItem = new Book(title, lastName, year, true, value);
                    else
                        newItem = new Book(title, lastName, year, false, value);
                    books.add(newItem);

                    System.out.println("New Book item created");

                } else {
                    //Item newItem = new Item(lastName, choice, Item.ItemType.AUDIO_VIDEO_MATERIAL);
                    AudioVideoMaterial newItem = new AudioVideoMaterial(title, lastName, year);
                    avMaterials.add(newItem);
                    System.out.println("New AV item created");
                }
                itemCount += 1;
                break;

            case 6:
                System.out.println(" Add Magazine.");
                // ... (Add the logic for creating and adding a new magazine)
                break;
            case 7:
                System.out.println("Please select a User to return a book for.");
                User selectedUser2 = selectUser();
                Book selectedBook2 = selectBook();

                System.out.println(selectedUser2.getLibraryCard());
                if (selectedUser2 != null){
                    selectedUser2.getLibraryCard().returnBook(selectedBook2);
                }
                break;
            case 8:
                System.out.println("Get fines.");
                User getFineUser = selectUser();
                if (getFineUser.getLibraryCard().getFines() == 0){
                    System.out.println("No fines.");
                    break;
                }
                System.out.println("Fines for " + getFineUser.getFirstName() + ": " + getFineUser.getLibraryCard().getFines());
                break;
            case 9:
                System.out.println(" Exiting the library system. Goodbye!");
                System.out.println();
                break;
            
            default:
                System.out.println(" Invalid option. Please choose a valid number.");
                System.out.println();
                break;
            }
        }
    }

    private int getUserChoice(){
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public int getNumberOfUsers(){
        return userCount;
    }

    public User selectUser(){
        int selectedIndex = getUserIndex();

        if (selectedIndex >= 0 && selectedIndex <= users.size()){
            return users.get(selectedIndex-1);
        } else {
            System.out.println("Invalid user selection.");
            return null;
        }
    }

    public int getUserIndex(){
        System.out.println("Available Users:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i).getFirstName());

        }
        Scanner scanner = new Scanner(System.in);
        int selectedIndex = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        return selectedIndex;

    }

    // Method to allow user to select a specific book from the library
    public Book selectBook() {
        // Display a list of available books to the user and prompt for selection
        // For example, you can use the libaryMenu() method to display a list of books and get user input.
        // In this example, we'll assume that the user selects a book by its index in the books list.
        int selectedIndex = getUserBookSelection(); // You need to implement this method to get the user's book selection.

        // Retrieve the selected book from the books list
        if (selectedIndex >= 0 && selectedIndex <= books.size()) {
            return books.get(selectedIndex-1);
        } else {
            System.out.println("Invalid book selection.");
            return null;
        }
    }

        // Method to allow the user to select a book by its index
    private int getUserBookSelection() {
        System.out.println("Select a book by its index:");
        displayAvailableBooks(); // Display a list of available books (you need to implement this method)

        Scanner scanner = new Scanner(System.in);
        int selectedIndex = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        return selectedIndex;
    }

            // Method to display a list of available books to the user
    private void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i).getTitle() + ", is checked out?: " + books.get(i).isCheckedOut());
        }
    }

    public boolean addRequest(LibraryCard card, Item item) {
        if (item.isCheckedOut()) // might not need this
            return false;

        // Check if there is already a request for the item. Only 1 outstanding request allowed per item
        for (ItemRequest request: itemRequestList)
            if (request.item == item)
                return false;

        ItemRequest request = new ItemRequest(card, item);
        itemRequestList.add(request);
        return true;
    }

    // Method to remove a request from the item request list
    public void removeRequest(ItemRequest request) {
        itemRequestList.remove(request);
    }

    // Method is called when an item is returned. If the item has an outstanding request,
    // then item is automatically checked out to the requesting user.
    // Returns null if there is no requests for book
    public LibraryCard checkRequests(Item returnedItem) {
        for (ItemRequest request: itemRequestList)
            if(request.item == returnedItem) {
                if (returnedItem.getItemType() == Item.ItemType.BOOK){
                    Book book = (Book) returnedItem;
                    User user  = request.card.getUser();
                    System.out.println(user.getFirstName() + " " + user.getLastName() + " requested book "
                            + book.getTitle() + ", attempting to check out book");
                    //request.card.checkOutBook(book, getDay());
                }
                else {
                    AudioVideoMaterial av = (AudioVideoMaterial) returnedItem;
                    //request.card.checkOutAV(av, getDay());
                }
                removeRequest(request);
                return request.card;
            }
        return null;
    }

    public int getDay() {
        return day;
    }

    // Method to update the systems date
    private void incrementDay() {
        day++;
    }

    // Method to add user to the system. probably need this not public
    public void addUser(String username, String pass, String email, String first, String last, int age) {
        User newUser = new User(username, pass, email, first, last, age, this);
        users.add(newUser);
        userCount++;
    }

    // Method to add staff member to the system, probably need this not public
    public void addStaff(String username, String password, String email, String staffId, String department) {
        Staff newStaff = new Staff(username, password, email, staffId, department);

    }
}
