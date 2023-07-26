import java.util.Scanner;

public class Library {
    Scanner scanner;
    int userCount = 0;
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
        System.out.println("9. Exit");
        
        choice = getUserChoice();


        System.out.print("You selected option: " + choice);

        
        switch (choice) {
            case 1:
                System.out.println(" Create Account.");
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
                System.out.println("User count is: " + getNumberOfUsers());
                break;
            case 9:
                System.out.println(" Exiting the library system. Goodbye!");
                break;
            
            default:
                System.out.println("Invalid option. Please choose a valid number.");
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
