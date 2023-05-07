import java.util.Scanner;

public class DinnerEventDemo {

    public static void main(String[] args) {

        // Initializing variables to hold event data, loop & menu controls.
        String eventNum;
        int guests;
        int i, j;
        final int SENT_VALUE = 777;
        int[] menuOption = new int[4];

        // Initializing object array to hold objects.
        DinnerEvent[] events = new DinnerEvent[4];

        // Initializing loop that iterates through a predetermined number of events.
        for (i = 0; i < events.length; ++i) {
            eventNum = getEventNumber();
            guests = getGuests();

            // Initializing nested loop to gather menu item input.
            for (j = 0; j < menuOption.length; ++j) {
                menuOption[j] = getMenu(j);
            }

            events[i] = new DinnerEvent(eventNum, guests, menuOption[0], menuOption[1], menuOption[2], menuOption[3]);
            events[i].setContactPhone(getPhone());
            events[i].setEventType(getType());
        }

        // Calling method that displays sorting menu.
        System.out.println("\n\n How would you like to sort the event details?");
        int sortOption = getOption(SENT_VALUE);

        // Initializing loop that prompts user for sorting options.
        while (sortOption != SENT_VALUE) {
            if (sortOption == 1) {
                sortByEventNumber(events);
            } else if (sortOption == 2) {
                sortGuests(events);
            } else if (sortOption == 3) {
                sortType(events);
            } else {
                System.out.print("Please choose from the options displayed before you.");
            }
            sortOption = getOption(SENT_VALUE);
        }
    }

    // Defining method that prompts the user for entrée item.
    public static int getEntree() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("""
                What would you like for an entree?
                1. Steak
                2. Corned Beef
                3. Chicken""");
        return userInput.nextInt();
    }

    // Defining method that prompts the user for first side item.
    public static int getSide1() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("""
                What would you like for your first side?
                1. Potatoes
                2. Rice
                3. Pasta""");
        return userInput.nextInt();
    }

    // Defining method that prompts the user for second side item.
    public static int getSide2() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("""
                What would you like for your second side?
                1. Potatoes
                2. Rice
                3. Pasta""");
        return userInput.nextInt();
    }

    // Defining method that prompts the user for dessert item.
    public static int getDessert() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("""
                What would you like for dessert?
                1. Cannoli
                2. Tiramisu
                3. Ice Cream""");
        return userInput.nextInt();
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

    // Defining method that displays sorting options to the user.
    public static int getOption(final int QUIT) {
        Scanner input = new Scanner(System.in);
        int option;
        System.out.println("\nPlease enter an option");
        System.out.print("   1 - by event number\n   2 - by number of guests\n" +
                "   3 - by event type\n   " + QUIT + " - to quit     >> ");
        option = input.nextInt();
        input.nextLine();
        return option;
    }

    // Defining bubble sort method by event number.
    public static void sortByEventNumber(DinnerEvent[] array) {

        // Initializing sorting variables.
        int a, b;
        DinnerEvent temp;
        String stringB, stringBPlus;
        int highSubscript = array.length - 1;

        // Initializes for loop that iterates through the number of events.
        for (a = 0; a < highSubscript; ++a)

            // Initializes for loop that iterates through the number of events.
            for (b = 0; b < highSubscript; ++b) {

                // Retrieves event number from the passed array and stores into string variables.
                // Two events gathered: one from the index of current loop iteration, and
                // another from the current loop iteration + 1 (the next item in the array).
                stringB = array[b].getEventNumber();
                stringBPlus = array[b + 1].getEventNumber();

                // Compares both strings according to unicode values.
                if (stringB.compareTo(stringBPlus) > 0) {
                    temp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = temp;
                }
            }

        // Initializes loop that iterates over all events in the array and displays the details.
        for (a = 0; a < array.length; ++a) {
            displayDetails(array[a]);
        }
    }

    // Defining bubble sort method by guest number.
    public static void sortGuests(DinnerEvent[] events) {

        // Initializing sorting variables.
        DinnerEvent temp;
        int highSubscript = events.length - 1;

        // Initializes for loop that iterates through the number of events.
        for (int a = 0; a < highSubscript; ++a) {

            // Initializes for loop that iterates through the number of events.
            for (int b = 0; b < highSubscript; ++b) {

                // Two events parsed: one from the index of current loop iteration, and
                // another from the current loop iteration + 1 (the next item in the array).
                // Both events have guest number compared to determine sort order.
                if (events[b].getGuests() > events[b + 1].getGuests()) {
                    temp = events[b];
                    events[b] = events[b + 1];
                    events[b + 1] = temp;
                }
            }
        }

        // Initializes loop that iterates over all events in the array and displays the details.
        for (int a = 0; a < events.length; ++a) {
            displayDetails(events[a]);
        }
    }

    // Defining bubble sort method by event type.
    public static void sortType(DinnerEvent[] events) {

        // Initializing sorting variables.
        DinnerEvent temp;
        int highSubscript = events.length - 1;

        // Initializes for loop that iterates through the number of events.
        for (int a = 0; a < highSubscript; ++a) {

            // Initializes for loop that iterates through the number of events.
            for (int b = 0; b < highSubscript; ++b) {

                // Two events parsed: one from the index of current loop iteration, and
                // another from the current loop iteration + 1 (the next item in the array).
                // Both events have event type compared to determine sort order.
                if (events[b].getEventType() > events[b + 1].getEventType()) {
                    temp = events[b];
                    events[b] = events[b + 1];
                    events[b + 1] = temp;

                }
            }
        }

        // Initializes loop that iterates over all events in the array and displays the details.
        for (int a = 0; a < events.length; ++a) {
            displayDetails(events[a]);
        }
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
        int guests;
        final int MIN_GUESTS = 5;
        final int MAX_GUESTS = 100;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of guests >> ");
        guests = input.nextInt();
        while (guests < MIN_GUESTS || guests > MAX_GUESTS) {
            System.out.println("The number of guests must be between " +
                    MIN_GUESTS + " and " + MAX_GUESTS);
            System.out.print("Please renter >> ");
            guests = input.nextInt();
        }
        input.nextLine();
        return guests;
    }

    // Defining method that prompts user for event type.
    public static int getType() {
        int eType;
        Scanner input = new Scanner(System.in);
        System.out.println("Event types are");
        for (int x = 0; x < Event.EVENT_TYPES.length; ++x)
            System.out.println("    " + x + " " + Event.EVENT_TYPES[x]);
        System.out.print("Enter event type >> ");
        eType = input.nextInt();
        return eType;
    }

    // Defining method that displays event details.
    public static void displayDetails(DinnerEvent e) {
        System.out.println("\nEvent #" + e.getEventNumber());
        System.out.println("The price for an event with " + e.getGuests() +
                " guests at $" + e.getPricePerGuest() + " per guest is $" + e.getPriceForEvent());
        System.out.println("Whether this is a large event is " +
                (e.getGuests() >= Event.LARGE_EVENT));
        System.out.println("Contact phone number is: " + e.getContactPhone());
        System.out.println("The event is type " + e.getEventType() + " which is the following type: " + e.getEventTypeString());
        System.out.println("The menu includes " + e.getMenu());
    }

    // Defining method that returns the larger of the two events.
    public static DinnerEvent getLarger(DinnerEvent e1, DinnerEvent e2) {
        DinnerEvent larger = e2;
        if (e1.getGuests() >= e2.getGuests())
            larger = e1;
        return larger;
    }

    // Defining method that prompts user for contact number.
    public static String getPhone() {
        String phone;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter contact phone number >> ");
        phone = input.nextLine();
        return phone;
    }

}