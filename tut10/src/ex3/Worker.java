package ex3;

public class Worker extends Human {
    public Worker(String firstName, String lastName) {
        super(firstName, lastName);
        setWeekSalary(weekSalary);
        setWorkHoursPerDay(workHoursPerDay);
        // TODO Auto-generated constructor stub
    }

    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        setWeekSalary(weekSalary);
        setWorkHoursPerDay(workHoursPerDay);
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public void setWeekSalary(double weekSalary) {
        if (weekSalary < 10)
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        this.weekSalary = weekSalary;
    }

    public double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    public void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12)
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    public void setLastName(String lastName) {
        // TODO Auto-generated method stub
        if (lastName.length() < 3)
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        return super.toString() + "\nWeek Salary: " + String.format("%.2f", weekSalary)
                + "\nHours per day: " + String.format("%.2f", workHoursPerDay)
                + "\nSalary per hour: " + String.format("%.2f", (weekSalary / workHoursPerDay / 7));
    }

}
