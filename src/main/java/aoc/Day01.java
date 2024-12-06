package aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class Day01 extends Day {

    static {
        currentDay = new Day01();
    }

    public static void main(String[] args) {
        Day.main(args);
    }

    protected Day01() {
        super(1);
    }

    @Override
    public String part1(List<String> input) {
        List<Integer> firstNumbers = new ArrayList<>();
        List<Integer> secondNumbers = new ArrayList<>();

        for (String line : input) {
            String[] numbers = line.split("\\s+");
            firstNumbers.add(Integer.parseInt(numbers[0]));
            secondNumbers.add(Integer.parseInt(numbers[1]));
        }

        int[] sortedFirstArray = firstNumbers.stream().mapToInt(i -> i).sorted().toArray();
        int[] sortedSecondArray = secondNumbers.stream().mapToInt(i -> i).sorted().toArray();

        int totalDifference = IntStream.range(0, sortedFirstArray.length)
            .map(i -> Math.abs(sortedFirstArray[i] - sortedSecondArray[i]))
            .sum();

        return String.valueOf(totalDifference);
    }



    @Override
    public String part2(List<String> input) {

        int total = 0;
        List<Integer> firstNumbers = new ArrayList<>();
        List<Integer> secondNumbers = new ArrayList<>();

        for (String line : input) {
            String[] numbers = line.split("\\s+");
            firstNumbers.add(Integer.parseInt(numbers[0]));
            secondNumbers.add(Integer.parseInt(numbers[1]));
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number : secondNumbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        for (int number : firstNumbers) {
            if (map.containsKey(number)) {
                total += number * map.get(number);
            }
        }

        return total + "";
    }

}
