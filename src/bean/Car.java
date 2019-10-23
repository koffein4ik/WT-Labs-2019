package bean;

public class Car extends Vehicle {
    private int PassengerCapacity;

    public int getPassengerCapacity() {
        return PassengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        PassengerCapacity = passengerCapacity;
    }

    public int getAccelerationTime() {
        return accelerationTime;
    }

    public void setAccelerationTime(int accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    private int accelerationTime;
}
