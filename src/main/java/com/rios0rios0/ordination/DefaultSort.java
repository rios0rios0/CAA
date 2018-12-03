package com.rios0rios0.ordination;

import com.rios0rios0.utils.Array;
import com.rios0rios0.utils.Console;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

abstract class DefaultSort implements Sort {

    private int instructions = 0;

    private Map<Integer, Float> performance = new LinkedHashMap<>();

    void inc(int sum) {
        this.instructions += sum;
    }

    public void analysis(int times) {
        for (int turn = 1; turn <= times; turn++) {
            sort(Array.generateArray(5));
            addPerformance(5);
            //
            sort(Array.generateArray(10));
            addPerformance(10);
            //
            sort(Array.generateArray(50));
            addPerformance(50);
            //
            sort(Array.generateArray(100));
            addPerformance(100);
            //
            sort(Array.generateArray(1000));
            addPerformance(1000);
            //
            sort(Array.generateArray(10000));
            addPerformance(10000);
        }
        Iterator iterator = performance.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            Console.showMsg(String.format("%d random elements (%d times). Median of instructions: %.0f",
                    key, times, (this.performance.get(key) / times)));
        }
    }

    public void analysis() {
        analysis(50);
    }

    public void demo(int[] bestCase, int[] worstCase) {
        Array.printArray(sort(bestCase));
        Console.showMsg("Best Case - Instructions: " + getInstructions());
        Array.printArray(sort(worstCase));
        Console.showMsg("Worst Case - Instructions: " + getInstructions());
        for (int retry = 625; retry <= 20000; retry *= 2) {
            Console.showMsg("Elements: " + retry);
            sort(Array.generateArray(retry));
            Console.showMsg("Instructions: " + getInstructions());
        }
    }

    private void addPerformance(int index) {
        float value = (Objects.isNull(this.performance.get(index)) ? 0 : this.performance.get(index));
        this.performance.put(index, value + getInstructions());
    }

    void setInstructions(int count) {
        this.instructions = count;
    }

    private int getInstructions() {
        return this.instructions;
    }
}