package com.rios0rios0;

import com.rios0rios0.ordination.HeapSort;
import com.rios0rios0.utils.Console;

/**
 * @author Felipe Rios (rios0rios0)
 */
public class Main {

    public static void main(String[] args) {
        Console.showMsgSuccess("Starting the demonstrations...");
        Console.showMsgInfo("HEAP SORT");
        new HeapSort().demo();
        Console.showMsgSuccess("Finish...");
    }
}