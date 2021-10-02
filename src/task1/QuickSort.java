package task1;

import java.util.Arrays;
import java.util.Random;

class QuickSort {
    public static void main(String[] args) {
        Random rand = new Random();

        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(array));

        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] arr, int from, int to) {
        if (from < to) {
            int midElement = doSplitting(arr, from, to);
            quickSort(arr, from, midElement - 1);
            quickSort(arr, midElement, to);
        }
    }

    public static int doSplitting(int[] arr, int from, int to) {
        int midElement = arr[from + (to - from) / 2];
        int leftIndex = from;
        int rightIndex = to;
        while (leftIndex <= rightIndex) {
            while (arr[leftIndex] < midElement) {
                leftIndex++;
            }
            while (midElement < arr[rightIndex]) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                swapElement(arr, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    public static void swapElement(int[] arr, int firstElement, int secondElement) {
        int temp = arr[firstElement];
        arr[firstElement] = arr[secondElement];
        arr[secondElement] = temp;
    }
}
