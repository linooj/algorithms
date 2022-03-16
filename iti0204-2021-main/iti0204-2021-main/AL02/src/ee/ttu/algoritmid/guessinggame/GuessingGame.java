package ee.ttu.algoritmid.guessinggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GuessingGame {

    Oracle oracle;

    public GuessingGame(Oracle oracle) {
        this.oracle = oracle;
    }

    /**
     * tahaks pushida
     * @param fruitArray - All the possible fruits.
     * @return the name of the fruit.
     */
    public String play(Fruit[] fruitArray) {
        List<Fruit> sorted = Arrays.stream(fruitArray).sorted(Comparator.comparingInt(Fruit::getWeight)).collect(Collectors.toList());

        int elements = sorted.size();
        Fruit median = sorted.get(0);
        if (elements != 1) {
            median = sorted.get(elements / 2 );
        }
        String answer = oracle.isIt(median);
        if (!answer.equals("correct!")) {
            if (answer.equals("heavier")) {
                List<Fruit> rightSide = sorted.subList(elements / 2 + 1, elements);
                return play(rightSide.toArray(new Fruit[0]));
            } else {
                List<Fruit> leftSide = sorted.subList(0, elements / 2);
                return play(leftSide.toArray(new Fruit[0]));
            }

        }
        return median.getName();
    }
}
