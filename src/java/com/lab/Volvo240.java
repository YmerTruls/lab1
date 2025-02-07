package src.java.com.lab;

import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4, 100, Color.black, "src.java.com.lab.Volvo240");
        setEngineState(false);
    }
    public double speedFactor(){
    return getEnginePower() * 0.01 * trimFactor;
    }
}
