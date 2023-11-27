package com.statestreet.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayHandler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type anything: ");
        String input = scanner.nextLine();

        String[] originalArray = breakIntoArray(input);
        System.out.println("Original Array: " + Arrays.toString(originalArray));

        String[] sortedArray = sortArray(originalArray);
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));

        String finalString = arrayToString(sortedArray);
        System.out.println("Final String: " + finalString);
    }

    public static String[] breakIntoArray(String input) {
        return input.split("");
    }

    public static String[] sortArray(String[] array) {
        Arrays.sort(array);
        return array;
    }

    public static String arrayToString(String[] array) {
        return String.join("", array);
    }
}
