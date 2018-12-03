package com.rios0rios0.ordination;

import java.util.Arrays;

/**
 * @author Felipe Rios (rios0rios0)
 * <p>
 * Concept:
 * <p>
 * O RadixSort, segue um método análogo a seguinte situação ilustrativa:
 * Imagine que se tem um jogo de cartas de 200 cartas, e as cartas são numeradas de 0 à 199.
 * Cada carta é alocada em uma pilha, segundo o seu dígito menos siginificativo, em pilhas de 0 à 9.
 * Depois disso, cada pilha é reunida, na ordem de 0 à 9. E, este mesmo processo é repetido para os N dígitos dos números das catas.
 * <p>
 * Seguindo sempre do menos significativo, para o mais siginificativo.
 * Quando o algoritmo fizer a juntção na casa da centena (para este exemplo), todas as pilhas formarão o baralho ordenado.
 */
public class RadixSort extends DefaultSort {

    private int max(int array[]) {
        int max = array[0];
        inc(2);
        for (int index = 1; index < array.length; index++) {
            inc(2);
            if (array[index] > max) {
                max = array[index];
                inc(1);
            }
        }
        return max;
    }

    private void countSort(int array[], int exp) {
        int index;
        int count[] = new int[10];
        int output[] = new int[array.length];
        Arrays.fill(count, 0);
        inc(1);
        for (index = 0; index < array.length; index++) {
            count[(array[index] / exp) % 10]++;
            inc(2);
        }
        inc(1);
        for (index = 1; index < 10; index++) {
            count[index] += count[index - 1];
            inc(2);
        }
        inc(1);
        for (index = array.length - 1; index >= 0; index--) {
            output[count[(array[index] / exp) % 10] - 1] = array[index];
            count[(array[index] / exp) % 10]--;
            inc(3);
        }
        inc(1);
        for (index = 0; index < array.length; index++) {
            array[index] = output[index];
            inc(2);
        }
    }

    public int[] sort(int array[]) {
        setInstructions(0);
        int max = max(array);
        inc(2);
        for (int exp = 1; (max / exp) > 0; exp *= 10)
            countSort(array, exp);
        return array;
    }
}