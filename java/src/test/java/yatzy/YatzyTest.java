package yatzy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class YatzyTest {

    private static Stream<Arguments> provideArgsForTestChance() {
        return Stream.of(
                Arguments.of(new Roll(1, 1, 3, 3, 6), 14),
                Arguments.of(new Roll(4, 5, 5, 6, 1), 21),
                Arguments.of(new Roll(1, 2, 3, 4, 5), 15));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestChance")
    void testChance(final Roll roll, final int expected) {

        final var score = Yatzy.chance(roll);

        assertThat(score).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgsForTestYatzy() {
        return Stream.of(
                Arguments.of(new Roll(1, 1, 1, 1, 1), 50),
                Arguments.of(new Roll(1, 1, 1, 1, 5), 0));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestYatzy")
    void testYatzy(final Roll roll, final int expected) {

        final var score = Yatzy.yatzy(roll);

        assertThat(score).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgsForTestOnes() {
        return Stream.of(
                Arguments.of(new Roll(1, 2, 3, 4, 5), 1),
                Arguments.of(new Roll(3, 2, 3, 4, 5), 0),
                Arguments.of(new Roll(1, 2, 1, 1, 1), 4));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestOnes")
    void testOnes(final Roll roll, final int expected) {

        final var score = Yatzy.ones(roll);

        assertThat(score).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgsForTestTwos() {
        return Stream.of(
                Arguments.of(new Roll(1, 2, 2, 2, 5), 6),
                Arguments.of(new Roll(1, 2, 3, 4, 5), 2),
                Arguments.of(new Roll(1, 3, 3, 4, 5), 0));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestTwos")
    void testTwos(final Roll roll, final int expected) {

        final var score = Yatzy.twos(roll);

        assertThat(score).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgsForTestThrees() {
        return Stream.of(
                Arguments.of(new Roll(1, 2, 3, 4, 5), 3),
                Arguments.of(new Roll(1, 2, 2, 4, 5), 0),
                Arguments.of(new Roll(1, 3, 3, 3, 5), 9));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestThrees")
    void testThrees(final Roll roll, final int expected) {

        final var score = Yatzy.threes(roll);

        assertThat(score).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgsForTestFours() {
        return Stream.of(
                Arguments.of(new Roll(1, 2, 4, 4, 5), 8),
                Arguments.of(new Roll(1, 2, 3, 2, 5), 0),
                Arguments.of(new Roll(1, 4, 4, 4, 4), 16));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestFours")
    void testFours(final Roll roll, final int expected) {

        final var score = Yatzy.fours(roll);

        assertThat(score).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgsForTestFives() {
        return Stream.of(
                Arguments.of(new Roll(1, 2, 5, 5, 5), 15),
                Arguments.of(new Roll(1, 2, 3, 4, 5), 5),
                Arguments.of(new Roll(1, 2, 3, 4, 2), 0));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestFives")
    void testFives(final Roll roll, final int expected) {

        final var score = Yatzy.fives(roll);

        assertThat(score).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgsForTestSixes() {
        return Stream.of(
                Arguments.of(new Roll(1, 2, 3, 4, 6), 6),
                Arguments.of(new Roll(1, 2, 6, 6, 5), 12),
                Arguments.of(new Roll(1, 2, 3, 4, 5), 0));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestSixes")
    void testSixes(final Roll roll, final int expected) {

        final var score = Yatzy.sixes(roll);

        assertThat(score).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgsForTestPair() {
        return Stream.of(
                Arguments.of(new Roll(1, 2, 3, 4, 5), 0),
                Arguments.of(new Roll(3, 3, 3, 4, 4), 6),
                Arguments.of(new Roll(1, 1, 6, 2, 6), 2),
                Arguments.of(new Roll(3, 3, 3, 4, 1), 6),
                Arguments.of(new Roll(3, 3, 3, 3, 1), 6));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestPair")
    void testPair(final Roll roll, final int expected) {

        final var score = Yatzy.pair(roll);

        assertThat(score).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgsForTestTwoPairs() {
        return Stream.of(
                Arguments.of(new Roll(1, 1, 2, 3, 3), 8),
                Arguments.of(new Roll(1, 1, 2, 3, 4), 0),
                Arguments.of(new Roll(1, 1, 2, 2, 2), 6),
                Arguments.of(new Roll(3, 3, 3, 3, 1), 0));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestTwoPairs")
    void testTwoPairs(final Roll roll, final int expected) {

        final var score = Yatzy.twoPairs(roll);

        assertThat(score).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgsForTestThreeOfAKind() {
        return Stream.of(
                Arguments.of(new Roll(3, 3, 3, 4, 5), 9),
                Arguments.of(new Roll(3, 3, 4, 5, 6), 0),
                Arguments.of(new Roll(3, 3, 3, 3, 1), 9));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestThreeOfAKind")
    void testThreeOfAKind(final Roll roll, final int expected) {

        final var score = Yatzy.threeOfAKind(roll);

        assertThat(score).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgsForTestFourOfAKind() {
        return Stream.of(
                Arguments.of(new Roll(2, 2, 2, 2, 5), 8),
                Arguments.of(new Roll(2, 2, 2, 5, 5), 0),
                Arguments.of(new Roll(2, 2, 2, 2, 2), 8));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestFourOfAKind")
    void testFourOfAKind(final Roll roll, final int expected) {

        final var score = Yatzy.fourOfAKind(roll);

        assertThat(score).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgsForTestSmallStraight() {
        return Stream.of(
                Arguments.of(new Roll(1, 2, 3, 4, 5), 15),
                Arguments.of(new Roll(1, 2, 3, 4, 3), 0),
                Arguments.of(new Roll(2, 3, 4, 5, 6), 0));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestSmallStraight")
    void testSmallStraight(final Roll roll, final int expected) {

        final var score = Yatzy.smallStraight(roll);

        assertThat(score).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgsForTestLargeStraight() {
        return Stream.of(
                Arguments.of(new Roll(1, 2, 3, 4, 5), 0),
                Arguments.of(new Roll(1, 2, 3, 4, 3), 0),
                Arguments.of(new Roll(2, 3, 4, 5, 6), 20));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestLargeStraight")
    void testLargeStraight(final Roll roll, final int expected) {

        final var score = Yatzy.largeStraight(roll);

        assertThat(score).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgsForTestFullHouse() {
        return Stream.of(
                Arguments.of(new Roll(1, 1, 2, 2, 2), 8),
                Arguments.of(new Roll(2, 2, 3, 3, 4), 0),
                Arguments.of(new Roll(4, 4, 4, 4, 4), 0),
                Arguments.of(new Roll(4, 4, 4, 4, 2), 0));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestFullHouse")
    void testFullHouse(final Roll roll, final int expected) {

        final var score = Yatzy.fullHouse(roll);

        assertThat(score).isEqualTo(expected);
    }

}
