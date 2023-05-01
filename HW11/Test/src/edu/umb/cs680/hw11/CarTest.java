package edu.umb.cs680.hw11;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

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
    public void verifyMileageComparator() {
        Collections.sort(cars, new MileageComparator());
        assertEquals(car3, cars.get(0));
        assertEquals(car1, cars.get(1));
        assertEquals(car5, cars.get(2));
        assertEquals(car4, cars.get(3));
        assertEquals(car2, cars.get(4));
    }

    @Test
    public void verifyYearComparator() {
        Collections.sort(cars, new YearComparator());
        assertEquals(car4, cars.get(0));
        assertEquals(car1, cars.get(1));
        assertEquals(car2, cars.get(2));
        assertEquals(car3, cars.get(3));
        assertEquals(car5, cars.get(4));
    }

    @Test
    public void verifyPriceComparator() {
        Collections.sort(cars, new PriceComparator());
        assertEquals(car3, cars.get(0));
        assertEquals(car2, cars.get(1));
        assertEquals(car1, cars.get(2));
        assertEquals(car5, cars.get(3));
        assertEquals(car4, cars.get(4));
    }

    @Test
    public void verifyParetoComparator() {
        for (Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars, new ParetoComparator());
        assertEquals(car2, cars.get(0));
        assertEquals(car4, cars.get(1));
        assertEquals(car1, cars.get(2));
        assertEquals(car5, cars.get(3));
        assertEquals(car3, cars.get(4));
    }

}

