package aoc;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 extends Day {

    static {
        currentDay = new Day03();
    }

    public static void main(String[] args) {
        Day.main(args);
    }

    protected Day03() {
        super(3);
    }

    @Override
    public String part1(List<String> input) {
        int total = 0;

        for (String line : input) {
            total += multiply(line);
        }

        return String.valueOf(total);
    }

    @Override
    public String part2(List<String> input) {
        return String.valueOf(multiply(cleanAndJoinString(input)));
    }

    private int multiply(String line) {
        Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        Matcher matcher = pattern.matcher(line);
        int sum = 0;

        while (matcher.find()) {
            int a = Integer.parseInt(matcher.group(1));
            int b = Integer.parseInt(matcher.group(2));
            sum += a * b;
        }

        return sum;
    }

    public String cleanAndJoinString(List<String> input) {
        StringBuilder sb = new StringBuilder();

        Pattern pattern = Pattern.compile("don't\\(\\).*?do\\(\\)");
        for (String string : input) {
            sb.append(string);
        }
        return pattern.matcher(sb).replaceAll("");
    }

}
