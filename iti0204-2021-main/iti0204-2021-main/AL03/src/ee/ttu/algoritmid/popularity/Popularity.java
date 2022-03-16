package ee.ttu.algoritmid.popularity;

import java.util.*;

public class Popularity {

    int maxCoordinates;

    public Popularity(int maxCoordinates) {
        this.maxCoordinates = maxCoordinates;
    }

    Map<List<Integer>, Integer> points = new HashMap<>();
    Integer maxInteger = 0;
    /**
     * @param x, y - coordinates
     * adds a picture at the point with coordinates (x, y)
     */
    void addPoint(Integer x, Integer y) {
        List<Integer> point = List.of(x, y);

        if (points.containsKey(point)) {
            points.replace(point, points.get(point) + 1);
            if (points.get(point)> maxInteger) {
                maxInteger = points.get(point);
            }
        }
        points.putIfAbsent(point, 1);


    }

    /**
     * @param x, y - coordinates
     * @return the number of occurrennces of the point
     */
    int pointPopularity(Integer x,Integer y) {
        List<Integer> point = List.of(x, y);

        if (points.containsKey(point)) {
            return points.get(point);
        } return 0;
    }


    /**
     * @return the number of occurrennces of the most popular point
     */
    int maxPopularity() {

        return maxInteger;

    }

}
