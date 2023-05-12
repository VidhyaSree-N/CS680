package edu.umb.cs680.hw16;

public class StockQuoteObservable extends Observable {

    public void changeQuote(String t, double q){
        notifyObservers(new StockEvent(t,q));
    }
}
