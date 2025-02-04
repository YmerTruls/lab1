import java.awt.Color;

public class Scania extends Vehicle {

    private double platformAngle;

    public Scania(){
        super(2,200, Color.YELLOW, "Scania");
        stopEngine();
        platformAngle = 0; //Set platform angle to 0 degrees
    }
    public double getAngle(){
        return platformAngle;
    }
    public void increaseAngle(double amount) {
        if (getCurrentSpeed() == 0) {
            platformAngle = Math.min(platformAngle + Math.abs(amount), 70);
        }
        else {
            System.out.println("Vehicle moving, cannot raise platform");
        }
    }
    public void decreaseAngle(double amount){
            platformAngle = Math.max(platformAngle - Math.abs(amount), 0);
    }
    @Override
    public void move(){
        if (getAngle() > 0){
            System.out.println("Platform raised. Cannot move");
        }
        else {
            super.move();
        }
    }
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
}