package src.java.com.lab;
import java.util.ArrayList;

public abstract class Workshop<T extends Vehicle> {

    private final int capacity;
    private final double XPos;
    private final double YPos;
    private final ArrayList<T> loadedCars;

    public Workshop(int capacity, double XPos, double YPos) {
        this.loadedCars = new ArrayList<>();
        this.capacity = capacity;
        this.XPos = XPos;
        this.YPos = YPos;

    }

    public double getYPos() {
        return YPos;
    }

    public double getXPos() {
        return XPos;
    }

    public void load(T car) {
        if (
                loadedCars.size() < capacity &&
                Math.abs(car.getXPos() - getXPos()) < 10 &&
                Math.abs(car.getYPos() - getYPos()) < 10 &&
                car.getCurrentSpeed() == 0 &&
                !loadedCars.contains(car)) {

            loadedCars.add(car);
            car.setPosition(getXPos(), getYPos());
            car.setEngineState(false);
        }
    }

    public T unload(T car) {
        if (loadedCars.remove(car)) {
            car.setPosition(getXPos() - 5, getYPos() - 5);
            return car;
        }
        else{
            System.out.println("Car not found in workshop");
            return null;

            }
    }

    public ArrayList<T> getLoadedCars() {
        return loadedCars;
    }
}
