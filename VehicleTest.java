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
    public void testMove(){
        //Set-up
        Volvo240 volvo = new Volvo240();
        volvo.currentSpeed = 1;

        for(int i=1; i < 5; i++){
            volvo.currentDirection = i;

            double xPos1 = volvo.xPos;
            double yPos1 = volvo.yPos;
            volvo.move();
            double xPos2 = volvo.xPos;
            double yPos2 = volvo.yPos;

            assertTrue(xPos1 != xPos2 || yPos1 != yPos2);
        }
    }

    @DisplayName("Test all turns.")
    @Test
    public void testTurn(){
        //Initiate vehicle
        Volvo240 volvo = new Volvo240();

        //Direction is 1, right turn
        volvo.currentDirection = 1;
        volvo.turnRight();
        assertEquals(4, volvo.currentDirection);

        //Direction is 4, right turn
        volvo.currentDirection = 4;
        volvo.turnRight();
        assertEquals(3, volvo.currentDirection);

        //Direction is 3, right turn
        volvo.currentDirection = 3;
        volvo.turnRight();
        assertEquals(2, volvo.currentDirection);

        //Direction is 2, right turn
        volvo.currentDirection = 2;
        volvo.turnRight();
        assertEquals(1, volvo.currentDirection);

        //Direction is 1, right turn
        volvo.currentDirection = 1;
        volvo.turnRight();
        assertEquals(4, volvo.currentDirection);

        //Direction is 1, left turn
        volvo.currentDirection = 1;
        volvo.turnLeft();
        assertEquals(2, volvo.currentDirection);

        //Direction is 2, left turn
        volvo.currentDirection = 2;
        volvo.turnLeft();
        assertEquals(3, volvo.currentDirection);

        //Direction is 3, left turn
        volvo.currentDirection = 3;
        volvo.turnLeft();
        assertEquals(4, volvo.currentDirection);

        //Direction is 4, left turn
        volvo.currentDirection = 4;
        volvo.turnLeft();
        assertEquals(1, volvo.currentDirection);
    }

    @DisplayName("Test extreme left turning.")
    @Test
    public void turnLeftExtreme(){
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
    public void testDecrementSpeed(){
        Vehicle vehicle = new Vehicle();
        vehicle.startEngine();
        double speed_before = vehicle.getCurrentSpeed();
        vehicle.decrementSpeed(100);
        double speed_after = vehicle.getCurrentSpeed();
        assertNotEquals(speed_before,speed_after);
    }
    @DisplayName("Increment Speed")
    @Test
    public void testIncrementSpeed(){
        Vehicle vehicle = new Vehicle();
        vehicle.startEngine();
        double speed_before = vehicle.getCurrentSpeed();
        vehicle.incrementSpeed(100);
        double speed_after = vehicle.getCurrentSpeed();
        assertNotEquals(speed_before,speed_after);
    }
    @DisplayName("Color is correct")
    @Test
    public void testColor(){
        Vehicle vehicle = new Vehicle();
        vehicle.setColor(Color.black);
        assertSame(Color.black, vehicle.getColor());
    }
    @DisplayName("Saab95 Enginepower sets itself")
    @Test
    public void Saab95enginePower(){
        Saab95 vehicle = new Saab95();
        vehicle.startEngine();
        double powerII = vehicle.getEnginePower();
        assertEquals(125,powerII);
    }
    @DisplayName("Saab95 Enginepower sets itself")
    @Test
    public void Volvo240enginePower(){
        Volvo240 vehicle = new Volvo240();
        vehicle.startEngine();
        double powerII = vehicle.getEnginePower();
        assertEquals(100,powerII);
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("All tests successful.");
    }
    @DisplayName("Engine stops")
    @Test
    public void test_stopEngine(){
        Volvo240 vehicle = new Volvo240();
        vehicle.startEngine();
        vehicle.stopEngine();
        double EngineII = vehicle.getEnginePower();
        assertEquals(0,EngineII);
    }

    @DisplayName("Saab95 Doors are correct")
    @Test
    public void test_Saab_Doors() {
        Saab95 vehicle = new Saab95();
        assertSame(2, vehicle.getNrDoors());
    }
    @DisplayName("Volvo240 Doors are correct")
    @Test
    public void test_Volvo_Doors() {
        Volvo240 vehicle = new Volvo240();
        assertSame(4, vehicle.getNrDoors());
    }
}

public class Volvo240Test extends Volvo240{
    Vehicle vehicle = new Vehicle();


}