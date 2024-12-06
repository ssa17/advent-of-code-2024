package aoc;

import java.util.List;

import static java.lang.Integer.parseInt;

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
            String[] reportLevel = report.split(" ");
            boolean isSafe = true;
            boolean isIncreasing = true;

            int previousLevel = -1;
            for (int i = 0; i < reportLevel.length; i++) {
                int currentLevel = parseInt(reportLevel[i]);

                if (previousLevel == -1) {
                    previousLevel = currentLevel;
                    isIncreasing = currentLevel < parseInt(reportLevel[i + 1]);
                    continue;
                }

                if (isIncreasing && previousLevel > currentLevel) {
                    isSafe = false;
                    break;
                } else if (!isIncreasing && previousLevel < currentLevel) {
                    isSafe = false;
                    break;
                }

                if (previousLevel == currentLevel) {
                    isSafe = false;
                    break;
                }

                int diff = Math.abs(currentLevel - previousLevel);

                if (diff > 3) {
                    isSafe = false;
                    break;
                }
                previousLevel = currentLevel;
            }
            if (isSafe) {
                safeReports++;
            }
        }

        return String.valueOf(safeReports);
    }

    @Override
    public String part2(List<String> input) {
        return null;
    }

}
