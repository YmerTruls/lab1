package src.java.com.lab;

import java.awt.Color;

public class DAFFXH extends TransportTruck {


    public DAFFXH() {
        super(6,70,Color.blue,"DafXH");
        setRampDown(false);
    }

    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

}