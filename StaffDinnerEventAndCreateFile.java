import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class StaffDinnerEventAndCreateFile {

    public static void main(String[] args) {

        try {
            // Point to file path, print location, create file and initialize writer.
            Path file = Paths.get("eList.txt");
            System.out.println("File is located: " + file.toAbsolutePath());
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

            // Initializing variables to hold event data, loop & menu controls.
            String eventNum, s;
            String delim = ", ";
            int i, guests;
            DinnerEvent[] events = new DinnerEvent[3];

            // Initializing loop that iterates through a predetermined number of events.
            for (i = 0; i < events.length; ++i) {
                eventNum = getEventNumber();
                guests = getGuests();
                events[i] = new DinnerEvent(eventNum, guests);
                events[i].setEventType(getType());

                // For every iteration, event information is stored in a string variable.
                s = "Event Number: " + events[i].getEventNumber() + delim +
                        "Event Code: " + events[i].getEventType() + delim +
                        "Guest Number: " + events[i].getGuests() + delim +
                        "Total Price: $" + events[i].getPriceForEvent();

                // The string holding event information is then written to our file.
                writer.write(s, 0, s.length());
                writer.newLine();
            }

            // Close writer when data input loop ends.
            writer.close();
        } catch (Exception e) {
            System.out.println("Message: " + e);
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

    // Defining method that prompts user for event type.
    public static int getType() {
        int eType = -1;
        final int MIN_RANGE = 0;
        final int MAX_RANGE = Event.EVENT_TYPES.length;
        Scanner input = new Scanner(System.in);

        // Exception handling that throws an error if user input is not an integer.
        do {
            try {
                System.out.println("\nEvent types are");
                for (int x = 0; x < Event.EVENT_TYPES.length; ++x)
                    System.out.println("    " + x + " " + Event.EVENT_TYPES[x]);
                System.out.print("Enter event type >> ");
                eType = input.nextInt();

                // If input is not an integer, scanner is emptied and the user is prompted again.
            } catch (InputMismatchException e) {
                System.out.println("\nError! Invalid input for event type selection.");
                input.next();
            }

            // Prompt continues until user inputs an integer in range of menu options.
        } while (eType < MIN_RANGE || eType > MAX_RANGE);
        return eType;
    }
}
