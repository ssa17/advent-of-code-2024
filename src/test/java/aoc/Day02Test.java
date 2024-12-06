package aoc;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day02Test {

    @Test
    public void givenSafeReport_returnCountOfOne() {
        List<String> input = List.of("1 2 3 4 5");

        assertThat(new Day02().part1(input)).isEqualTo("1");
    }

    @Test
    public void givenReportWithLevelIncreasingMoreThan3_returnCountOfZero() {
        List<String> input = List.of("1 2 3 4 8");

        assertThat(new Day02().part1(input)).isEqualTo("0");
    }

    @Test
    public void givenReportWithLevelDecreasingMoreThan3_returnCountOfZero() {
        List<String> input = List.of("6 2 3 4 5");

        assertThat(new Day02().part1(input)).isEqualTo("0");
    }

    @Test
    public void givenReportWithSameLevels_returnCountOfZero() {
        List<String> input = List.of("1 1 1 1 1");

        assertThat(new Day02().part1(input)).isEqualTo("0");
    }

    @Test
    public void givenListOfReports_returnCountOfSafeReports() {
        List<String> input = List.of("7 6 4 2 1", "1 2 7 8 9", "9 7 6 2 1", "1 3 2 4 5", "8 6 4 4 1", "1 3 6 7 9");

        assertThat(new Day02().part1(input)).isEqualTo("2");
    }

}
