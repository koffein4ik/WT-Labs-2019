package bean;

public class User extends Human {
    private String nickname;

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
