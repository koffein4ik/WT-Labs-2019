package bean;

import java.util.Objects;

public class Truck extends Vehicle {
    private int cargoCapacity;

    public Truck(int maxSpeed, int weight, int driveRange, String brand, String number, String model, String color, int paymentPerMinute, int cargoCapacity, int cargoVolume) {
        super(maxSpeed, weight, driveRange, brand, number, model, color, paymentPerMinute);
        this.cargoCapacity = cargoCapacity;
        this.cargoVolume = cargoVolume;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(int cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    private int cargoVolume;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return cargoCapacity == truck.cargoCapacity &&
                cargoVolume == truck.cargoVolume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargoCapacity, cargoVolume);
    }
}
