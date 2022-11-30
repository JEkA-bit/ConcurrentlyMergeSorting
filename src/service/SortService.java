package service;

import consts.Variables;

import java.util.Arrays;

public class SortService extends Thread{

    private final int[] arr;
    private boolean isEnd = false;

    public SortService(int[] arr) {

        this.arr = arr;
        if(Variables.IS_FOR_DISCOVER_HOW_TO_USING_THREADS){

            try {
                sleep(Variables.SORT_THREAD_PAUSE);
            } catch (InterruptedException e) {
                Variables.logger.warning(e.getMessage());
            }

            Variables.writer.write(getName() + " - started -" + Arrays.toString(this.arr));
            System.out.println(getName() + " - started -" + Arrays.toString(this.arr));
        }
    }

    @Override
    public void run() {
        sort();
    }

    public void sort() {

        int length = this.arr.length;

        if (length < 2) {
            return;
        }

        int mid = length / 2;

        int[] leftPart = Arrays.copyOf(this.arr, mid);
        int[] rightPart = Arrays.copyOfRange(this.arr, mid, length);

        SortService threadForLeft = new SortService(leftPart);
        SortService threadForRight = new SortService(rightPart);

        threadForLeft.start();
        threadForRight.start();

        while (threadForLeft.isAlive() || threadForRight.isAlive()) {}

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
