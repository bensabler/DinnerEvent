// Initializes new class that inherits Employee class.
public class Waitstaff extends Employee {

    // Initializes class variables.
    public double waitPayCap = 10.00;

    // Defines default constructor.
    public Waitstaff() {

        // Assigns variables inherited from parent class.
        super();

        // Abstracted methods called.
        setPayRate(payRate);
        setJobTitle();
    }

    // Defines abstract method initialized in parent class for specific class us
    @Override
    public void setPayRate(double pay) {

        // If the parameter passed exceeds the class pay cap, then set pay to that cap.
        if (pay >= waitPayCap) {
            payRate = waitPayCap;
        } else {
            payRate = pay;
        }
    }

    // Defines abstract method initialized in parent class for specific class use.
    public void setJobTitle() {
        this.jobTitle = "Wait Staff";
    }
}
