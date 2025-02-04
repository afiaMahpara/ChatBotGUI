package com.mycompany.project;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.util.Random;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class TaskHandler {

    String exceptionCase[] = {"I dont understand", "Ask something else", "sorry?press help", "??"};

    public TaskHandler() {
    }

    public String handleTask(int n, int k, String s) {

        if (n == k + 0) {
            return help();
        } else if (n == k + 1) {
            return getTime();
        } else if (n == k + 2) {
            return getOSInfo();
        } else if (n == k + 3) {
            try {
                return doMath(s);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (n == k + 4) {
            return shutdown();
        } else if (n == k + 5) {
            return restart();
        } else if (n == k + 6) {
            return createFolder(s);
        } else if (n == k + 7) {
            return createFile(s);
        } else if (n == k + 8) {
            return diskCleanup();
        } else if (n == k + 9) {
            return setReminder(s);
        }

        return exceptionCase[new Random().nextInt(4)];
    }

    public String help() {

        return "Manual : "
                + "\n\t1.Ask usual things for casual conversation"
                + "\n\t2.The bot will tell if he doesnt know the answer"
                + "\n\t3.##help - for manual"
                + "\n\t4.##gettime - for current date and time"
                + "\n\t5.##os - get operating system info"
                + "\n\t6.##domath 1+1 - for doing simple maths"
                + "\n\t7.##shutdown - Shutdown pc in 10 seconds"
                + "\n\t8.##restart - Restart pc in 10 seconds"
                + "\n\t9.##createfolder D:\file - Create folder"
                + "\n\t in specified directory"
                + "\n\t10.##createfile D:\file - Create file"
                + "\n\t in specified directory"
                + "\n\t11.##diskclean - go to diskcleanup"
                + "\n\t12.##setrteminder - set a reminder in bots window";
    }

    public String getTime() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public String getOSInfo() {

        return "Your :\tOS Name " + System.getProperty("os.name") + "\n\t"
                + "\tOS Version " + System.getProperty("os.arch");
    }

    public String doMath(String s) throws ScriptException {

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String foo = s.replaceAll("##domath", "").trim();
        return (engine.eval(foo)).toString();
    }

    public String shutdown() {
        try {
            Runtime.getRuntime().exec("shutdown.exe -s -t 10");
        } catch (Exception e) {
            System.out.println(e);
        }

        return "Shutting down in 10s";
    }

    public String restart() {
        try {
            Runtime.getRuntime().exec("shutdown.exe -r -t 10");
        } catch (Exception e) {
            System.out.println(e);
        }

        return "Restarting in 10s";
    }

    public String createFolder(String s) {

        String foo = s.replaceAll("##createfolder", "").trim();
        File f = new File(foo);

        if (f.exists()) {
            return "Already Exists";
        }

        f.mkdir();

        return "Successfully made folder at " + f.getAbsolutePath();

    }

    public String createFile(String s) {

        String foo = s.replaceAll("##createfile", "").trim();
        File f = new File(foo);

        if (f.exists()) {
            return "Already Exists";
        }
        

        try {
            f.createNewFile();
        } catch (Exception e) {
            System.out.println(e);
        }

        return "Successfully made file at " + f.getAbsolutePath();

    }

    public String diskCleanup() {
        try {
            Runtime.getRuntime().exec("cleanmgr");
        } catch (Exception e) {
            System.out.println(e);
        }

        return "Clean from here";
    }

    public String setReminder(String s) {
        String foo = s.replaceAll("##setreminder", "").trim();

        NewJFrame.jLabel2.setText(foo);

        return "Task Completed";
    }
}
