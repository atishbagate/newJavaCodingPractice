package DesignPatterns.CreationalPatterns;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class AppLogger {

    // 1. The single instance (volatile ensures changes made by one thread are instantly visible to others)
    private static volatile AppLogger instance;
    private PrintWriter writer;

    // 2. Private constructor to prevent direct instantiation
    private AppLogger() {
        try{
            FileWriter filrWriter = new FileWriter("applicaiton.log",true);
           writer = new PrintWriter(filrWriter,true);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // 3. Public static method to provide global access to the instance
    public static AppLogger getInstance(){
        if(instance == null){
            synchronized (AppLogger.class){
                if(instance == null){
                    instance = new AppLogger();
                }
            }
        }
        return instance;
       }

     // actual functionality we want to use.
    public void log(String message){
        writer.println(LocalDateTime.now() + " - " + message);
    }

    public static void main(String[] args) {
        // Get the single instance of AppLogger
        AppLogger logger1 = AppLogger.getInstance();
        logger1.log("Application started.");

        // Get the instance again to simulate another part of the app logging
        AppLogger logger2 = AppLogger.getInstance();
        logger2.log("Connecting to database...");

        // Verify that both references point to the exact same logger instance
        System.out.println("Are logger1 and logger2 the same instance? " + (logger1 == logger2));
        
        System.out.println("Check the 'applicaiton.log' file in your project root to see the logged messages.");
    }
}
