public abstract class Employee {

    // Initializing class variables.
    private String employeeNumber;
    private String lastName;
    private String firstName;
    protected double payRate;
    protected String jobTitle;

    // Defines method that sets employee number.
    public void setEmployeeNumber(String num)
    {
        employeeNumber = num;
    }

    // Defines method that sets employee last name.
    public void setLastName(String name)
    {
        lastName = name;
    }

    // Defines method that sets employee first name.
    public void setFirstName(String name)
    {
        firstName = name;
    }

    // Defines method that returns employee number.
    public String getEmployeeNumber()
    {
        return employeeNumber;
    }

    // Defines method that returns employee full name.
    public String getName()
    {
        return firstName + " " + lastName;
    }

    // Defines method that returns employee pay rate.
    public double getPayRate()
    {
        return payRate;
    }

    // Defines method that returns employee job title.
    public String getJobTitle()
    {
        return jobTitle;
    }

    // Initializes abstract methods to be further defined in child classes.
    public abstract void setPayRate(double pay);
    public abstract void setJobTitle();
}