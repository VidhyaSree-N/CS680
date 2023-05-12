package edu.umb.cs680.hw16;

public class Main {
    public static void main(String[] args) {

    StockQuoteObservable stockQuote = new StockQuoteObservable();
    LineChartObserver lineChartObserver = new LineChartObserver();
    TableObserver tableObserver = new TableObserver();
    ThreeDObserver threeDObserver = new ThreeDObserver();

    System.out.println("Notifying 1 observer");
    stockQuote.addObserver(lineChartObserver);
    stockQuote.changeQuote("QWErtYU", 864.64);
    System.out.println("Notifying 2 observers");
    stockQuote.addObserver(tableObserver);
    stockQuote.changeQuote("ASDFghjKL", 5420.76);
    System.out.println("Notifying 3 observers");
    stockQuote.addObserver(threeDObserver);
    stockQuote.changeQuote("ZXCvbnM",567.98);

    stockQuote.removeObserver(lineChartObserver);
    stockQuote.removeObserver(threeDObserver);
    stockQuote.removeObserver(tableObserver);
}
}
