package service;

import consts.Variables;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SystemWriter {

    private final String filepath;

    public SystemWriter(
            String filepath
    ) {

        try {
            Files.createDirectories(Paths.get("storage/app/"));
        } catch (IOException e) {
            Variables.logger.warning(e.getMessage());
        }

        this.filepath = filepath;
    }

    public void write(String message) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true));
            writer.write(message);
            writer.newLine();
            writer.close();
        } catch (Throwable e) {
            Variables.logger.warning(e.getMessage());
        }
    }
}
