package bean;

public class Driver extends Human {
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getHoursWorkedThisMonth() {
        return hoursWorkedThisMonth;
    }

    public void setHoursWorkedThisMonth(int hoursWorkedThisMonth) {
        this.hoursWorkedThisMonth = hoursWorkedThisMonth;
    }

    private int hoursWorkedThisMonth;
}
