package edu.umb.cs680.hw10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> p1;
        List<Double> p2;

        p1 = Arrays.asList(2.0,3.0);
        p2 = Arrays.asList(5.0,7.0);

        List<List<Double>> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);

        System.out.println("Euclidean distance and matrix");
        double euclideanDistance = Distance.get(p1, p2, new Euclidean());
        System.out.println(euclideanDistance);
        List<List<Double>> euclideanMatrix = Distance.matrix(points, new Euclidean());
        System.out.println(euclideanMatrix);


        System.out.println("Manhattan distance and matrix");
        double manhattanDistance = Distance.get(p1, p2, new Manhattan());
        System.out.println(manhattanDistance);
        List<List<Double>> manhattanMatrix = Distance.matrix(points, new Manhattan());
        System.out.println(manhattanMatrix);


        System.out.println("Cosine distance and matrix");
        double cosineDistance = Distance.get(p1,p2,new Cosine());
        System.out.println(cosineDistance);
        List<List<Double>> cosineMatrix = Distance.matrix(points,new Cosine());
        System.out.println(cosineMatrix);

    }

}