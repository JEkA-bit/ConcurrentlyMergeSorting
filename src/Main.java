import service.SortService;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        SortService sorter = new SortService();

        int[] arr = new int[10];

        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }

        System.out.print("Starter array: ");
        Arrays.stream(arr).forEach(el -> System.out.print(el + " "));

        LocalDateTime start = LocalDateTime.now();
        sorter.sort(arr, arr.length);
        LocalDateTime finish = LocalDateTime.now();

        System.out.print("\nSorted array: ");
        Arrays.stream(arr).forEach(el -> System.out.print(" " + el) );
        System.out.print("\nTime executing: " + ChronoUnit.MILLIS.between(start, finish));
    }

}