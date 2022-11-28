package service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.*;

public class SystemLogger{

    private Logger logger;
    private FileHandler file;
    private SimpleFormatter formatter;

    public SystemLogger() {

        this.logger = Logger.getLogger(LocalDate.now().toString());
        this.formatter = new SimpleFormatter();

        try {
            this.file = new FileHandler("storage/logs/" + LocalDate.now().toString() + ".log", true);
            this.file.setFormatter(this.formatter);
            logger.addHandler(this.file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(Level level, String message) { this.logger.log(new LogRecord(level, message)); }

    public void info(String message) { this.write(Level.INFO, message); }

    public void warning(String message) { this.write(Level.WARNING, message); }

    public void severe(String message) { this.write(Level.SEVERE, message); }

    public void fine(String message) { this.write(Level.FINE, message); }

    public void finer(String message) { this.write(Level.FINER, message); }

    public void finest(String message) { this.write(Level.FINEST, message); }

    public void config(String message) { this.write(Level.CONFIG, message); }

    public void off(String message) { this.write(Level.OFF, message); }
}
