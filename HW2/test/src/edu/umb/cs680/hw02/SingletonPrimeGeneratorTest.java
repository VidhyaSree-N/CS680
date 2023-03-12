package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class SingletonPrimeGeneratorTest {

    @Test
    public void GetInstance() {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(2,10);
        assertNotNull(gen);
    }

    @Test
    public void GetInstanceReturnsSameInstance() {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(2,10);
        SingletonPrimeGenerator gen2 = SingletonPrimeGenerator.getInstance(2,100);
        assertSame(gen, gen2);
    }

    @Test
    public void GetPrimes() {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(2,50);
        gen.generatePrimes();
        List<Long> expectedPrimes = Arrays.asList(
                2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L,
                31L, 37L, 41L, 43L, 47L);
        List<Long> actualPrimes = gen.getPrimes();
        assertIterableEquals(expectedPrimes, actualPrimes);
    }

    @Test
    public void InvalidInput() {
        SingletonPrimeGenerator.resetInstance();
        assertThrows(RuntimeException.class, () -> { SingletonPrimeGenerator.getInstance(-1, -1000);
        });
    }

    @Test
    public void InvalidRange1tonegative50() {
        SingletonPrimeGenerator.resetInstance();
        try {
            SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(1,-50);
            gen.generatePrimes();
            fail("Wrong input values");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=1 to=-50", ex.getMessage());
        }
    }

    @Test
    public void InvalidRangeHighertoLower() {
        SingletonPrimeGenerator.resetInstance();
        try {
            SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(54,35);
            gen.generatePrimes();
            fail("Wrong input values");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=54 to=35", ex.getMessage());
        }
    }
}

