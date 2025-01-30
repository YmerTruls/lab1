import java.awt.*;

public class Saab95 extends Vehicle{

    private boolean turboOn;

    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }

    private void setTurboOn(){
	    turboOn = true;
    }

    private void setTurboOff(){
	    turboOn = false;
    }
    
    private void speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        speed = enginePower * 0.01 * turbo;
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
