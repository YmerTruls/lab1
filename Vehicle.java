import java.awt.*;

public abstract class Vehicle implements Movable {

    protected int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    protected double xPos = 0; //X-position
    protected double yPos = 0; //Y-position
    protected int currentDirection = 1; //current facing direction
    public abstract double speedFactor();

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color clr){
        color = clr;
    }
    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }
    public void setCurrentDirection(int direction){ currentDirection = direction;}
    public int getCurrentDirection(){return currentDirection;}
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
    public void turnRight(){
        setCurrentDirection(getCurrentDirection()-1);

        if(getCurrentDirection() == 0){
            setCurrentDirection(4);
        }
    }

    public void turnLeft(){
        setCurrentDirection(getCurrentDirection()+1);

        if(getCurrentDirection() == 5){
            setCurrentDirection(1);
        }
    }

    //1: x+
    //2: y+
    //3: x-
    //4: y-
    // when 5 set to one, when 0 set to 4

    public void move(){
        switch(getCurrentDirection()){
            case 1 ->
                xPos += currentSpeed;
            case 2 ->
                yPos += currentSpeed;
            case 3 ->
                xPos -= currentSpeed;
            case 4 ->
                yPos -= currentSpeed;
            default -> throw new
                    IllegalStateException("Unexpected value (getCurrentDirection): " + getCurrentDirection());
        }
    }

    public void gas(double amount){
        if(0 <= amount && amount <= 1){
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if(0 <= amount && amount <= 1){
            decrementSpeed(amount);
        }
    }
}
