import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Library {
    Scanner scanner;
    int userCount = 0;
    int itemCount = 0;
    List<User> users;
    Library(){
        scanner = new Scanner(System.in);
        users = new ArrayList<>(); // Initialize the users list
        System.out.println("new library made");
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
        System.out.println("9. Exit");
        
        choice = getUserChoice();


        System.out.print("You selected option: " + choice);

        
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
                        System.out.println("users include: " + users);
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
                        // Add any additional logic for Staff account creation
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a valid number.");
                        System.out.println();
                        break;
                }

                userCount += 1;
                Account newAccount = new Account(userName, passWord, email);
                break;
            case 2:

                break;
            case 3:
                System.out.println(" User count is: " + getNumberOfUsers());
                System.out.println();
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
                String type = "";
                if(scanner.nextInt() == 1){
                    Item newItem = new Item(lastName, choice, Item.ItemType.BOOK);
                    System.out.println("New Book item created");

                } else {
                    Item newItem = new Item(lastName, choice, Item.ItemType.AUDIO_VIDEO_MATERIAL);
                    System.out.println("New Audio/Video item created");
                }
                itemCount += 1;
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
