package src.java.com.lab;

public class OnOffLift implements Ramp {

    private boolean rampState;

    public OnOffLift(){
        rampState = false;
    }

    @Override
    public boolean isRampLowered() {
        return rampState;
    }

    public void raiseRamp(){
        rampState = false;
    }
    public void lowerRamp(){
        rampState = true;

    }


}
