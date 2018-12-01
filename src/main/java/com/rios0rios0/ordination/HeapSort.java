package com.rios0rios0.ordination;

import com.rios0rios0.utils.Array;
import com.rios0rios0.utils.Console;

/**
 * @author Felipe Rios (rios0rios0)
 * <p>
 * Performance Calculos:
 * <p>
 * O HeapSort é baseado em árvore binária "completa", sendo que a relação de nós
 * acontece por tamanho de valores, em termos de altura, ou seja: a ordem, esquerda ou direita, não importa.
 * Os elementos maiores, são as raizes, e os menores que as raizes formam as folhas. E o nó de valor maior, é a raiz.
 * Chama-se isto de Heap. Esta Heap é formada durante a ordenação do vetor, portanto, já se tira a altura da árvore binária por log(n).
 * <p>
 * O melhor caso é quando o vetor de entrada, já tem a sua Heap formada. Ou seja, é uma árvore binária completa, atendendo a descrição de Heap.
 * O pior caso, é quando o HeapSort ainda precisa formar a Heap. Desenvolvendo um maior custo computacional.
 */
public class HeapSort {

    private int instructions = 0;

    private void inc(int sum) {
        this.instructions += sum;
    }

    private void setInstructions(int count) {
        this.instructions = count;
    }

    public int getInstructions() {
        return this.instructions;
    }

    private void heapify(int array[], int total, int index) {
        int largest = index;
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;
        inc(2);
        if ((left < total) && (array[left] > array[largest])) {
            largest = left;
            inc(1);
        }
        if ((right < total) && (array[right] > array[largest])) {
            largest = right;
            inc(1);
        }
        if (largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;
            inc(2);
            heapify(array, total, largest);
        }
    }

    public void sort(int array[]) {
        setInstructions(0);
        int total = array.length;
        for (int index = (total / 2) - 1; index >= 0; index--) {
            inc(1);
            heapify(array, total, index);
        }
        for (int index = total - 1; index >= 0; index--) {
            int temp = array[0];
            array[0] = array[index];
            array[index] = temp;
            inc(2);
            heapify(array, index, 0);
        }
    }

    public void demo() {
        //Best Case
        int[] temp = {20, 15, 10, 11, 9, 8, 7, 4, 5, 3};
        sort(temp);
        Console.showMsg("Best Case - Instructions: " + getInstructions());
        //Worst Case
        temp = new int[]{3, 4, 5, 7, 8, 9, 10, 11, 15, 20};
        sort(temp);
        Console.showMsg("Worst Case - Instructions: " + getInstructions());
        for (int retry = 625; retry <= 20000; retry *= 2) {
            Console.showMsg("Elements: " + retry);
            temp = Array.generateArray(retry);
            sort(temp);
            Console.showMsg("Instructions: " + getInstructions());
        }
    }
}