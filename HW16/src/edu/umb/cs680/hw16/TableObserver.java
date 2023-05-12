package edu.umb.cs680.hw16;

public class TableObserver implements Observer<StockEvent>{
    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        String ticker = event.getTicker();
        double quote = event.getQuote();
        System.out.println("TableObserver : ticker = " + ticker + " and quote = "+ quote);
    }
}
