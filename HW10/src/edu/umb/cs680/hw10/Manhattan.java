package edu.umb.cs680.hw10;

import java.util.List;

public class Manhattan implements DistanceMetric{

    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        if (p1.size() != p2.size()) {
            throw new IllegalArgumentException("The two points must have the same number of dimensions.");
        }

        double manhattanDistance = 0;
        //Calculates the manhattan distance
        for(int i = 0 ; i<p1.size(); i++){
            manhattanDistance = manhattanDistance + Math.abs(p1.get(i) - p2.get(i));
        }

        return manhattanDistance;
    }
}
