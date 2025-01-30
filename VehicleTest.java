import org.junit.*;
import static org.junit.Assert.* ;

public class VehicleTest {

    @Test
    public void testModel() {
        System.out.println("Test if model name is reachable") ;
        Vehicle vehicle = new Vehicle();
        vehicle.modelName = "Banan";
        assertTrue(vehicle.modelName.equals("Volvo240") || vehicle.modelName.equals("Saab95"));
    }
}