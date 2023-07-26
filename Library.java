import java.util.Scanner;

public class Library {
    Scanner scanner;
    int userCount = 0;
    int itemCount = 0;
    Library(){
        scanner = new Scanner(System.in);
        System.out.println("new library made");
    }

    public void libaryMenu(){
        int choice = 0;
        

        while (choice != 9) {
        System.out.println("Please choose what to do by the number.");
        System.out.println("1. Create Account");
        System.out.println("2. View which items are checked out.");
        System.out.println("3. Get how many Users are in Library System.");
        System.out.println("4. Checkout an Item");
        System.out.println("5. Add item to library (book or audio/visual)");
        System.out.println("9. Exit");
        
        choice = getUserChoice();


        System.out.print("You selected option: " + choice);

        
        switch (choice) {
            case 1:
                System.out.println(" Create Account.");
                System.out.println();
                String fname = "";
                String lname = "";
                System.out.println("enter first name");
                scanner = new Scanner(System.in);
                fname = scanner.nextLine();
                System.out.println("first name entered is " + fname + " please enter last name.");
                scanner = new Scanner(System.in);
                lname = scanner.nextLine();
                System.out.println("last name entered is " + lname + " ");
                userCount += 1;
                User newUser = new User(userCount, fname, lname);
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
                }

                


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
