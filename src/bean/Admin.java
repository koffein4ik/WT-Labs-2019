package bean;

public class Admin extends Human {
    private String nickname;
    private int userRequestsAnswered;
    private int salary;
    private int accessLevel;

    public Admin(String name, String surname, String phoneNumber, String passportNumber, String nickname, int userRequestsAnswered, int salary, int accessLevel) {
        super(name, surname, phoneNumber, passportNumber);
        this.nickname = nickname;
        this.userRequestsAnswered = userRequestsAnswered;
        this.salary = salary;
        this.accessLevel = accessLevel;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getUserRequestsAnswered() {
        return userRequestsAnswered;
    }

    public void setUserRequestsAnswered(int userRequestsAnswered) {
        this.userRequestsAnswered = userRequestsAnswered;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
}
