package com.rios0rios0.ordination;

/**
 * @author Felipe Rios (rios0rios0)
 * <p>
 * Concept:
 * <p>
 */
public class InsertionSort extends DefaultSort {

    public int[] sort(int array[]) {
        setInstructions(0);
        inc(1);
        for (int firstIndex = 1; firstIndex < array.length; firstIndex++) {
            int value = array[firstIndex];
            int secondIndex = firstIndex - 1;
            inc(3);
            while ((secondIndex >= 0) && (array[secondIndex] > value)) {
                array[secondIndex + 1] = array[secondIndex];
                secondIndex--;
                inc(4);
            }
            array[secondIndex + 1] = value;
            //array[0] = value;
            inc(1);
        }
        return array;
    }
}