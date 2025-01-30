import java.awt.*;

public class Volvo240 extends Vehicle{

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }
    private void speedFactor(){
    speed = enginePower * 0.01 * trimFactor;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }


}


