package aoc;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day01Test {

    @Test
    public void givenSameNumbers_returnZero() {
        List<String> input = List.of("1   1");
        assertThat(new Day01().part1(input)).isEqualTo("0");
    }

    @Test
    public void givenDifferentNumbers_returnDistance() {
        List<String> input = List.of("1   2");
        assertThat(new Day01().part1(input)).isEqualTo("1");
    }

    @Test
    public void givenMultipleNumbers_returnDistance() {
        List<String> input = List.of("1   2", "3   4");
        assertThat(new Day01().part1(input)).isEqualTo("2");
    }

    @Test
    public void givenMultipleNumbers_returnDistanceAfterOrderingEachListFromSmallestToLargest() {
        List<String> input = List.of("3   4", "4   3", "2   5", "1   3", "3   9", "3   3");
        assertThat(new Day01().part1(input)).isEqualTo("11");
    }

    @Test
    public void givenListOfNumbers_part2ReturnsSimilarityScore()  {
        List<String> input = List.of("3   4", "4   3", "2   5", "1   3", "3   9", "3   3");
        assertThat(new Day01().part2(input)).isEqualTo("31");

    }
}
