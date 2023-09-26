package yatzy;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Roll {

    List<Integer> diceList;

    public Roll(final int dice1, final int dice2, final int dice3, final int dice4, final int dice5) {
        diceList = List.of(dice1, dice2, dice3, dice4, dice5);
    }

    public int sum() {
        return diceList.stream().mapToInt(Integer::intValue).sum();
    }

    public Map<Integer, Integer> getMapCountByValue() {

        return diceList.stream().collect(Collectors.toMap(Function.identity(), x -> 1, Integer::sum));
    }

    public long countOccurrenceOf(final int value) {

        return diceList.stream().filter(dice -> dice == value).count();
    }

    public long countDistincts() {
        return diceList.stream().distinct().count();
    }

    public boolean containsAll(final List<Integer> list) {
        return diceList.containsAll(list);
    }

}
