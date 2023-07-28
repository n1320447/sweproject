import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Library {
    Scanner scanner;
    int userCount = 0;
    int itemCount = 0;
    List<User> users = new ArrayList<>();
    List<Staff> staff = new ArrayList<>();
    List<Book> books = new ArrayList<>();
    List<AudioVideoMaterial> avMaterials;
    List<Magazines> magazines = new ArrayList<>();
// Add methods to handle magazines as needed.

    Library(){
        scanner = new Scanner(System.in);
        System.out.println("new library made");

        //create 2 users as soon as library object is created.
        User newUser = new User("nestor1", "password1", "nestor@gmail.com", "Nestor", "Govea");
        users.add(newUser);
        User newUser2 = new User("mike2", "mpassword", "mike@gmail.com", "Mike", "Smith");
        users.add(newUser2);
        
        // increment userCount by 2
        userCount += 2;

        //add in list of books
            // Create and add books
        Book book1 = new Book("Book Title 1", "Author 1", 2000);
        books.add(book1);
        
        Book book2 = new Book("Book Title 2", "Author 2", 2010);
        books.add(book2);

        //add in list of AV Materials
    }

    public void libaryMenu(){
        int choice = 0;
        

        while (choice != 9) {
        System.out.println("Please choose what to do by the number.");
        System.out.println("1. Create Account");
        System.out.println("2. View which items are checked out.");
        System.out.println("3. Get number of Accounts in System.");
        System.out.println("4. Checkout an Item");
        System.out.println("5. Add item to library (book or audio/visual)");
        System.out.println("6. Add Magazine to library");
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
        
                        User newUser = new User(userName, passWord, email, firstName, lastName);
                        users.add(newUser); // Add the new user to the users list
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
                for (int i = 0; i < books.size(); i++) {
                    
                    if(books.get(i).isCheckedOut() == true){
                        System.out.println(books.get(i).getTitle());
                        atLeast1CheckedOut = true;
                    }
        
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
                System.out.println(books);

                break;
            case 5:
                System.out.println(" Add Item.");
                System.out.println();

                
                String lastName = "";
               
                System.out.println("please enter last name of author/director.");
                scanner = new Scanner(System.in);
                lastName = scanner.nextLine();

                System.out.println("Please choose if item will be a book or audio/video item.");
                System.out.println("1. Book");
                System.out.println("2. Audio/Video");

                scanner = new Scanner(System.in);
                if(scanner.nextInt() == 1){
                    Item newItem = new Item(lastName, choice, Item.ItemType.BOOK);
                    System.out.println("New Book item created");

                } else {
                    Item newItem = new Item(lastName, choice, Item.ItemType.AUDIO_VIDEO_MATERIAL);
                    System.out.println("New Audio/Video item created");
                }
                itemCount += 1;
                break;

            case 6:
                System.out.println(" Add Magazine.");
                // ... (Add the logic for creating and adding a new magazine)
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

}
