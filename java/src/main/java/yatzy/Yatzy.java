package yatzy;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class Yatzy {

    private static final List<Integer> SMALL_STRAIGHT = List.of(1, 2, 3, 4, 5);
    private static final List<Integer> LARGE_STRAIGHT = List.of(2, 3, 4, 5, 6);

    private Yatzy() {
    }

    public static int chance(final Roll roll) {
        return roll.sum();
    }

    public static int yatzy(final Roll roll) {
        return (roll.countDistincts() == 1) ? 50 : 0;
    }

    private static int sumOf(final Roll roll, final int value) {
        return (int) (roll.countOccurrenceOf(value) * value);
    }

    public static int ones(final Roll roll) {
        return sumOf(roll, 1);
    }

    public static int twos(final Roll roll) {
        return sumOf(roll, 2);
    }

    public static int threes(final Roll roll) {
        return sumOf(roll, 3);
    }

    public static int fours(final Roll roll) {
        return sumOf(roll, 4);
    }

    public static int fives(final Roll roll) {
        return sumOf(roll, 5);
    }

    public static int sixes(final Roll roll) {
        return sumOf(roll, 6);
    }

    public static int pair(final Roll roll) {
        final var map = roll.getMapOccurencesByDice();
        map.values().removeIf(value -> value < 2);
        if (map.isEmpty()) {
            return 0;
        }

        final int biggestPair = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

        return biggestPair * 2;
    }

    public static int twoPairs(final Roll roll) {
        final var map = roll.getMapOccurencesByDice();
        map.values().removeIf(value -> value < 2);
        if (map.size() < 2) {
            return 0;
        }
        return map.keySet().stream().mapToInt(key -> key * 2).sum();
    }

    public static int threeOfAKind(final Roll roll) {
        final var map = roll.getMapOccurencesByDice();
        map.values().removeIf(value -> value < 3);

        return map.keySet().stream().findFirst().orElse(0) * 3;
    }

    public static int fourOfAKind(final Roll roll) {
        final var map = roll.getMapOccurencesByDice();
        map.values().removeIf(value -> value < 4);

        return map.keySet().stream().findFirst().orElse(0) * 4;
    }

    public static int smallStraight(final Roll roll) {
        return roll.containsAll(SMALL_STRAIGHT) ? 15 : 0;
    }

    public static int largeStraight(final Roll roll) {
        return roll.containsAll(LARGE_STRAIGHT) ? 20 : 0;
    }

    public static int fullHouse(final Roll roll) {

        if (roll.countDistincts() != 2) {
            return 0;
        }

        final var map = roll.getMapOccurencesByDice();

        if (map.containsValue(1)) {
            return 0;
        }

        return roll.sum();
    }
}
