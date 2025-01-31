import java.awt.*;

public abstract class Vehicle implements Movable {



    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    private double xPos = 0; //X-position
    private double yPos = 0; //Y-position
    public int currentDirection = 1; //current facing direction
    public abstract double speedFactor();

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine(); // Set speed to 0 initially
    }

    public double getxPos(){
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public String getModelName() {
        return modelName;
    }

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
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
    public void turnRight(){
        currentDirection -= 1;

        if(currentDirection == 0){
            currentDirection = 4;
        }
    }

    public void turnLeft(){
        currentDirection += 1;

        if(currentDirection == 5){
            currentDirection = 1;
        }
    }

    //1: x+
    //2: y+
    //3: x-
    //4: y-
    // when 5 set to one, when 0 set to 4

    public void move(){
        switch(currentDirection){
            case 1 ->
                    xPos += currentSpeed;
            case 2 ->
                    yPos += currentSpeed;
            case 3 ->
                    xPos -= currentSpeed;
            case 4 ->
                    yPos -= currentSpeed;
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
