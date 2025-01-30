import java.awt.*;
import java.io.Console;

public abstract class Vehicle implements Movable {

    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name

    public double xPos = 0; //X-position
    public double yPos = 0; //Y-position
    public int currentDirection = 1; //current facing direction
    public double speed;

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
        currentSpeed = Math.min(getCurrentSpeed() + speed * amount, enginePower);
    }
    public void decrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() - speed * amount,0);
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
}
