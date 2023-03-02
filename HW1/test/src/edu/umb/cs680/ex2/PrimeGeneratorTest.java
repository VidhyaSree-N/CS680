package edu.umb.cs680.ex2;

import edu.umb.cs680.ex2.PrimeGenerator;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeGeneratorTest {

    @Test
    public void Prime1to10(){
        PrimeGenerator prime = new PrimeGenerator(2,10);
        prime.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L};
        assertArrayEquals( expectedPrimes,
                prime.getPrimes().toArray() );
    }

    @Test
    public void Prime1to100Count(){
        PrimeGenerator prime = new PrimeGenerator(2,51);
        prime.generatePrimes();
        LinkedList<Long> allprimes = prime.getPrimes();
        assertEquals( 15,allprimes.size() );
    }

    @Test
    public void InvalidRange100to1() {
        try {
            PrimeGenerator prime = new PrimeGenerator(100, 1);
            prime.generatePrimes();
            fail("Wrong input values");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=100 to=1", ex.getMessage());
        }
    }

    @Test
    public void InvalidRangeNegative() {
        try {
            PrimeGenerator prime = new PrimeGenerator(-1, 20);
            prime.generatePrimes();
            fail("Wrong input values");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=-1 to=20", ex.getMessage());
        }
    }

    @Test
    public void InvalidRangeEqual() {
        try {
            PrimeGenerator prime = new PrimeGenerator(5, 5);
            prime.generatePrimes();
            fail("Wrong input values");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=5 to=5", ex.getMessage());
        }
    }
}
