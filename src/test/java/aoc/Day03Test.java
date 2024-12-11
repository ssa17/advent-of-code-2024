package aoc;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day03Test {

    @Test
    public void givenSingleMul_returnResult() {
        List<String> input = List.of("mul(1,2)");

        assertThat(new Day03().part1(input)).isEqualTo("2");
    }

    @Test
    public void givenMultipleMul_returnResult() {
        List<String> input = List.of("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");

        assertThat(new Day03().part1(input)).isEqualTo("161");
    }

    @Test
    public void placeholderTest() {
        List<String> input = List.of("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))");

        assertThat(new Day03().part2(input)).isEqualTo("48");
    }

    @Test
    public void testCleanAndJoinString() {
        List<String> input = List.of("don't()do()don't()do()");

        assertThat(new Day03().cleanAndJoinString(input)).isEqualTo("");
    }

    @Test
    public void testCleanAndJoinStringAgain() {
        List<String> input = List.of("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))");

        assertThat(new Day03().cleanAndJoinString(input)).isEqualTo("xmul(2,4)&mul[3,7]!^?mul(8,5))");
    }

    @Test
    public void givenMultipleLines_returnCorrectlyCleanedString() {
        List<String> input = List.of("1don't()2do()3don't()", "4do()5");

        assertThat(new Day03().cleanAndJoinString(input)).isEqualTo("135");
    }
}
