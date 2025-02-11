package src.java.com.lab;

import java.awt.Color;

public class Scania extends Truck {

    private double platformAngle;
    public Scania(){
        super(2,200, Color.YELLOW, "src.java.com.lab.Scania");
        setEngineState(false);
        setRampDown(70); //Set platform angle to 0 degrees
    }
    public double getAngle() {
        return platformAngle;
    }


    public void setRampUp(double amount) {
        if (getCurrentSpeed() == 0) {
            platformAngle = Math.min(platformAngle + Math.abs(amount), 70);
        } else {
            System.out.println("src.java.com.lab.Vehicle moving, cannot raise platform");
        }
    }

    public void setRampDown(double amount) {

        platformAngle = Math.max(platformAngle - Math.abs(amount), 0);
    }

    @Override
    public void move(){
        if (getAngle() == 0) {
            super.move();
        }
        else {
            System.out.println("Platform raised, cannot move.");
        }
    }
}