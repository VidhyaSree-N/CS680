package edu.umb.cs680.hw13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest{

    private Car car1, car2, car3, car4,car5;
    private ArrayList<Car> cars;

    @BeforeEach
    public void init() {
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
    }

    @Test
    public void SortByMileage() {
        Collections.sort(cars, (Car o1, Car o2)-> (o1.getMileage() - o2.getMileage()));
        assertEquals(car3, cars.get(0));
        assertEquals(car1, cars.get(1));
        assertEquals(car5, cars.get(2));
        assertEquals(car4, cars.get(3));
        assertEquals(car2, cars.get(4));
    }

    @Test
    public void SortByPrice() {
        Collections.sort(cars, (Car o1, Car o2)-> (int) (o1.getPrice() - o2.getPrice()));
        assertEquals(car3, cars.get(0));
        assertEquals(car2, cars.get(1));
        assertEquals(car1, cars.get(2));
        assertEquals(car5, cars.get(3));
        assertEquals(car4, cars.get(4));
    }

    @Test
    public void SortByYear() {
        Collections.sort(cars, (Car o1, Car o2)-> (o1.getYear() - o2.getYear()));
        assertEquals(car4, cars.get(0));
        assertEquals(car1, cars.get(1));
        assertEquals(car2, cars.get(2));
        assertEquals(car3, cars.get(3));
        assertEquals(car5, cars.get(4));
    }

    @Test
    public void SortByPareto() {
        for (Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars, (Car o1, Car o2)-> (o1.getDominationCount() - o2.getDominationCount()));
        assertEquals(car2, cars.get(0));
        assertEquals(car4, cars.get(1));
        assertEquals(car1, cars.get(2));
        assertEquals(car5, cars.get(3));
        assertEquals(car3, cars.get(4));
    }

    @Test
    public void SortByMileageTest() {
        Collections.sort(cars,Comparator.comparing( Car::getMileage) );
        assertEquals(car3, cars.get(0));
        assertEquals(car1, cars.get(1));
        assertEquals(car5, cars.get(2));
        assertEquals(car4, cars.get(3));
        assertEquals(car2, cars.get(4));
    }

    @Test
    public void SortByPriceTest() {
        Collections.sort(cars,Comparator.comparing( Car::getPrice ) );
        assertEquals(car3, cars.get(0));
        assertEquals(car2, cars.get(1));
        assertEquals(car1, cars.get(2));
        assertEquals(car5, cars.get(3));
        assertEquals(car4, cars.get(4));
    }

    @Test
    public void SortByYearTest() {
        Collections.sort(cars,Comparator.comparing( Car::getYear ) );
        assertEquals(car4, cars.get(0));
        assertEquals(car1, cars.get(1));
        assertEquals(car2, cars.get(2));
        assertEquals(car3, cars.get(3));
        assertEquals(car5, cars.get(4));
    }

    @Test
    public void SortByParetoTest() {
        for (Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars,Comparator.comparing( Car::getDominationCount ) );
        assertEquals(car2, cars.get(0));
        assertEquals(car4, cars.get(1));
        assertEquals(car1, cars.get(2));
        assertEquals(car5, cars.get(3));
        assertEquals(car3, cars.get(4));
    }

    @Test
    public void ReverseSortByMileageTest() {
        //Using .reversed method
        Collections.sort(cars, Comparator.comparing(Car::getMileage).reversed());
        assertEquals(car3, cars.get(4));
        assertEquals(car1, cars.get(3));
        assertEquals(car5, cars.get(2));
        assertEquals(car4, cars.get(1));
        assertEquals(car2, cars.get(0));
    }

    @Test
    public void ReverseSortByPriceTest() {
        //Using .reversed method
        Collections.sort(cars, Comparator.comparing(Car::getPrice).reversed());
        assertEquals(car3, cars.get(4));
        assertEquals(car2, cars.get(3));
        assertEquals(car1, cars.get(2));
        assertEquals(car5, cars.get(1));
        assertEquals(car4, cars.get(0));
    }

    @Test
    public void ReverseSortByYearTest() {
        //Using .reverseorder method
        Collections.sort(cars,Comparator.comparing(Car::getYear,Comparator.reverseOrder()) );
        assertEquals(car4, cars.get(4));
        assertEquals(car1, cars.get(3));
        assertEquals(car3, cars.get(2));
        assertEquals(car2, cars.get(1));
        assertEquals(car5, cars.get(0));
    }

    @Test
    public void ReverseSortByParetoTest() {
        //Using .reverseorder method
        for (Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars,Comparator.comparing(Car::getDominationCount, Comparator.reverseOrder()) );
        assertEquals(car4, cars.get(4));
        assertEquals(car2, cars.get(3));
        assertEquals(car5, cars.get(2));
        assertEquals(car1, cars.get(1));
        assertEquals(car3, cars.get(0));
    }
}

