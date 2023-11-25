package com.statestreet.exercises;

import java.util.stream.IntStream;

public class DivisibilityChecker {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 20)
            .mapToObj(DivisibilityChecker::getDivisibilityOutput)
            .forEach(System.out::println);
    }

    public static String getDivisibilityOutput(int number) {
        if (number % 3 == 0 && number % 5 == 0) return "C";
        if (number % 3 == 0) return "A";
        if (number % 5 == 0) return "B";
        return String.valueOf(number);
    }
}
