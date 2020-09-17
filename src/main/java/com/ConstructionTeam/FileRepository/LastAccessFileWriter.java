package com.ConstructionTeam.FileRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LastAccessFileWriter {
    public void updateLastAccessDateTime(String lastAccessDateTime,String filePath) {
        System.out.println(lastAccessDateTime);
        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter buffer = new BufferedWriter(writer);
        try {
            buffer.write(lastAccessDateTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully Updated Last Access Date & Time");
    }
}
