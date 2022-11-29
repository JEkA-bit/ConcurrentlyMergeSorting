package consts;

import service.SystemLogger;
import service.SystemWriter;

import java.time.LocalDate;

public class Variables {

    public static boolean IS_FOR_DISCOVER_HOW_TO_USING_THREADS = true;
    public static int SORT_THREAD_PAUSE = 1000;
    public static SystemLogger logger = new SystemLogger();
    public static SystemWriter writer = new SystemWriter("storage/app/" + LocalDate.now() + "-output.txt", logger);


}
