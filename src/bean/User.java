package bean;

public class User extends Human {
    private String nickname;

    public User(String name, String surname, String phoneNumber, String passportNumber, String nickname, int moneyOnBalance, int tripsCompleted) {
        super(name, surname, phoneNumber, passportNumber);
        this.nickname = nickname;
        this.moneyOnBalance = moneyOnBalance;
        this.tripsCompleted = tripsCompleted;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getMoneyOnBalance() {
        return moneyOnBalance;
    }

    public void setMoneyOnBalance(int moneyOnBalance) {
        this.moneyOnBalance = moneyOnBalance;
    }

    public int getTripsCompleted() {
        return tripsCompleted;
    }

    public void setTripsCompleted(int tripsCompleted) {
        this.tripsCompleted = tripsCompleted;
    }

    private int moneyOnBalance;
    private int tripsCompleted;
}
