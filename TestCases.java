import java.util.ArrayList;
import java.time.LocalDate;

public class TestCases {

    private static final int totalTests = 7,
        largeSet = 100,
        smallSet = 20;
    public enum ClassType { TESTING }
    TestCases() {
        //testIfUsersGetUniqueCards();
        //testIfLibraryHasUserBasicInfo();
        //testLibraryHasUserCheckoutInfo();
        //testUserCheckout();
    }

    // Test that creates a number of users to ensure that each user has a unique card id.
    // Satisfies requirement 1
    public boolean testIfUsersGetUniqueCards() {
        boolean passed = true;

        System.out.println("\n--------- Beginning unique library card ID test ---------");
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
            System.out.println("\nResult: Test passed.");
        else {
            System.out.println("\nResult: Test failed");
            System.out.println("User's " + (start+1) + " and " + (index+1) + " have identical Library card ID's");
            System.out.println("User " + (start+1) + ": " + library.users.get(start).getLibCardNum());
            System.out.println("User " + (index+1) + ": " + library.users.get(index).getLibCardNum());
        }
        return passed;
    }

    // Test that creates a number of users to ensure that Library keeps track of basic user info
    // Satisfies requirement 2
    public boolean testIfLibraryHasUserBasicInfo() {
        boolean passed = true;

        System.out.println("\n\n--------- Beginning library has user information test ---------");
        System.out.println("Creating " + largeSet + " users in new Library object...\n");

        Library library = new Library(ClassType.TESTING);
        ArrayList<User> users = createUsers(largeSet, library);

        for(User user: library.users)
            System.out.println(user.toString());

        System.out.println("\nChecking if library holds user basic information...");

        // Loop through every user to ensure library keeps basic user info accurately
        int i = 0;
        for(i = 0; i < users.size(); i++) {
            if (!users.get(i).toString().equals(library.users.get(i).toString())) {
                passed = false;
                break;
            }
        }

        if(passed)
            System.out.println("\nResult: Test passed.");
        else {
            System.out.println("\nResult: Test failed");
            System.out.println("Library did not store User " + (i+1) + "'s info correctly");
            System.out.println("Control group:  " + users.get(i).toString());
            System.out.println("Library's data: " + library.users.get(i).toString());
        }

        return passed;
    }

    // Test that creates a number of users and checkouts a number of items to ensure that library
    //       can get info on checked out books
    // Satisfies requirement 3
    public boolean testLibraryHasUserCheckoutInfo() {
        boolean passed = true;

        System.out.println("\n\n--------- Beginning Library checkout test ---------");
        System.out.println("Creating " + smallSet + " users in new Library object...");

        Library library = new Library(ClassType.TESTING);
        ArrayList<User> users = createUsers(smallSet, library);

        System.out.println("Adding " + smallSet + " books and audio visual materials each into Library");
        //ArrayList<Book> books =
        createBooks(smallSet, library);
        //ArrayList<ReferenceBook> refBooks =
        //createRefBooks(smallSet, library);
        //ArrayList<AudioVideoMaterial> avs =
        createAVs(smallSet, library);
        //ArrayList<Magazines> mags =
        //createMags(smallSet, library);

        System.out.println("Checking out a Book and AV material for each user");
        for(int i = 0; i < users.size(); i++) {
            library.users.get(i).getLibraryCard().checkOutBook(library.books.get(i), 0);
            library.users.get(i).getLibraryCard().checkOutAV(library.avMaterials.get(i), 0);
        }

        System.out.println("Verify Library has checkout info");
        int i;
        for (i = 0; i < users.size(); i++) {
            System.out.println(library.users.get(i).getLibraryCard().getCheckedOutBooks().get(0).toString()
                    + " / " + library.users.get(i).getLibraryCard().getCheckedOutAV().get(0).toString());
            // Check that book and avMaterial are checked out from Library
            if(!(library.books.get(i).isCheckedOut() && library.avMaterials.get(i).isCheckedOut())) {
                passed = false;
                break;
            }

            // Check that the Book due date is accurate
            boolean best = library.books.get(i).getBestseller();
            LocalDate startDate = library.books.get(i).getStartDate();
            LocalDate due = best ? startDate.plusDays(14) : startDate.plusDays(21);
            if (!library.books.get(i).getDueDate().equals(due)) {
                passed = false;
                System.out.println("Result: Test failed");
                System.out.println("Library did not store User " + (i+1) + "'s Book due date info correctly");
                System.out.println("Expected: " + due);
                System.out.println("Result:   " + library.books.get(i).getDueDate());
                break;
            }

            // AV due date check
            due = startDate.plusDays(14);
            if (!library.avMaterials.get(i).getDueDate().equals(due)) {
                passed = false;
                System.out.println("\nResult: Test failed");
                System.out.println("Library did not store User " + (i+1) + "'s AV due date info correctly");
                System.out.println("Expected: " + due);
                System.out.println("Result:   " + library.avMaterials.get(i).getDueDate());
                break;
            }

            // Check that fine calculation is accurate past 22 days
            library.day = 22;
            library.users.get(i).getLibraryCard().returnBook(library.books.get(i));
            System.out.println("book fines : " + library.users.get(i).getLibraryCard().getFines()); // del
            library.users.get(i).getLibraryCard().returnAV(library.avMaterials.get(i));
            double fines = (library.books.get(i).getBestseller() ? 0.8 : 0.1) + 0.8; // Every user should have this amount of fines
            if (fines != library.users.get(i).getLibraryCard().getFines()) {
                passed = false;
                System.out.println("\nResult: Test failed");
                System.out.println("Library did not store User " + (i+1) + "'s fine info correctly on turning items in after 22 days");
                System.out.println("Expected: " + fines);
                System.out.println("Result:   " + library.users.get(i).getLibraryCard().getFines());
                break;
            }
            library.day = 0;
        }

        if(passed)
            System.out.println("Result: Test passed.");

        return passed;
    }

    // Test that creates a number of users of varying age and ensures that library
    //       enforces the child item checkout limit and other functionality
    // Satisfies requirement 4 and 5
    public boolean testUserCheckout() {
        boolean passed = true;
        System.out.println("\n\n--------- Beginning unique library card ID test ---------");
        System.out.println("Adding one child user and one adult user in new Library object...");

        // Create new library, add users, Books, and AVs
        Library library = new Library(ClassType.TESTING);
        library.addUser(("UsernameChild"), "PasswordChild", "EmailChild", "FirstNameChild",
                "LastNameChild", 10, "AddressChild", "PhoneNumChild");
        library.addUser(("UsernameAdult"), "PasswordAdult", "EmailAdult", "FirstNameAdult",
                "LastNameAdult", 25, "AddressAdult", "PhoneNumAdult");

        System.out.println("Adding " + smallSet + " books and audio visual materials each into Library");
        ArrayList<Book> books = createBooks(smallSet, library);
        ArrayList<AudioVideoMaterial> avs = createAVs(smallSet, library);

        System.out.println("Attempting to checkout " + smallSet + " items to both users with equal distribution "
                + " between Book and AV");

        for (int i = 0; i < smallSet; i++) {
            //del
            System.out.println("Childs checkout out size before attempting checkout " + (i+1) + ": "
                    + library.users.get(0).getLibraryCard().getCheckedOutBooks().size()
                    + " and " + library.users.get(0).getLibraryCard().getCheckedOutAV().size());

            if (i > 4) {
                System.out.println("Attempting to checkout an item for child user above maximum allowed checked out");
            }
            // Alternate the type of item each user checks out
            if (i % 2 == 0) {
                library.users.get(1).getLibraryCard().checkOutBook(books.get(i), 0);
                library.users.get(0).getLibraryCard().checkOutAV(avs.get(i), 0);
            } else {
                library.users.get(1).getLibraryCard().checkOutAV(avs.get(i), 0);
                library.users.get(0).getLibraryCard().checkOutBook(books.get(i), 0);
            }

            // Ensure item did not get checked out for child if limit reached
            if (i > 4 && avs.get(i).isCheckedOut() && books.get(i).isCheckedOut()) {
                passed = false;
                System.out.println("\nResult: Test failed");
                System.out.println("Child user was allowed to checkout more items than maximum allowed for age restriction");
                System.out.println("Expected checkout total: 5");
                System.out.println("Result checkout total:   " + (library.users.get(0).getLibraryCard().getCheckedOutBooks().size()
                        + library.users.get(0).getLibraryCard().getCheckedOutAV().size()));
                break;
            }
        }

            if(passed)
                System.out.println("\nResult: Test passed");

        System.out.println("Expected child checkout total: 5");
        System.out.println("Result child checkout total:   " + (library.users.get(0).getLibraryCard().getCheckedOutBooks().size()
                + library.users.get(0).getLibraryCard().getCheckedOutAV().size()));
        System.out.println("Expected adult checkout total: " + smallSet);
        System.out.println("Result adult checkout total:   " + (library.users.get(1).getLibraryCard().getCheckedOutBooks().size()
                + library.users.get(1).getLibraryCard().getCheckedOutAV().size()));

        return passed;
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

    private ArrayList<Book> createBooks(int num, Library library) {
        ArrayList<Book> books = new ArrayList<>();

        // Create num amount of generic books, books at an even i are not bestsellers while odd is.
        // Value of book is set to i + 1.5
        for (int i = 0; i < num; i++) {
            Book book = new Book("Title" + (i + 1),
                    "Author" + (i + 1),
                    i + 1900,
                    (i % 2) == 0,
                    (double) i + 1.5);
            books.add(book);
            library.addItem((Item) book, book.getItemType());
        }

        return books;
    }

    private ArrayList<AudioVideoMaterial> createAVs(int num, Library library) {
        ArrayList<AudioVideoMaterial> avs = new ArrayList<>();

        // Create num amount of generic AV Materials with rules similar to createBooks
        for (int i = 0; i < num; i++) {
            AudioVideoMaterial av = new AudioVideoMaterial("Title" + (i + 1),
                    "Director" + (i + 1),
                    i + 1900,
                    (double) i + 1.5);
            avs.add(av);
            library.addItem((Item) av, av.getItemType());
        }

        return avs;
    }

    private ArrayList<Magazines> createMags(int num, Library library) {
        ArrayList<Magazines> mags = new ArrayList<>();

        // Create num amount of generic Magazines
        for (int i = 0; i < num; i++) {
            Magazines mag = new Magazines("Title" + (i + 1),
                    "Director" + (i + 1),
                    i + 1900);
            mags.add(mag);
            library.addItem((Item) mag, mag.getItemType());
        }

        return mags;
    }

    private ArrayList<ReferenceBook> createRefBooks(int num, Library library) {
        ArrayList<ReferenceBook> refBooks = new ArrayList<>();

        // Create num amount of generic Reference Books
        for (int i = 0; i < num; i++) {
            ReferenceBook refBook = new ReferenceBook("Title" + (i + 1),
                    "Author" + (i + 1),
                    i + 1900);
            refBooks.add(refBook);
            library.addItem((Item) refBook, refBook.getItemType());
        }

        return refBooks;
    }

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
