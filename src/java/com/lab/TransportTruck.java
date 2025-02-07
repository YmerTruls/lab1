package src.java.com.lab;

import java.awt.*;
import java.util.ArrayList;

public abstract class TransportTruck extends Truck {

    private boolean rampDown;
    private final ArrayList<Car> loadedCars;

    public TransportTruck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
        this.loadedCars = new ArrayList<>();

    }

    public void setRampDown(boolean state){
        if(state) {
            if (getCurrentSpeed() == 0) {
                rampDown = true;
            }
        }

        else {
            rampDown = false;
        }
    }

    public boolean getRampDown(){
        return rampDown;
    }
    @Override
    public void move(){
        super.move();
        for (Car car : loadedCars) {
            car.setPosition(getXPos(),getXPos());
        }

    }

    @Override
    public void gas(double amount){
        if (!getRampDown()){
            super.gas(amount);
        }
        else{
            System.out.println("Ramp Down, Unable to gas.");
        }
    }

    public ArrayList<Car> getLoadedCars(){
        return loadedCars;
    }

    public void load(Car car){
        if(getRampDown() && loadedCars.size() < 6 &&
                Math.abs(car.getXPos() - getXPos()) < 10 &&
                Math.abs(car.getYPos() - getYPos()) < 10 &&
                car.getCurrentSpeed() == 0 &&
                !loadedCars.contains(car)){

            loadedCars.add(car);
            car.setPosition(getXPos(), getYPos());
            car.setEngineState(false);
        }
    }

    public Car unload(){
        int size = loadedCars.size();
        if(getRampDown() && size > 0){
            Car car = loadedCars.get(size-1);
            loadedCars.remove(size);
            car.setPosition((getXPos() -5 ), (getYPos()- 5));
            return car;
        }
        else {
            return null;
        }
    }

}
