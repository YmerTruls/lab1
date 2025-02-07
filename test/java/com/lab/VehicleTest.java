package test.java.com.lab;
import src.java.com.lab.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.java.com.lab.Saab95;
import src.java.com.lab.Scania;
import src.java.com.lab.Volvo240;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    @DisplayName("Test if model name is reachable.")
    @Test
    public void testModel() {
        Volvo240 volvo = new Volvo240();
        assertEquals("src.java.com.lab.Volvo240", volvo.getModelName());

        Saab95 saab = new Saab95();
        assertEquals("src.java.com.lab.Saab95", saab.getModelName());
    }

    @DisplayName("Test if move is possible")
    @Test
    public void testMove() {
        //Set-up
        Volvo240 volvo = new Volvo240();
        volvo.setEngineState(true);
        volvo.gas(0.5);

        for (int i = 1; i < 5; i++) {
            volvo.setCurrentDirection(i);

            double xPos1 = volvo.getXPos();
            double yPos1 = volvo.getYPos();
            volvo.move();
            double xPos2 = volvo.getXPos();
            double yPos2 = volvo.getYPos();

            assertTrue(xPos1 != xPos2 || yPos1 != yPos2);
        }


        //Test illegal direction
        volvo.setCurrentDirection(0);
        assertThrows(IllegalStateException.class, volvo::move);
    }

    @DisplayName("Test all turns.")
    @Test
    public void testTurn() {
        //Initiate vehicle
        Volvo240 volvo = new Volvo240();
        //Tests every direction when turning right
        for (int i = 1; i < 5; i++){
            volvo.setCurrentDirection(i);
            //handling of edge case
            volvo.turnRight();
            if(i == 1){
                assertEquals(4, volvo.getCurrentDirection());
            }
            else{
                assertEquals(i-1, volvo.getCurrentDirection());
            }
        }
        //Tests every direction when turning left
        for (int i = 1; i < 5; i++){
            volvo.setCurrentDirection(i);
            //handling of edge case
            volvo.turnLeft();
            if (i == 4){
                assertEquals(1,volvo.getCurrentDirection());
            }
            else {
                assertEquals(i+1, volvo.getCurrentDirection());
            }
        }
    }

    @DisplayName("Color is correctly set and gotten")
    @Test
    public void testColor() {
        Volvo240 volvo = new Volvo240();
        assertSame(Color.black, volvo.getColor());

        Saab95 saab = new Saab95();
        assertSame(Color.red, saab.getColor());

        saab.setColor(Color.black);
        assertNotSame(Color.red, saab.getColor());

        volvo.setColor(Color.red);
        assertNotSame(Color.black, volvo.getColor());
    }

    @DisplayName("Engine starts")
    @Test
    public void test_startEngine() {
        Saab95 saab = new Saab95();
        saab.setEngineState(true);
        assertTrue(saab.getEngineState());

        Volvo240 volvo = new Volvo240();
        volvo.setEngineState(false);
        assertFalse(volvo.getEngineState());
    }

    @DisplayName("Get EnginePower")
    @Test
    public void test_getEnginePower(){
        Volvo240 volvo = new Volvo240();
        assertEquals(100, volvo.getEnginePower());

        Saab95 saab = new Saab95();
        assertEquals(125,saab.getEnginePower());

    }

    @DisplayName("Engine stops")
    @Test
    public void test_stopEngine() {
        Volvo240 volvo = new Volvo240();
        volvo.setEngineState(true);
        volvo.setEngineState(false);
        assertEquals(0, volvo.getCurrentSpeed());

        Saab95 saab = new Saab95();
        saab.setEngineState(true);
        saab.setEngineState(false);
        assertEquals(0, saab.getCurrentSpeed());
    }

    @DisplayName("Doors are correct")
    @Test
    public void test_Saab_Doors() {
        Saab95 Saab = new Saab95();
        assertEquals(2, Saab.getNrDoors());

        Volvo240 Volvo = new Volvo240();
        assertEquals(4, Volvo.getNrDoors());
    }

    @DisplayName("Speed factor OK")
    @Test
    public void test_speedFactor(){
        Volvo240 volvo = new Volvo240();
        volvo.speedFactor();
        assertEquals(volvo.speedFactor(),volvo.getEnginePower() * 0.01 * 1.25);

        Saab95 saab = new Saab95();
        saab.setTurboOff();
        saab.speedFactor();
        assertEquals(saab.speedFactor(),saab.getEnginePower() * 0.01 * 1);

        saab.setTurboOn();
        saab.speedFactor();
        assertEquals(saab.speedFactor(),saab.getEnginePower() * 0.01 * 1.3);

    }

    @DisplayName("Test gas()")
    @Test
    public void test_gas(){
        //Set-up
        Volvo240 volvo = new Volvo240();
        volvo.setEngineState(true);

        //Test OK value
        volvo.setEngineState(true);
        volvo.gas(0.5);
        assertEquals(0.625, volvo.getCurrentSpeed());

        //Test NOK value
        volvo.gas(5);
        assertEquals(0.625, volvo.getCurrentSpeed());


        volvo.gas(-1);
        assertEquals(0.625, volvo.getCurrentSpeed());

        volvo.setEngineState(false);
        volvo.gas(0.5);
        assertEquals(0.625, volvo.getCurrentSpeed());

    }
    @DisplayName("Test brake()")
    @Test
    public void test_brake(){
        //Set-up
        Volvo240 volvo = new Volvo240();
        volvo.setEngineState(true);

        //Test OK value
        volvo.gas(1);
        volvo.brake(0.5);
        assertEquals(0.625, volvo.getCurrentSpeed(), 0.001);

        //Test NOK value
        volvo.brake(5);
        assertEquals(0.625, volvo.getCurrentSpeed());

        volvo.brake(-1);
        assertEquals(0.625, volvo.getCurrentSpeed());
    }
    @DisplayName("src.java.com.lab.Scania Platform")
    @Test
    public void test_platform(){
        Scania scania = new Scania();
        scania.increaseAngle(50);
        assertEquals(50, scania.getAngle());

        scania.decreaseAngle(30);
        assertEquals(20, scania.getAngle());

        scania.decreaseAngle(50);
        assertEquals(0, scania.getAngle());

        scania.increaseAngle(80);
        assertEquals(70, scania.getAngle());

        scania.setEngineState(true);
        double xPos = scania.getXPos();
        scania.gas(0.5);
        scania.move();
        assertEquals(xPos, scania.getXPos());

        scania.decreaseAngle(50);
        scania.increaseAngle(10);
        assertEquals(20, scania.getAngle());

        scania.decreaseAngle(20);
        scania.move();
        assertNotEquals(xPos, scania.getXPos());

        scania.incrementSpeed(1);
        assertEquals(3, scania.getCurrentSpeed());
    }
}
