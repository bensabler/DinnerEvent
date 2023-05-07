import java.util.InputMismatchException;
import java.util.Scanner;

public class StaffDinnerEvent {

    public static void main(String[] args) {

        // Initializing variables to hold event data, loop & menu controls.
        String eventNum;
        int guests;
        int i, j, k;
        int[] menuOption = new int[4];

        // Initializing object array to hold objects.
        DinnerEvent[] events = new DinnerEvent[1];
        Employee[] employee = new Employee[15];

        // Initializing loop that iterates through a predetermined number of events.
        for (i = 0; i < events.length; ++i) {
            eventNum = getEventNumber();
            guests = getGuests();

            // Initializing nested loop to gather menu item input.
            for (j = 0; j < menuOption.length; ++j) {
                menuOption[j] = getMenu(j);
            }

            // Instantiating DinnerEvent objects with the given user input.
            events[i] = new DinnerEvent(eventNum, guests, menuOption[0], menuOption[1], menuOption[2], menuOption[3]);
            events[i].setContactPhone(getPhone());

            // Creating formula to determine how much of each employee per number of guests.
            int waitStaff = (guests / 10) + 1;
            int bartenders = guests / 25;
            if (bartenders == 0) {
                bartenders = 1;
            }
            int numEmployee = waitStaff + bartenders;

            // Initializing loop to collect waiter information.
            for (k = 0; k < waitStaff; k++) {
                employee[k] = getWaitStaff();
            }

            // Initializing loop to collect bartender information.
            for (; k <= numEmployee - waitStaff; k++) {
                employee[k] = getBartender();
            }

            // All events will have 1 coordinator.
            employee[k] = getCoordinator();

            // Setting the employees.
            events[i].setEmps(employee);

            // Displaying the results.
            displayDetails(events[i], k);
        }
    }

    // Defining method that prompts the user for entrée item.
    public static int getEntree() {
        Scanner userInput = new Scanner(System.in);
        int choice = 0;

        // Exception handling that throws an error if user input is not an integer.
        do {
            try {
                System.out.println("""
                        \nWhat would you like for an entree?
                        1. Steak
                        2. Corned Beef
                        3. Chicken""");
                System.out.print(">> ");
                choice = userInput.nextInt();

                // Manual data validation keeping input within accepted range.
                if (choice < 1 || choice > 3) {
                    System.out.println("\nError! You must select an item from the provided list.");
                }

                // If input is not an integer, scanner is emptied and the user is prompted again.
            } catch (InputMismatchException e) {
                System.out.println("\nError! Invalid input for menu selection.");
                userInput.next();
            }

            // Prompt continues until user inputs a selection from 1 through 3.
        } while (choice < 1 || choice > 3);
        return choice;
    }

    // Defining method that prompts the user for first side item.
    public static int getSide1() {
        Scanner userInput = new Scanner(System.in);
        int choice = 0;

        // Exception handling that throws an error if user input is not an integer.
        do {
            try {
                System.out.println("""
                        \nWhat would you like for your first side?
                        1. Potatoes
                        2. Rice
                        3. Pasta""");
                System.out.print(">> ");
                choice = userInput.nextInt();

                // Manual data validation keeping input within accepted range.
                if (choice < 1 || choice > 3) {
                    System.out.println("\nError! You must select an item from the provided list.");
                }

                // If input is not an integer, scanner is emptied and the user is prompted again.
            } catch (InputMismatchException e) {
                System.out.println("\nError! Invalid input for menu selection.");
                userInput.next();
            }

            // Prompt continues until user inputs a selection from 1 through 3.
        } while (choice < 1 || choice > 3);
        return choice;
    }

    // Defining method that prompts the user for second side item.
    public static int getSide2() {
        Scanner userInput = new Scanner(System.in);
        int choice = 0;

        // Exception handling that throws an error if user input is not an integer.
        do {
            try {
                System.out.println("""
                        \nWhat would you like for your second side?
                        1. Potatoes
                        2. Rice
                        3. Pasta""");
                System.out.print(">> ");
                choice = userInput.nextInt();

                // Manual data validation keeping input within accepted range.
                if (choice < 1 || choice > 3) {
                    System.out.println("\nError! You must select an item from the provided list.");
                }

                // If input is not an integer, scanner is emptied and the user is prompted again.
            } catch (InputMismatchException e) {
                System.out.println("\nError! Invalid input for menu selection.");
                userInput.next();
            }

            // Prompt continues until user inputs a selection from 1 through 3.
        } while (choice < 1 || choice > 3);
        return choice;
    }

    // Defining method that prompts the user for dessert item.
    public static int getDessert() {
        Scanner userInput = new Scanner(System.in);
        int choice = 0;

        // Exception handling that throws an error if user input is not an integer.
        do {
            try {
                System.out.println("""
                        \nWhat would you like for dessert?
                        1. Cannoli
                        2. Tiramisu
                        3. Ice Cream""");
                System.out.print(">> ");
                choice = userInput.nextInt();

                // Manual data validation keeping input within accepted range.
                if (choice < 1 || choice > 3) {
                    System.out.println("\nError! You must select an item from the provided list.");
                }

                // If input is not an integer, scanner is emptied and the user is prompted again.
            } catch (InputMismatchException e) {
                System.out.println("\nError! Invalid input for menu selection.");
                userInput.next();
            }

            // Prompt continues until user inputs a selection from 1 through 3.
        } while (choice < 1 || choice > 3);
        return choice;
    }

    // Defining method that prompts user for menu item depending on the value passed as an argument.
    public static int getMenu(int j) {
        int option;
        if (j == 0) {
            option = getEntree();
        } else if (j == 1) {
            option = getSide1();
        } else if (j == 2) {
            option = getSide2();
        } else {
            option = getDessert();
        }
        return option;
    }

    // Defining method that prompts user for event number.
    public static String getEventNumber() {
        String num;
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter event number >> ");
        num = input.nextLine();
        return num;
    }

    // Defining method that prompts user for guest number.
    public static int getGuests() {
        int guests = 0;
        final int MIN_GUESTS = 5;
        final int MAX_GUESTS = 100;
        Scanner input = new Scanner(System.in);

        // Exception handling that throws an error if user input is not an integer.
        do {
            try {
                System.out.print("\nEnter number of guests >> ");
                guests = input.nextInt();

                // Manual data validation keeping input within accepted range.
                if (guests < MIN_GUESTS || guests > MAX_GUESTS) {
                    System.out.println("\nError! The number of guests must be between " +
                            MIN_GUESTS + " and " + MAX_GUESTS + ".");
                }

                // If input is not an integer, scanner is emptied and the user is prompted again.
            } catch (InputMismatchException e) {
                System.out.println("\nError! Invalid input for guest number.");
                input.next();
            }

            // Prompt continues until user inputs a number between 5 and 100.
        } while (guests < MIN_GUESTS || guests > MAX_GUESTS);
        return guests;
    }

    // Defining method that displays event details.
    public static void displayDetails(DinnerEvent e, int numEmp) {
        Employee[] employee;
        employee = e.getEmps();
        System.out.println("\nEvent #" + e.getEventNumber());
        System.out.println("Guest Amount: " + e.getGuests());
        System.out.println("The menu includes: " + e.getMenu());
        System.out.println("Contact phone number is: " + e.getContactPhone());

        for (int l = 0; l <= numEmp; l++) {
            System.out.println("\n* " + employee[l].getJobTitle() + "\nID #: " + employee[l].getEmployeeNumber() +
                    "\nName: " + employee[l].getName() + "\nRate of Pay: $" + employee[l].getPayRate());
        }
    }

    // Defining method that prompts user for contact number.
    public static String getPhone() {
        String phone;
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter contact phone number >> ");
        phone = input.nextLine();
        return phone;
    }

    // Defining a method that assigns the details of individual wait staff.
    public static Waitstaff getWaitStaff() {

        Scanner scan = new Scanner(System.in);

        // Instantiating new waitstaff object.
        Waitstaff waitStaff = new Waitstaff();

        // Prompt for employee information.
        System.out.print("\nWait Staff Employee ID #: ");
        waitStaff.setEmployeeNumber(scan.nextLine());

        System.out.print("\nWait Staff First Name: ");
        waitStaff.setFirstName(scan.nextLine());

        System.out.print("\nWait Staff Last Name: ");
        waitStaff.setLastName(scan.nextLine());

        // Exception handling that throws an error if user input is not a double.
        boolean isValid = false;
        do {
            try {
                System.out.print("\nWait Staff Hourly Rate: ");

                // Take user input, if it's not a double an exception is thrown.
                waitStaff.payRate = scan.nextDouble();

                // If input is double, boolean switch triggers and exits the loop.
                isValid = true;

                // If input is not a double, scanner is emptied and the user is prompted again.
            } catch (InputMismatchException e) {
                System.out.println("\nError! Invalid input for employee salary.");
                scan.next();
            }

            // User will be prompted continuously until user inputs an acceptable value.
        } while (!isValid);

        waitStaff.setJobTitle();

        return waitStaff;
    }

    // Defining a method that assigns the details of individual bar staff.
    public static Bartender getBartender() {

        Scanner scan = new Scanner(System.in);

        // Instantiating new bartender object.
        Bartender bartender = new Bartender();

        // Prompt for employee information.
        System.out.print("\nBartender Employee ID #: ");
        bartender.setEmployeeNumber(scan.nextLine());

        System.out.print("\nBartender First Name: ");
        bartender.setFirstName(scan.nextLine());

        System.out.print("\nBartender Last Name: ");
        bartender.setLastName(scan.nextLine());

        // Exception handling that throws an error if user input is not a double.
        boolean isValid = false;
        do {
            try {
                System.out.print("\nBartender Hourly Rate: ");

                // Take user input, if it's not a double an exception is thrown.
                bartender.payRate = scan.nextDouble();

                // If input is double, boolean switch triggers and exits the loop.
                isValid = true;

                // If input is not a double, scanner is emptied and the user is prompted again.
            } catch (InputMismatchException e) {
                System.out.println("\nError! Invalid input for employee salary.");
                scan.next();
            }

            // User will be prompted continuously until user inputs an acceptable value.
        } while (!isValid);

        bartender.setJobTitle();

        return bartender;
    }

    // Defining a method that assigns the details of individual coordinator staff.
    public static Coordinator getCoordinator() {

        Scanner scan = new Scanner(System.in);

        // Instantiating new coordinator object.
        Coordinator coord = new Coordinator();

        // Prompt for employee information.
        System.out.print("\nCoordinator Employee ID #: ");
        coord.setEmployeeNumber(scan.nextLine());

        System.out.print("\nCoordinator First Name: ");
        coord.setFirstName(scan.nextLine());

        System.out.print("\nCoordinator Last Name: ");
        coord.setLastName(scan.nextLine());

        // Exception handling that throws an error if user input is not a double.
        boolean isValid = false;
        do {
            try {
                System.out.print("\nCoordinator Hourly Rate: ");

                // Take user input, if it's not a double an exception is thrown.
                coord.payRate = scan.nextDouble();

                // If input is double, boolean switch triggers and exits the loop.
                isValid = true;

                // If input is not a double, scanner is emptied and the user is prompted again.
            } catch (InputMismatchException e) {
                System.out.println("\nError! Invalid input for employee salary.");
                scan.next();
            }

            // User will be prompted continuously until user inputs an acceptable value.
        } while (!isValid);

        coord.setJobTitle();

        return coord;
    }
}