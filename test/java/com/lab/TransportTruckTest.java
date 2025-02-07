package test.java.com.lab;
import src.java.com.lab.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.java.com.lab.DAFFXH;
import static org.junit.jupiter.api.Assertions.*;

public class TransportTruckTest {

    @DisplayName("Load cars case 1")
    @Test
    void loadCarsCase1(){
        //Create vehicle objects
        TransportTruck Daf = new DAFFXH();
        Volvo240 Volvo = new Volvo240();

        // getRampDown() == True                    | OK
        // loadedCars.size() <= 6                   | OK
        // Math.abs(car.getXPos() - getXPos()) < 10 | OK
        // Math.abs(car.getYPos() - getYPos()) < 10 | OK
        // car.getCurrentSpeed == 0                 | OK
        //!loadedCars.contains(car)                 | OK

        Daf.setRampDown(true);
        Daf.setPosition(0,0);
        Volvo.setPosition(0,0);
        Daf.load(Volvo);

        // Assertion
        assertTrue(Daf.getLoadedCars().contains(Volvo));
    }


    @DisplayName("Load cars case 2")
    @Test
    void loadCarsCase2(){

        // getRampDown() == True                    | OK
        // loadedCars.size() <= 6                   | OK
        // Math.abs(car.getXPos() - getXPos()) < 10 | OK
        // Math.abs(car.getYPos() - getYPos()) < 10 | OK
        // car.getCurrentSpeed == 0                 | OK
        //!loadedCars.contains(car)                 | NOK

        //Create objects
        TransportTruck Daf = new DAFFXH();
        Volvo240 Volvo = new Volvo240();

        Daf.setRampDown(true);
        Daf.setPosition(0, 0);
        Volvo.setPosition(0, 0);

        // Load the same object twice
        Daf.load(Volvo);
        Daf.load(Volvo);

        assertEquals(1, Daf.getLoadedCars().size());
    }




    @DisplayName("Load cars case 3")
    @Test
    void loadCarsCase3() {
        //Create vehicle objects
        TransportTruck Daf = new DAFFXH();
        Volvo240 Volvo = new Volvo240();

        // getRampDown() == True                    | OK
        // loadedCars.size() <= 6                   | OK
        // Math.abs(car.getXPos() - getXPos()) < 10 | OK
        // Math.abs(car.getYPos() - getYPos()) < 10 | OK
        // car.getCurrentSpeed == 0                 | NOK
        //!loadedCars.contains(car)                 | OK

        Daf.setRampDown(true);
        Daf.setPosition(0, 0);
        Volvo.setPosition(0, 0);
        Volvo.setEngineState(true);
        Volvo.gas(0.5);
        Daf.load(Volvo);

        // Assertion
        assertFalse(Daf.getLoadedCars().contains(Volvo));
    }
    @DisplayName("Load cars case 4")
    @Test
    void loadCarsCase4(){
        //Create vehicle objects
        TransportTruck Daf = new DAFFXH();
        Volvo240 Volvo = new Volvo240();

        // getRampDown() == True                    | OK
        // loadedCars.size() <= 6                   | OK
        // Math.abs(car.getXPos() - getXPos()) < 10 | OK
        // Math.abs(car.getYPos() - getYPos()) < 10 | NOK
        // car.getCurrentSpeed == 0                 | OK
        //!loadedCars.contains(car)                 | OK

        Daf.setRampDown(true);
        Daf.setPosition(0,15);
        Volvo.setPosition(0,0);
        Daf.load(Volvo);

        // Assertion
        assertFalse(Daf.getLoadedCars().contains(Volvo));
    }
    @DisplayName("Load cars case 5")
    @Test
    void loadCarsCase5(){
        //Create vehicle objects
        TransportTruck Daf = new DAFFXH();
        Volvo240 Volvo = new Volvo240();

        // getRampDown() == True                    | OK
        // loadedCars.size() <= 6                   | OK
        // Math.abs(car.getXPos() - getXPos()) < 10 | NOK
        // Math.abs(car.getYPos() - getYPos()) < 10 | OK
        // car.getCurrentSpeed == 0                 | OK
        //!loadedCars.contains(car)                 | OK

        Daf.setRampDown(true);
        Daf.setPosition(15,0);
        Volvo.setPosition(0,0);
        Daf.load(Volvo);

        // Assertion
        assertFalse(Daf.getLoadedCars().contains(Volvo));
    }

    @DisplayName("Load cars case 6")
    @Test
    void loadCarsCase6() {
        //Create vehicle objects
        TransportTruck Daf = new DAFFXH();
        Volvo240 Volvo1 = new Volvo240();
        Volvo240 Volvo2 = new Volvo240();
        Volvo240 Volvo3 = new Volvo240();
        Volvo240 Volvo4 = new Volvo240();
        Volvo240 Volvo5 = new Volvo240();
        Volvo240 Volvo6 = new Volvo240();
        Saab95 Saab = new Saab95();

        // getRampDown() == True                    | OK
        // loadedCars.size() <= 6                   | NOK
        // Math.abs(car.getXPos() - getXPos()) < 10 | OK
        // Math.abs(car.getYPos() - getYPos()) < 10 | OK
        // car.getCurrentSpeed == 0                 | OK
        //!loadedCars.contains(car)                 | OK

        Daf.setRampDown(true);
        Daf.setPosition(0, 0);

        Volvo1.setPosition(0, 0);
        Daf.load(Volvo1);

        Volvo2.setPosition(0, 0);
        Daf.load(Volvo2);

        Volvo3.setPosition(0, 0);
        Daf.load(Volvo3);

        Volvo4.setPosition(0, 0);
        Daf.load(Volvo4);

        Volvo5.setPosition(0, 0);
        Daf.load(Volvo5);

        Volvo6.setPosition(0, 0);
        Daf.load(Volvo6);

        Saab.setPosition(0,0);
        Daf.load(Saab);

        // Assertion
        assertFalse(Daf.getLoadedCars().contains(Saab));
    }
    @DisplayName("Load cars case 7")
    @Test
    void loadCarsCase7(){
        //Create vehicle objects
        TransportTruck Daf = new DAFFXH();
        Volvo240 Volvo = new Volvo240();

        // getRampDown() == True                    | NOK
        // loadedCars.size() <= 6                   | OK
        // Math.abs(car.getXPos() - getXPos()) < 10 | OK
        // Math.abs(car.getYPos() - getYPos()) < 10 | OK
        // car.getCurrentSpeed == 0                 | OK
        //!loadedCars.contains(car)                 | OK

        Daf.setRampDown(false);
        Daf.setPosition(0,0);
        Volvo.setPosition(0,0);
        Daf.load(Volvo);

        // Assertion
        assertFalse(Daf.getLoadedCars().contains(Volvo));
    }
}
