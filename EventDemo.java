import java.util.Scanner;

public class  EventDemo {
    public static void main(String[] args) {

        // Initializing variables to hold event data, loop & menu controls.
        String eventNum;
        int guests;
        int x;
        final int SENT_VALUE = 777;

        // Initializing object array to hold objects.
        Event[] events = new Event[8];

        // Initializing loop that iterates through a predetermined number of events.
        for (x = 0; x < events.length; ++x) {
            eventNum = getEventNumber();
            guests = getGuests();
            events[x] = new Event(eventNum, guests);
            events[x].setContactPhone(getPhone());
            events[x].setEventType(getType());
        }

        // Calling method that displays sorting menu.
        System.out.println("\n\n How would you like to sort the event details?");
        int sortOption = getSortOption(SENT_VALUE);

        // Initializing loop that prompts user for sorting options.
        while (sortOption != SENT_VALUE) {
            if (sortOption == 1) {
                sortEvent(events);
            } else if (sortOption == 2) {
                sortGuests(events);
            } else if (sortOption == 3) {
                sortType(events);
            } else {
                System.out.print("Please choose from the options displayed before you.");
            }
            sortOption = getSortOption(SENT_VALUE);
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
    public static void displayDetails(Event e) {
        System.out.println("\nEvent #" + e.getEventNumber());
        System.out.println("The price for an event with " + e.getGuests() +
                " guests at $" + e.getPricePerGuest() + " per guest is $" + e.getPriceForEvent());
        System.out.println("Whether this is a large event is " +
                (e.getGuests() >= Event.LARGE_EVENT));
        System.out.println("Contact phone number is: " + e.getContactPhone());
        System.out.println("The event is type " + e.getEventType() + " which is the following type: " + e.getEventTypeString());
    }

    // Defining method that returns the larger of the two events.
    public static Event getLarger(Event e1, Event e2) {
        Event larger = e2;
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

    // Defining method that displays sorting options to the user.
    public static int getSortOption(final int option) {

        Scanner userInput = new Scanner(System.in);
        int sortOption;
        System.out.println("\nPlease choose from the following options: " +
                "\n 1) Event Number " +
                "\n 2) Guest Number " +
                "\n 3) Event Type ");
        sortOption = userInput.nextInt();
        return sortOption;
    }

    // Defining bubble sort method by event number.
    public static void sortEvent(Event[] events) {

        // Initializing sorting variables.
        Event temp;
        String eventOne, eventTwo;
        int highSubscript = events.length - 1;

        // Initializes for loop that iterates through the number of events.
        for (int a = 0; a < highSubscript; ++a) {

            // Initializes for loop that iterates through the number of events.
            for (int b = 0; b < highSubscript; ++b) {

                // Retrieves event number from the passed array and stores into string variables.
                // Two events gathered: one from the index of current loop iteration, and
                // another from the current loop iteration + 1 (the next item in the array).
                eventOne = events[b].getEventNumber();
                eventTwo = events[b + 1].getEventNumber();

                // Compares both strings according to unicode values.
                if (eventOne.compareTo(eventTwo) > 0) {
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

    // Defining bubble sort method by guest number.
    public static void sortGuests(Event[] events) {

        // Initializing sorting variables.
        Event temp;
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
    public static void sortType(Event[] events) {

        // Initializing sorting variables.
        Event temp;
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
}