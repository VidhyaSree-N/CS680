package  edu.umb.cs680.hw3;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class CarTest {
    private String[] carToStringArray(Car car) {
        String[] carInfo = { car.getMake(), car.getModel(), Integer.toString(car.getYear()) };
        return carInfo;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        Car car1 = new Car("Toyota", "RAV4", 20000, 2018, 25000);
        Car car2 = new Car("Toyota", "RAV4", 30000, 2018, 23000);

        String[] expected = { "Toyota", "RAV4", "2018" };
        assertArrayEquals(expected, carToStringArray(car1));
        assertArrayEquals(expected, carToStringArray(car2));
    }
}
