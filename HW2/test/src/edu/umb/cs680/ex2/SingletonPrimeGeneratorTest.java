package edu.umb.cs680.ex2;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SingletonPrimeGeneratorTest {

    @Test
    public void GetInstance() {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(1,10);
        assertNotNull(gen);
    }

    @Test
    public void GetInstanceReturnsSameInstance() {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(1,10);
        SingletonPrimeGenerator gen2 = SingletonPrimeGenerator.getInstance(1,-100);
        assertSame(gen, gen2);
    }

    @Test
    public void GetPrimes() {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(1,50);
        gen.generatePrimes();
        List<Long> expectedPrimes = Arrays.asList(
                2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L,
                31L, 37L, 41L, 43L, 47L);
        List<Long> actualPrimes = gen.getPrimes();
        assertIterableEquals(expectedPrimes, actualPrimes);
    }

//    @Test
//    public void InvalidInput() {
//        assertThrows(RuntimeException.class, () -> {  SingletonPrimeGenerator.getInstance(1,-22);
//        });
//        assertThrows(RuntimeException.class, () -> { SingletonPrimeGenerator.getInstance(10, 1);
//        });
//        assertThrows(RuntimeException.class, () -> { SingletonPrimeGenerator.getInstance(1, -1000);
//        });
//    }
}

