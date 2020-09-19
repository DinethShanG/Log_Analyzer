package com.ConstructionTeam;

import java.util.Scanner;

public class UI {
    public String executeUI(){
        String logFilePath;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter the Log File path:");
        logFilePath = scanner.next();
        return logFilePath;
    }
}
