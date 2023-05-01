package edu.umb.cs680.hw10;

import java.util.List;

public class Cosine implements DistanceMetric {

    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        double dotProduct = 0.0;
        double magnitudeofP1 = 0.0;
        double magnitudeofP2 = 0.0;

        // calculating dot product
        for (int i = 0; i < p1.size(); i++) {
            dotProduct += p1.get(i) * p2.get(i);
        }

        // Calculate the magnitude of p1
        for (double value : p1) {
            magnitudeofP1 += Math.pow(value, 2);
        }
        magnitudeofP1 = Math.sqrt(magnitudeofP1);

        // Calculate the magnitude of p2
        for (double value : p2) {
            magnitudeofP2 += Math.pow(value, 2);
        }
        magnitudeofP2 = Math.sqrt(magnitudeofP2);

        // Calculate the cosine distance
        double cosineDistance = dotProduct / (magnitudeofP1 * magnitudeofP2);

        return cosineDistance;
    }

}



