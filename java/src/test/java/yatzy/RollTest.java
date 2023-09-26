package yatzy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.List;

import org.junit.jupiter.api.Test;

class RollTest {

    private static final int SUM             = 14;
    private static final int COUNT_DISTINCS  = 4;
    private static final int OCCURENCES_OF_3 = 2;

    private final Roll roll = new Roll(1, 2, 3, 3, 5);

    @Test
    void testSum() {
        assertThat(roll.sum()).isEqualTo(SUM);
    }

    @Test
    void testGetMapCountByValue() {
        final var map = roll.getMapCountByValue();

        assertThat(map).contains(
                entry(1, 1),
                entry(2, 1),
                entry(3, 2),
                entry(5, 1));
    }

    @Test
    void testCountOccurrenceOf() {
        assertThat(roll.countOccurrenceOf(3)).isEqualTo(OCCURENCES_OF_3);
    }

    @Test
    void testCountDistincts() {
        assertThat(roll.countDistincts()).isEqualTo(COUNT_DISTINCS);
    }

    @Test
    void testContainsAll() {
        assertThat(roll.containsAll(List.of(2, 3))).isEqualTo(true);
    }

}
