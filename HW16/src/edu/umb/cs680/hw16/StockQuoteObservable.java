package edu.umb.cs680.hw16;

import java.util.HashMap;
import java.util.Map;

public class StockQuoteObservable extends Observable {

    private Map<String, Double> tandqMap;

    public StockQuoteObservable() {
        tandqMap = new HashMap<>();
    }

    public void changeQuote(String t, double q){
        tandqMap.put(t,q);
        notifyObservers(new StockEvent(t,q));
    }

    public Map<String, Double> getTickerQuoteMap() {
        return tandqMap;
    }
}
