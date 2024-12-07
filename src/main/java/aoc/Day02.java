package aoc;

import java.util.List;
import java.util.stream.Stream;

public class Day02 extends Day {

    static {
        currentDay = new Day02();
    }

    public static void main(String[] args) {
        Day.main(args);
    }

    protected Day02() {
        super(2);
    }

    @Override
    public String part1(List<String> input) {
        int safeReports = 0;

        for (String report : input) {
            if (isSafeReport(report)) {
                safeReports++;
            }
        }
        return String.valueOf(safeReports);
    }

    @Override
    public String part2(List<String> input) {
        return null;
    }

    private boolean isSafeReport(String report) {
        List<Integer> reportLevels = Stream.of(report.split(" ")).map(Integer::parseInt).toList();

        if (isNotIncreasing(reportLevels) && isNotDecreasing(reportLevels)) {
            return false;
        }

        for (int i = 0; i < reportLevels.size() - 1; i++) {
            if (levelsEqual(reportLevels.get(i), reportLevels.get(i + 1)) || levelNotWithinRange(reportLevels.get(i), reportLevels.get(i + 1))) {
                return false;
            }
        }
        return true;
    }

    private boolean isNotIncreasing(List<Integer> report) {
        for (int i = 0; i < report.size() - 1; i++) {
                if (report.get(i) > report.get(i + 1)) {
                    return true;
                }
        }
        return false;
    }

    private boolean isNotDecreasing(List<Integer> report) {
        for (int i = 0; i < report.size() - 1; i++) {
            if (report.get(i) < report.get(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean levelsEqual(int a, int b) {
        return a == b;
    }

    private boolean levelNotWithinRange(int a, int b) {
        return Math.abs(a - b) > 3;
    }

}
