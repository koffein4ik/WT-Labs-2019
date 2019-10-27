package bean;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return PassengerCapacity == car.PassengerCapacity &&
                accelerationTime == car.accelerationTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), PassengerCapacity, accelerationTime);
    }
}
