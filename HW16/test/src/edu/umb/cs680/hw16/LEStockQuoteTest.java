package edu.umb.cs680.hw16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LEStockQuoteTest {
    private StockQuoteObservable observable;
    private Observer<StockEvent> lineChartObserver;
    private Observer<StockEvent> tableObserver;
    private Observer<StockEvent> threeDObserver;

    @BeforeEach
    public void setUp() {
        observable = new StockQuoteObservable();
        //Setting up lamda experssions for each type of observers
        lineChartObserver = (sender, event) -> {
            String ticker = event.getTicker();
            double quote = event.getQuote();
            System.out.println("LineChartObserver : ticker = " + ticker + " and quote = " + quote);
        };

        tableObserver = (sender, event) -> {
            String ticker = event.getTicker();
            double quote = event.getQuote();
            System.out.println("tableObserver : ticker = " + ticker + " and quote = " + quote);
        };

        threeDObserver = (sender, event) -> {
            String ticker = event.getTicker();
            double quote = event.getQuote();
            System.out.println("threeDObserver : ticker = " + ticker + " and quote = " + quote);
        };
    }

    @Test
    public void testNotifyObserver() {

        observable.addObserver(lineChartObserver);

        Map<String,Double> expected = new HashMap<>();
        expected.put("LamdaEx", 100.00);

        observable.changeQuote("LamdaEx", 100.00);
        assertEquals(1,observable.countObservers());
        assertEquals(lineChartObserver,observable.getObservers().get(0));
        assertEquals(expected,observable.getTickerQuoteMap());
        observable.removeObserver(lineChartObserver);

    }

    @Test
    void testMultipleObserversUpdate() {
        observable.addObserver(lineChartObserver);
        observable.addObserver(tableObserver);
        observable.addObserver(threeDObserver);
        Map<String,Double> expected = new HashMap<>();
        expected.put("AAPLgdfj", 100.00);
        expected.put("LamdaEx", 18760.00);

        observable.changeQuote("AAPLgdfj", 100.00);
        observable.changeQuote("LamdaEx", 18760.00);

        assertEquals(3,observable.countObservers());
        assertEquals(lineChartObserver,observable.getObservers().get(0));
        assertEquals(tableObserver,observable.getObservers().get(1));
        assertEquals(threeDObserver,observable.getObservers().get(2));
        assertEquals(expected,observable.getTickerQuoteMap());
        observable.removeObserver(tableObserver);
        observable.removeObserver(threeDObserver);
        observable.removeObserver(lineChartObserver);

    }


    @Test
    public void testClearObservers() {
        observable.addObserver(tableObserver);
        observable.addObserver(lineChartObserver);

        observable.clearObservers();

        assertEquals(0,observable.countObservers());

    }

    @Test
    void testRemoveObserver() {
        observable.addObserver(lineChartObserver);
        observable.addObserver(tableObserver);
        observable.changeQuote("LamdaEx", 100.00);
        assertEquals(lineChartObserver,observable.getObservers().get(0));
        assertEquals(tableObserver,observable.getObservers().get(1));
        observable.removeObserver(lineChartObserver);
        assertEquals(1,observable.countObservers());
        assertEquals(tableObserver,observable.getObservers().get(0));
        observable.removeObserver(tableObserver);

    }

    @Test
    void randomQuoteChangeNotification() throws InterruptedException {
        observable.addObserver(tableObserver);
        observable.addObserver(threeDObserver);
        observable.addObserver(lineChartObserver);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String ticker = "LamdaEx";
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
