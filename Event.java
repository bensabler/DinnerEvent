class Event {

    // Initializing class variables.
    public final static double HIGH_GUEST_PRICE = 35.00;
    public final static double LOW_GUEST_PRICE = 32.00;
    public final static int LARGE_EVENT = 50;
    public final static int EVENT_NUM_LENGTH = 4;
    public final static String[] EVENT_TYPES =
            {"wedding", "baptism", "birthday", "corporate", "other"};
    private String eventNumber;
    private int guests;
    private double pricePerGuest;
    private double priceForEvent;
    private String contactPhone;
    private int eventType;

    // Defining a default constructor.
    public Event() {
        this("A000", 0);
    }

    // Defining an overloaded constructor.
    public Event(String num, int guests) {
        setEventNumber(num);
        setGuests(guests);
    }

    // Defining setter method for event number.
    public void setEventNumber(String num) {
        boolean numOk = true;
        if (num.length() != EVENT_NUM_LENGTH || !Character.isLetter(num.charAt(0)) || !Character.isDigit(num.charAt(1)) || !Character.isDigit(num.charAt(2)) || !Character.isDigit(num.charAt(3)))
            eventNumber = "A000";
        else
            eventNumber = num.toUpperCase();
    }

    // Defining setter method for guest number.
    public void setGuests(int gsts) {
        guests = gsts;
        if (isLargeEvent()) {
            pricePerGuest = LOW_GUEST_PRICE;
            priceForEvent = guests * LOW_GUEST_PRICE;
        } else {
            pricePerGuest = HIGH_GUEST_PRICE;
            priceForEvent = guests * HIGH_GUEST_PRICE;
        }
    }

    // Defining getter method for event number.
    public String getEventNumber() {
        return eventNumber;
    }

    // Defining getter method for guest number.
    public int getGuests() {
        return guests;
    }

    // Defining getter method for price for the event.
    public double getPriceForEvent() {
        return priceForEvent;
    }

    // Defining getter method for price per guest.
    public double getPricePerGuest() {
        return pricePerGuest;
    }

    // Defining getter method for phone number.
    public String getContactPhone() {
        String phone;
        phone = "(" + contactPhone.substring(0, 3) + ") " +
                contactPhone.substring(3, 6) + "-" +
                contactPhone.substring(6, 10);
        return phone;
    }

    // Defining setter method for phone number.
    public void setContactPhone(String phone) {
        final int VALID_LEN = 10;
        final String INVALID_PHONE = "0000000000";
        contactPhone = "";
        int len = phone.length();
        for (int x = 0; x < len; ++x) {
            if (Character.isDigit(phone.charAt(x)))
                contactPhone += phone.charAt(x);
        }
        if (contactPhone.length() != VALID_LEN)
            contactPhone = INVALID_PHONE;
    }

    // Defining setter method for event type.
    public void setEventType(int code) {
        if (code < EVENT_TYPES.length)
            eventType = code;
        else
            eventType = EVENT_TYPES.length - 1;
    }

    // Defining getter method for event type.
    public int getEventType() {
        return eventType;
    }

    // Defining getter method for list of events.
    public String getEventTypeString() {
        return EVENT_TYPES[eventType];
    }

    // Defining method that determines if event is large.
    public boolean isLargeEvent() {
        boolean isLarge = guests >= LARGE_EVENT;
        return isLarge;
    }
}
