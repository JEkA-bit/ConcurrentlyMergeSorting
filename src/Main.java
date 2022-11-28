import service.SystemLogger;
import service.SystemWriter;

import java.time.LocalDate;
import java.util.Random;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {
        SystemLogger logger = new SystemLogger();
        SystemWriter writer = new SystemWriter("storage/app/output-" + LocalDate.now().toString() + ".txt", logger);

        int length = 20;
        int arr[] = new int[] {83, 86, 77, 15, 93, 35, 86, 92, 49, 21,
                62, 27, 90, 59, 63, 26, 40, 26, 72, 36};


    }
}
