import consts.Variables;
import service.SortService;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        int[] arr = random.ints(10, -100, 100).toArray();

        String output = "Starter array: " + Arrays.toString(arr);

        Variables.writer.write("\n\n___Started date and time: " + LocalDateTime.now() + "___\n");
        Variables.writer.write(output);
        System.out.println(output);

        if(Variables.IS_FOR_DISCOVER_HOW_TO_USING_THREADS) System.out.print("\n");

        LocalDateTime start = LocalDateTime.now();
        new SortService(arr);
        LocalDateTime finish = LocalDateTime.now();

        output = "Sorted array: " + Arrays.toString(arr);

        Variables.writer.write(output);
        System.out.print(output);

        output = "\nTime executing: " + ChronoUnit.MILLIS.between(start, finish) + "ms";

        Variables.writer.write(output);
        System.out.print(output);
    }

}