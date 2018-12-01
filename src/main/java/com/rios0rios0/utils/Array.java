package com.rios0rios0.utils;

import java.util.OptionalInt;
import java.util.Random;

public class Array {

    public static int[] generateArray(int size) {
        int[] response = new int[size];
        Random random = new Random();
        for (int index = 0; index < size; index++) {
            OptionalInt num = random.ints(0, (size * 10)).findFirst();
            if (num.isPresent()) {
                response[index] = num.getAsInt();
            }
        }
        return response;
    }

    public static void printArray(int array[]) {
        int total = array.length;
        for (int index = 0; index < total; index++)
            System.out.print(array[index] + " ");
        System.out.println();
    }
}