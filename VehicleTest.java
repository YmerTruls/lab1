import jdk.jfr.Name;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    @DisplayName("Test if model name is reachable.")
    @Test
    public void testModel() {
        Volvo240 volvo = new Volvo240();
        assertEquals("Volvo240", volvo.modelName);

        Saab95 saab = new Saab95();
        assertEquals("Saab95", saab.modelName);
    }

    @DisplayName("Test if move is possible")
    @Test
    public void testMove() {
        //Set-up
        Volvo240 volvo = new Volvo240();
        volvo.currentSpeed = 1;

        for (int i = 1; i < 5; i++) {
            volvo.currentDirection = i;

            double xPos1 = volvo.xPos;
            double yPos1 = volvo.yPos;
            volvo.move();
            double xPos2 = volvo.xPos;
            double yPos2 = volvo.yPos;

            assertTrue(xPos1 != xPos2 || yPos1 != yPos2);
        }
        Saab95 saab = new Saab95();
        saab.currentSpeed = 1;

        for (int i = 1; i < 5; i++) {
            saab.currentDirection = i;

            double xPos1 = saab.xPos;
            double yPos1 = saab.yPos;
            saab.move();
            double xPos2 = saab.xPos;
            double yPos2 = saab.yPos;

            assertTrue(xPos1 != xPos2 || yPos1 != yPos2);
        }
    }

    @DisplayName("Test all turns.")
    @Test
    public void testTurn() {
        //Initiate vehicle
        Volvo240 volvo = new Volvo240();
        //Tests every direction when turning right
        for (int i = 1; i < 5; i++){
            volvo.currentDirection = i;
            //handling of edge case
            if (i == 1){
                volvo.turnRight();
                assertEquals(4, volvo.currentDirection );
            }
            else{
                volvo.turnRight();
                assertEquals(i-1, volvo.currentDirection);
            }
        }
        //Tests every direction when turning left
        for (int i = 1; i < 5; i++){
            volvo.currentDirection = i;
            //handling of edge case
            if (i == 4){
                volvo.turnLeft();
                assertEquals(1,volvo.currentDirection);
            }
            else {
                volvo.turnLeft();
                assertEquals(i+1, volvo.currentDirection);
            }
        }

        //Initiate vehicle
        Saab95 saab = new Saab95();
        //Tests every direction when turning right
        for (int i = 1; i < 5; i++){
            saab.currentDirection = i;
            //handling of edge case
            if (i == 1){
                saab.turnRight();
                assertEquals(4, saab.currentDirection );
            }
            else{
                saab.turnRight();
                assertEquals(i-1, saab.currentDirection);
            }
        }
        //Tests every direction when turning left
        for (int i = 1; i < 5; i++){
            saab.currentDirection = i;
            //handling of edge case
            if (i == 4){
                saab.turnLeft();
                assertEquals(1,saab.currentDirection);
            }
            else {
                saab.turnLeft();
                assertEquals(i+1, saab.currentDirection);
            }
        }
    }

    @DisplayName("Test extreme left turning.")
    @Test
    public void turnLeftExtreme() {
        Volvo240 volvo = new Volvo240();
        int first_pos = volvo.currentDirection;
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        int second_pos = volvo.currentDirection;
        assertEquals(first_pos, second_pos);
    }

    @DisplayName("Decrement speed")
    @Test
    public void testDecrementSpeed() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        double speed_before = volvo.getCurrentSpeed();
        volvo.decrementSpeed(100);
        assertNotEquals(speed_before, volvo.getCurrentSpeed());

        Saab95 saab = new Saab95();
        saab.startEngine();
        double speed_beforeI = saab.getCurrentSpeed();
        saab.decrementSpeed(100);
        assertNotEquals(speed_beforeI, saab.getCurrentSpeed());
    }

    @DisplayName("Increment Speed")
    @Test
    public void testIncrementSpeed() {
        Vehicle volvo = new Volvo240();
        volvo.startEngine();
        double speed_before = volvo.getCurrentSpeed();
        volvo.incrementSpeed(100);
        assertNotEquals(speed_before, volvo.getCurrentSpeed());

        Saab95 saab = new Saab95();
        saab.startEngine();
        double speed_beforeI = saab.getCurrentSpeed();
        saab.incrementSpeed(10);
        assertNotEquals(speed_beforeI, saab.getCurrentSpeed());
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
        saab.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed());

        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        assertEquals(0.1, volvo.getCurrentSpeed());
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
        volvo.startEngine();
        volvo.stopEngine();
        assertEquals(0, volvo.getCurrentSpeed());

        Saab95 saab = new Saab95();
        saab.startEngine();
        saab.stopEngine();
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
        assertEquals(volvo.speed,volvo.enginePower * 0.01 * 1.25);

        Saab95 saab = new Saab95();
        saab.setTurboOff();
        saab.speedFactor();
        assertEquals(saab.speed,saab.enginePower * 0.01 * 1);

        saab.setTurboOn();
        saab.speedFactor();
        assertEquals(saab.speed,saab.enginePower * 0.01 * 1.3);

    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All tests successful.");
    }
}







