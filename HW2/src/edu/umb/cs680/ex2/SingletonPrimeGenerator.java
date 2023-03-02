package edu.umb.cs680.ex2;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class SingletonPrimeGenerator {

    private static SingletonPrimeGenerator instance = null;

    private long from, to;
    private LinkedList<Long> primes = new LinkedList<Long>();

    private SingletonPrimeGenerator(long from, long to){
        if(from >= 1 && to > from){
            this.from = from;
            this.to = to;
        }else{
            throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
        }
    }

    public static SingletonPrimeGenerator getInstance(long from, long to){
        if(instance == null){
            instance = new SingletonPrimeGenerator(from, to);
        }
        return instance;
    }

    public LinkedList<Long> getPrimes(){ return primes; };

    private boolean isEven(long n){
        if(n%2 == 0){ return true; }
        else{ return false; }
    }

    private boolean isPrime(long n){
        // 1 or lower numbers are not prime.
        if(n <= 1){ return false; }
        // Even numbers are not prime, except for 2.
        if( n > 2 && isEven(n) ){ return false; }
        long i;
        // Find a number "i" that can divide "n"
        for (i = (long) Math.sqrt(n); n%i != 0 && i >= 1; i--){}
        // If such a number "i" is found, n is not prime. Otherwise, n is prime.
        if (i == 1){ return true; }
        else{ return false; }
    }

    public void generatePrimes(){
        for (long n = from; n <= to; n++) {
            if( isPrime(n) ){ primes.add(n); }
        }
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter the from(starting) value: ");
//        long from = in.nextLong();
//        System.out.print("Enter the to(ending) value: ");
//        long to = in.nextLong();
//        in.close();
//        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(from, to);

        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(2, 100);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        Iterator<Long> it = primes.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
        System.out.println("\n" + gen.getPrimes().size() + " primes are found.");
    }
}
