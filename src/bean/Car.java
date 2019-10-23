package bean;

public class Car extends Vehicle {
    private int PassengerCapacity;
    private int accelerationTime;

    public Car(int maxSpeed, int weight, int driveRange, String brand, String number, String model, String color, int paymentPerMinute, int passengerCapacity, int accelerationTime) {
        super(maxSpeed, weight, driveRange, brand, number, model, color, paymentPerMinute);
        PassengerCapacity = passengerCapacity;
        this.accelerationTime = accelerationTime;
    }

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
}
