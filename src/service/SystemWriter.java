package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class SystemWriter {

    private BufferedWriter writer;
    private String filepath;
    private SystemLogger logger;

    public SystemWriter(
            String filepath,
            SystemLogger logger
    ) {
        this.filepath = filepath;
        this.logger = logger;
    }

    public void write(String message) {
        try {
            this.writer = new BufferedWriter(new FileWriter(filepath, true));
            this.writer.write(message);
            this.writer.newLine();
            this.writer.close();
        } catch (Throwable e) {
            this.logger.warning(e.getMessage());
        }
    }
}
