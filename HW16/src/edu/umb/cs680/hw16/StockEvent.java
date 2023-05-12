package edu.umb.cs680.hw16;

public class StockEvent {

    private String ticker;
    private double quote;

    public StockEvent(String t, double q) {
        this.quote=q;
        this.ticker=t;
    }

    public String getTicker() {
        return ticker;
    }
    public double getQuote() {
        return quote;
    }
}
