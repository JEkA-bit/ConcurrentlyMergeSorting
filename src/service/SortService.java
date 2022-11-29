package service;

import java.util.Arrays;

public class SortService {

    public void sort(
            int[] arr,
            int length
    ) {

        if (length < 2) return;

        int mid = length / 2;

        int[] leftPart = Arrays.copyOf(arr, mid);
        int[] rightPart = Arrays.copyOfRange(arr, mid, length);

        sort(leftPart, mid);
        sort(rightPart, length - mid);

        merge(arr, leftPart, rightPart, mid, length - mid);
    }

    public void merge(
            int[] arr,
            int[] left,
            int[] right,
            int sizeL,
            int sizeR
    ) {

        int leftIndex = 0;
        int rightIndex = 0;
        int arrIndex = 0;

        while (leftIndex < sizeL && rightIndex < sizeR) {
            arr[arrIndex++] = left[leftIndex] <= right[rightIndex] ? left[leftIndex++] : right[rightIndex++];
        }

        while (leftIndex < sizeL) {
            arr[arrIndex++] = left[leftIndex++];
        }

        while (rightIndex < sizeR) {
            arr[arrIndex++] = right[rightIndex++];
        }
    }
}
