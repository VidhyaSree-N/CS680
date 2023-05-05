package edu.umb.cs680.hw13;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
         Car car1, car2, car3, car4,car5;
         ArrayList<Car> cars;
        car1 = new Car("Toyota", "Camry", 30000, 2015, 20000);
        car2 = new Car("Honda", "Civic", 50000, 2016, 18000);
        car3 = new Car("Ford", "Fiesta", 20000, 2016, 15000);
        car4 = new Car("Chevrolet", "Malibu", 40000, 2014, 25000);
        car5 = new Car("Audi", "Senta", 35000, 2018, 22000);
        cars = new ArrayList<Car>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);


        Collections.sort(cars, (Car o1, Car o2)-> (o1.getMileage() - o2.getMileage()));
        System.out.println("least Milage:" + cars.get(0).getMileage());

        Collections.sort(cars, (Car o1, Car o2)-> (o1.getYear() - o2.getYear()));
        System.out.println("least Year:" + cars.get(0).getYear());

        Collections.sort(cars, (Car o1, Car o2)-> (int) (o1.getPrice() - o2.getPrice()));
        System.out.println("Cheap price:" + cars.get(0).getPrice());

        Collections.sort(cars, (Car o1, Car o2)-> (o1.getDominationCount() - o2.getDominationCount()));
        System.out.println("Best Car:" + cars.get(0).getMake());

    }
}
