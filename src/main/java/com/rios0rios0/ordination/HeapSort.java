package com.rios0rios0.ordination;

/**
 * @author Felipe Rios (rios0rios0)
 * <p>
 * Concept:
 * <p>
 * O HeapSort é baseado em árvore binária "completa", sendo que a relação de nós acontece por tamanho de valores, em termos de altura.
 * Ou seja: a ordem, esquerda ou direita não importa. Os elementos maiores são as raizes, e os menores que as raizes formam, as folhas. Chama-se isto de Heap.
 * Esta Heap é formada durante a ordenação do vetor portanto, já se tira a altura da árvore binária por log(n).
 * <p>
 * O melhor caso é quando o vetor de entrada já tem a sua Heap formada. Ou seja, é uma árvore binária completa, e atende a descrição de Heap.
 * O pior caso é quando o HeapSort precisa formar a Heap. Desenvolvendo um maior custo computacional.
 */
public class HeapSort extends DefaultSort {

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

    public int[] sort(int array[]) {
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
        return array;
    }
}