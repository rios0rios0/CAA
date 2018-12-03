package com.rios0rios0.ordination;

/**
 * @author Felipe Rios (rios0rios0)
 * <p>
 * Concept:
 * <p>
 */
public class QuickSort extends DefaultSort {

    private int part(int[] array, int beginIndex, int endIndex) {
        int pivot = array[beginIndex];
        int bIndex = beginIndex + 1;
        int eIndex = endIndex;
        inc(2);
        while (bIndex <= eIndex) {
            if (array[bIndex] <= pivot) {
                bIndex++;
                inc(2);
            } else if (pivot < array[eIndex]) {
                eIndex--;
                inc(3);
            } else {
                int changed = array[bIndex];
                array[bIndex] = array[eIndex];
                array[eIndex] = changed;
                bIndex++;
                eIndex--;
                inc(5);
            }
        }
        array[beginIndex] = array[eIndex];
        array[eIndex] = pivot;
        inc(2);
        return eIndex;
    }

    //T(n) = T(n/2) + T(n/2) + n
    private int[] sort(int[] array, int begin, int end) {
        inc(1);
        if (begin < end) {
            int pivotIndex = part(array, begin, end);
            sort(array, begin, pivotIndex - 1);
            sort(array, pivotIndex + 1, end);
            return array;
        }
        return new int[]{};
    }

    public int[] sort(int[] array) {
        setInstructions(0);
        return sort(array, 0, (array.length - 1));
    }
}