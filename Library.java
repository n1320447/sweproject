import java.util.Scanner;

public class Library {
    Scanner scanner;
    Library(){
        scanner = new Scanner(System.in);
        System.out.println("new library made");
    }

    public void libaryMenu(){
        int choice = 0;
        while (choice != 9) {
        System.out.println("Please choose what do by the number.");
        System.out.println("1. Add User");
        System.out.println("2. View which items are checked out.");
        System.out.println("9. Exit");
        
        choice = getUserChoice();


        System.out.println("You selected option: " + choice);

        
        switch (choice) {
            case 1:
                break;
            case 2:

                break;
            case 9:
                System.out.println("Exiting the library system. Goodbye!");
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

}
