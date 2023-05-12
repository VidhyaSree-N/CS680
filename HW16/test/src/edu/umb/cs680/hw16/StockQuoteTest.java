package edu.umb.cs680.hw16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StockQuoteTest {

    private StockQuoteObservable observable;

    @BeforeEach
    public void setUp() {
        observable = new StockQuoteObservable();
    }

    @Test
    public void testNotifyObserver() {
        LineChartObserver lineChartObserver = new LineChartObserver();
        observable.addObserver(lineChartObserver);
        Map<String,Double> expected = new HashMap<>();
        expected.put("AAPLgdfj", 100.00);

        observable.changeQuote("AAPLgdfj", 100.00);
        assertEquals(1,observable.countObservers());
        assertEquals(lineChartObserver,observable.getObservers().get(0));
        assertNotNull(observable.getTickerQuoteMap().containsKey("AAPLlgdfj"));
        assertEquals(expected,observable.getTickerQuoteMap());
        observable.removeObserver(lineChartObserver);

    }

    @Test
    void testMultipleObserversUpdate() {
        LineChartObserver lineChartObserver = new LineChartObserver();
        TableObserver tableObserver = new TableObserver();
        ThreeDObserver threeDObserver = new ThreeDObserver();
        observable.addObserver(lineChartObserver);
        observable.addObserver(tableObserver);
        observable.addObserver(threeDObserver);

        Map<String,Double> expected = new HashMap<>();
        expected.put("AsdftgY", 100.00);
        expected.put("qwerty",1567.89);
        observable.changeQuote("AsdftgY", 100.00);
        observable.changeQuote("qwerty", 1567.89);

        assertEquals(3,observable.countObservers());
        assertEquals(lineChartObserver,observable.getObservers().get(0));
        assertEquals(tableObserver,observable.getObservers().get(1));
        assertEquals(threeDObserver,observable.getObservers().get(2));
        assertNotNull(observable.getTickerQuoteMap().containsKey("AAPLlgdfj"));
        assertEquals(expected,observable.getTickerQuoteMap());
        assertEquals(2,observable.getTickerQuoteMap().size());
        observable.removeObserver(tableObserver);
        observable.removeObserver(threeDObserver);
        observable.removeObserver(lineChartObserver);

    }


    @Test
    public void testClearObservers() {
        TableObserver tableObserver = new TableObserver();
        LineChartObserver lineChartObserver = new LineChartObserver();

        observable.addObserver(tableObserver);
        observable.addObserver(lineChartObserver);

        observable.clearObservers();

        assertEquals(0,observable.countObservers());

    }

    @Test
    void testRemoveObserver() {
        LineChartObserver lineChartObserver = new LineChartObserver();
        TableObserver tableObserver = new TableObserver();
        observable.addObserver(lineChartObserver);
        observable.addObserver(tableObserver);
        observable.changeQuote("AAPLgdfj", 100.00);

        assertEquals(lineChartObserver,observable.getObservers().get(0));
        assertEquals(tableObserver,observable.getObservers().get(1));
        observable.removeObserver(lineChartObserver);
        assertEquals(1,observable.countObservers());
        assertEquals(tableObserver,observable.getObservers().get(0));
        observable.removeObserver(tableObserver);

    }

    @Test
    void randomQuoteChangeNotification() throws InterruptedException {
        LineChartObserver lineChartObserver = new LineChartObserver();
        TableObserver tableObserver = new TableObserver();
        ThreeDObserver threeDObserver = new ThreeDObserver();

        observable.addObserver(tableObserver);
        observable.addObserver(threeDObserver);
        observable.addObserver(lineChartObserver);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String ticker = "AAPLgdfj";
                // Generates random quote
                double quote = Math.random() * 1000;
                observable.changeQuote(ticker, quote);
            }
        }, 0, 1000); // Change quote every second

        Thread.sleep(6000); // run for 6 seconds
        timer.cancel(); // Stopping timer

        assertEquals(3,observable.countObservers());

        observable.removeObserver(lineChartObserver);
        observable.removeObserver(tableObserver);
        observable.removeObserver(threeDObserver);

        assertEquals(0,observable.countObservers());
    }


}
