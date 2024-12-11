package aoc;

import java.util.ArrayList;
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
            if (isSafeReport(turnReportIntoListOfLevels(report))) {
                safeReports++;
            }
        }
        return safeReports + "";
    }

    @Override
    public String part2(List<String> input) {
        int safeReports = 0;

        for (String report : input) {
            if (isSafeReport(turnReportIntoListOfLevels(report))) {
                safeReports++;
            } else if (isSafeReportAfterTolerating(turnReportIntoListOfLevels(report))) {
                safeReports++;
            }
        }
        return safeReports + "";
    }

    private boolean isSafeReport(List<Integer> report) {
        if (isNotIncreasing(report) && isNotDecreasing(report)) {
            return false;
        }

        for (int i = 0; i < report.size() - 1; i++) {
            if (levelsEqual(report.get(i), report.get(i + 1)) || levelNotWithinRange(report.get(i), report.get(i + 1))) {
                return false;
            }
        }
        return true;
    }

    private boolean isSafeReportAfterTolerating(List<Integer> report) {
        for (int i = 0; i < report.size(); i++) {
            List<Integer> reportLevelsCopy = new ArrayList<>(report);
            reportLevelsCopy.remove(i);
            if (isSafeReport(reportLevelsCopy)) {
                return true;
            }
        }
        return false;
    }

    private List<Integer> turnReportIntoListOfLevels(String report) {
        return Stream.of(report.split(" ")).map(Integer::parseInt).toList();
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
