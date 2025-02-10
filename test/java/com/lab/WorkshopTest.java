package test.java.com.lab;
import src.java.com.lab.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;



public class WorkshopTest {

    @Test
    @DisplayName("Get position")
    void getPosition() {
        MulleMeck volvoWorkshop = new MulleMeck();

        // MulleMeck standard values: XPos=50, YPos=60
        assertEquals(50, volvoWorkshop.getXPos());
        assertEquals(60, volvoWorkshop.getYPos());
    }

    @Test
    @DisplayName("Load cars in workshop")
    void load() {
        // Create and load Volvo240 object
        MulleMeck volvoWorkshop = new MulleMeck();
        Volvo240 volvo = new Volvo240();
        volvo.setPosition(50,60);
        volvoWorkshop.load(volvo);

        // Test if Volvo240 was loaded
        ArrayList<Volvo240> loadedCars = volvoWorkshop.getLoadedCars();
        Volvo240 firstCar = loadedCars.getFirst();
        assertSame(volvo, firstCar);
    }

    @Test
    @DisplayName("Unload cars from workshop")
    void unload() {
        // Create and load Volvo240 object
        MulleMeck volvoWorkshop = new MulleMeck();
        Volvo240 volvo = new Volvo240();
        volvo.setPosition(50,60);
        volvoWorkshop.load(volvo);

        Car unloadedCar = volvoWorkshop.unload(volvo);

        assertTrue(volvoWorkshop.getLoadedCars().isEmpty());
        assertSame(volvo, unloadedCar);
    }

    //@Test
    //@DisplayName("Unload empty workshop")
    //void unloadEmpty() {
        //MulleMeck volvoWorkshop = new MulleMeck();
        //Vehicle unloaded = volvoWorkshop.unload();
        //assertNull(unloaded);
    //}
}
