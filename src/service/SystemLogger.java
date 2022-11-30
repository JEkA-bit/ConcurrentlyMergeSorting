package service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.*;

public class SystemLogger{

    private final Logger logger;

    public SystemLogger() {

        this.logger = Logger.getLogger(LocalDate.now().toString());
        SimpleFormatter formatter = new SimpleFormatter();

        try {
            FileHandler file = new FileHandler("storage/logs/" + LocalDate.now() + ".log", true);
            file.setFormatter(formatter);
            logger.addHandler(file);
        } catch (IOException e) {
            this.warning(e.getMessage());
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
