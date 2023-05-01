package edu.umb.cs680.hw10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceTest {
    private List<Car> cars;
    private List<List<Double>> normalizedCars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<Car>();
        cars.add(new Car("Toyota", "Camry", 30000, 2020, 25000));
        cars.add(new Car("Honda", "Accord", 20000, 2021, 30000));
        cars.add(new Car("Lamborghini", "Fusion", 40000, 2019, 20000));
        cars.add(new Car("Audi", "Senta", 35000, 2018, 22000));
        cars.add(new Car("Chevrolet", "Malibu", 25000, 2022, 28000));

        //making values in the range of 0 and 1
        normalizedCars = new ArrayList<List<Double>>();
        for (Car car : cars) {
            List<Double> normalized = Arrays.asList(
                    (car.getMileage() - 20000.0) / 20000.0,
                    (car.getYear() - 2018.0) / 4.0,
                    (car.getPrice() - 20000.0) / 10000.0
            );
            normalizedCars.add(normalized);
        }
    }

    @Test
    void euclideanDistanceTest() {
        List<List<Double>> distanceMatrix = Distance.matrix(normalizedCars, new Euclidean());

        for (int i = 0; i < distanceMatrix.size(); i++) {
            for (int j = 0; j < distanceMatrix.size(); j++) {
                assertEquals(distanceMatrix.get(i).get(j), distanceMatrix.get(j).get(i));
            }
        }

        for (int i = 0; i < distanceMatrix.size(); i++) {
            assertEquals(distanceMatrix.get(i).get(i), 0.0);
        }
    }

    @Test
    void manhattanDistanceTest() {
        List<List<Double>> distanceMatrix = Distance.matrix(normalizedCars, new Manhattan());

        for (int i = 0; i < distanceMatrix.size(); i++) {
            for (int j = 0; j < distanceMatrix.size(); j++) {
                assertEquals(distanceMatrix.get(i).get(j), distanceMatrix.get(j).get(i));
            }
        }

        for (int i = 0; i < distanceMatrix.size(); i++) {
            assertEquals(distanceMatrix.get(i).get(i), 0.0);
        }
    }

    @Test
    void cosineDistanceTest() {
        List<List<Double>> distanceMatrix = Distance.matrix(normalizedCars, new Cosine());
        for (int i = 0; i < distanceMatrix.size(); i++) {
            for (int j = 0; j < distanceMatrix.size(); j++) {
                assertEquals(distanceMatrix.get(i).get(j), distanceMatrix.get(j).get(i));
            }
        }
    }

}

