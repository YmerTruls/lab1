package src.java.com.lab;

import java.awt.Color;

public class Scania extends Truck {

    private AngularLift scaniaLift;
    private double platformAngle;
    public Scania(){
        super(2,200, Color.YELLOW, "src.java.com.lab.Scania");
        setEngineState(false);
        setRampDown(70); //Set platform angle to 0 degrees
        AngularLift scaniaLift = new AngularLift(0, 70);
    }
    public double getAngle() {
        return scaniaLift.getAngle();
    }


    public void setRampUp(double amount) {
        if (getCurrentSpeed() == 0) {
            scaniaLift.raiseRamp();
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