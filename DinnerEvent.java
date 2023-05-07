public class DinnerEvent extends Event {

    // Initializing class variables.
    public final static String[] ENTREES = {"steak", "corned beef", "chicken"};
    public final static String[] SIDES = {"potatoes", "rice", "pasta"};
    public final static String[] DESSERTS = {"cannoli", "tiramisu", "ice cream"};
    Employee[] emps = new Employee[15];
    private final int choiceEntree;
    private final int choiceSide1;
    private final int choiceSide2;
    private final int choiceDessert;

    // Defining a default constructor.
    public DinnerEvent(String numEvent, int numGuest) {

        // Assigns variables inherited from parent class.
        super(numEvent, numGuest);

        // Assigns child class variables.
        this.choiceEntree = 0;
        this.choiceSide1 = 0;
        this.choiceSide2 = 0;
        this.choiceDessert = 0;

    }

    // Defining an overloaded constructor.
    public DinnerEvent(String numEvent, int numGuest, int choiceEntree, int choiceSide1, int choiceSide2, int choiceDessert) {

        // Assigns variables inherited from parent class.
        super(numEvent, numGuest);

        // Assigns child class variables.
        if(choiceEntree < ENTREES.length)
            this.choiceEntree = choiceEntree;
        else
            this.choiceEntree = 0;
        if(choiceSide1 < SIDES.length)
            this.choiceSide1 = choiceSide1;
        else
            this.choiceSide1 = 0;
        if(choiceSide2 < SIDES.length)
            this.choiceSide2 = choiceSide2;
        else
            this.choiceSide2 = 0;
        if(choiceDessert < DESSERTS.length)
            this.choiceDessert = choiceDessert;
        else
            this.choiceDessert = 0;
    }

    // Defines method that returns menu information.
    public String getMenu()
    {
        String menu = "\n        Entree: " + ENTREES[choiceEntree] + "\n        Side 1: " +
                SIDES[choiceSide1] + "\n        Side 2: " + SIDES[choiceSide2] + "\n        Dessert: " +
                DESSERTS[choiceDessert];
        return menu;
    }

    // Defines a method that sets the employee array field.
    public void setEmps(Employee[] emps)
    {
        this.emps = emps;
    }

    // Defines a method that returns an array of employees.
    public Employee[] getEmps()
    {
        return emps;
    }
}