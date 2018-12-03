package com.rios0rios0;

import com.rios0rios0.ordination.HeapSort;
import com.rios0rios0.ordination.InsertionSort;
import com.rios0rios0.ordination.QuickSort;
import com.rios0rios0.ordination.RadixSort;
import com.rios0rios0.utils.Console;

/**
 * @author Felipe Rios (rios0rios0)
 */
public class Main {

    public static void main(String[] args) {
        Console.showMsgSuccess("Starting the demonstrations...");
        Console.showMsgInfo("HEAP SORT");
        new HeapSort().demo(new int[]{20, 15, 10, 11, 9, 8, 7, 4, 5, 3}, new int[]{3, 4, 5, 7, 8, 9, 10, 11, 15, 20});
        Console.showMsgInfo("INSERTION SORT");
        new InsertionSort().demo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        Console.showMsgInfo("QUICK SORT");
        new QuickSort().demo(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        Console.showMsgInfo("RADIX SORT");
        new RadixSort().demo(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        Console.showMsgSuccess("Finish...");
        //
        Console.showMsgSuccess("Starting analysis...");
        Console.showMsgInfo("HEAP SORT");
        new HeapSort().analysis();
        Console.showMsgInfo("INSERTION SORT");
        new InsertionSort().analysis();
        Console.showMsgInfo("QUICK SORT");
        new QuickSort().analysis();
        Console.showMsgInfo("RADIX SORT");
        new RadixSort().analysis();
        Console.showMsgSuccess("Finish...");
    }
}