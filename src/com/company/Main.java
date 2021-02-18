package com.company;

import java.util.Arrays;

public class Main {

    public static void sort(int[] array) {
        int min = 0;
        int max = array.length;
        thanosSort(array, min, max);

        System.out.println("Массив отсортирован: " + Arrays.toString(array));
    }


    public static void thanosSort(int[] array, int min, int max) {
        int[] helpArray = new int[array.length];
        double sum = 0;
        int leftInd = min;
        int rightInd = max;

        for (int i = min; i < max; i++) {
            sum += array[i];
        }
        sum = sum / (max - min);

        for (int i = min; i < max; i++) {
            if (array[i] < sum) {
                helpArray[leftInd] = array[i];
                leftInd++;
            } else {
                helpArray[rightInd - 1] = array[i];
                rightInd--;
            }
        }

        System.arraycopy(helpArray, min, array, min, max - min);

        if (rightInd - min > 1) {
            thanosSort(array, min, leftInd);
            thanosSort(array, rightInd, max);
        }
    }


    public static void main(String[] args) {
        int[] array = {7, 3, 0, 10, 1, 2, 3, 6, 99, 4, 2, 5, 98, 1000, 100100};
        sort(array);
    }
}
