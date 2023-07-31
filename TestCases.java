import java.util.ArrayList;

public class TestCases {

    private static final int totalTests = 7,
        largeSet = 100,
        smallSet = 20;
    public enum ClassType { TESTING }
    TestCases() {
        //testIfUsersGetUniqueCards();
    }

    // Test that creates a number of users to ensure that each user has a unique card id.
    // Satisfies requirement 1
    public boolean testIfUsersGetUniqueCards() {
        boolean passed = true;

        System.out.println("Beginning unique library card ID test");
        System.out.println("Creating " + largeSet + " users in new Library object...");

        Library library = new Library(ClassType.TESTING);
        createUsers(largeSet, library);
        for(int i = 0; i < library.userCount; i++)
            System.out.println("User " + (i+1) + "'s LibraryCard ID: " + library.users.get(i).getLibCardNum());

        System.out.println("\nChecking if all ID's are unique...");
        // Exhaustively compare each ID to ensure they're unique. -----maybe sort this and then search if time to
        int start = 0,
            index = 0;
        while (start != library.users.size()-1) {
            for (index = start + 1; index < library.users.size(); index++)
                if (library.users.get(start).getLibCardNum() == library.users.get(index).getLibCardNum()) {
                    passed = false;
                    break;
                }
            // Leave loop after at least one match
            if (!passed)
                break;
            start++;
        }

        if(passed)
            System.out.println("Result: Test passed.");
        else {
            System.out.println("Result: Test failed");
            System.out.println("User's " + (start+1) + " and " + (index+1) + " have identical Library card ID's");
            System.out.println("User " + (start+1) + ": " + library.users.get(start).getLibCardNum());
            System.out.println("User " + (index+1) + ": " + library.users.get(index).getLibCardNum());
        }
        return passed;
    }

    // Test that creates a number of users to ensure that Library keeps track of basic user info
    // Satisfies requirement 2
    public boolean testIfLibraryHasUserBasicInfo() {
        return true;
    }

    // Test that creates a number of users and checkouts a number of items to ensure that library
    //       can get info on checked out books
    // Satisfies requirement 3
    public boolean testLibraryHasUserCheckoutInfo() {
        return true;
    }

    // Test that creates a number of users of varying age and ensures that library
    //       enforces the child item checkout limit and other functionality
    // Satisfies requirement 4 and 5
    public boolean testUserCheckout() {
        return true;
    }

    // Test that creates a number of users to test library keeps track of item return dates
    // Satisfies requirements 6, 7, and 8
    public boolean testUserReturnDates() {
        return true;
    }

    // Test that creates a number of users to test if they can request items that arr
    //      currently checked out
    // Satisfies requirement 10
    public boolean testRequestItem() {
        return true;
    }

    // Test that creates a number of users to test if each user can renew a book that they
    //      checked out only one and only if there are no outstanding requests
    // Satisfies requirement 11
    public boolean testRenewItem() {
        return true;
    }

    // Functions to streamline test process to create a number of a specific object
    private ArrayList<User> createUsers(int num, Library library) {
        ArrayList<User> users = new ArrayList<>();

        // Create generic user and add them to library. Age of user is set to (i+1) to ensure varied age
        for (int i = 0; i < num; i ++) {
            library.addUser(("Username" + (i+1)),
                    "Password" + (i+1),
                    "Email" + (i+1),
                    "FirstName" + (i+1),
                    "LastName" + (i+1),
                    (i+1),
                    "Address" + (i+1),
                    "PhoneNum" + (i+1));
            users.add(library.users.get(i));
        }
        return users;
    }

    private ArrayList<Book> createBooks(int num) {
        ArrayList<Book> books = new ArrayList<>();

        // Create num amount of generic books, books at an even i are not bestsellers while odd is.
        // Value of book is set to i + 0.5
        for (int i = 0; i < num; i++) {
            Book book = new Book("Title" + (i + 1),
                    "Author" + (i + 1),
                    i + 1900,
                    (i % 2) == 0,
                    (double) i + 0.5);
            books.add(book);
        }

        return books;
    }

    private ArrayList<AudioVideoMaterial> createAVs(int num) {
        ArrayList<AudioVideoMaterial> avs = new ArrayList<>();

        // Create num amount of generic AV Materials with rules similar to createBooks
        for (int i = 0; i < num; i++) {
            AudioVideoMaterial av = new AudioVideoMaterial("Title" + (i + 1),
                    "Director" + (i + 1),
                    i + 1900,
                    (double) i + 0.5);
            avs.add(av);
        }

        return avs;
    }

    private ArrayList<Magazines> createMags(int num) {
        ArrayList<Magazines> mags = new ArrayList<>();

        // Create num amount of generic Magazines
        for (int i = 0; i < num; i++) {
            Magazines mag = new Magazines("Title" + (i + 1),
                    "Director" + (i + 1),
                    i + 1900);
            mags.add(mag);
        }

        return mags;
    }

    /* Ref books not implemented yet
    private ArrayList<ReferenceBooks> createRefBooks(int num) {
        ArrayList<ReferenceBooks> refBooks = new ArrayList<>();

        // Create num amount of generic Magazines
        for (int i = 0; i < num; i++) {
            ReferenceBooks mag = new ReferenceBooks("Title" + (i + 1),
                    "Author" + (i + 1),
                    i + 1900);
            mags.add(mag);
        }

        return refBooks;
    }*/

    public void runAllTests() {
        System.out.println("Running all tests");
        testIfUsersGetUniqueCards();
        testIfLibraryHasUserBasicInfo();
        testLibraryHasUserCheckoutInfo();
        testUserCheckout();
        testUserReturnDates();
        testRequestItem();
        testRenewItem();
        System.out.println("All tests complete");
    }
}
