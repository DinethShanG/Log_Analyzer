package com.ConstructionTeam.FileRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LastAccessFileWriter {
    public void updateLastAccessDateTime(String lastAccessDateTime,String lastAccessFilePath) {
        OutputFileWriter bufferFileWriter = new FileWriterBuffered();
        BufferedWriter bufferedWriter = bufferFileWriter.writeFile(lastAccessFilePath);
        try {
            bufferedWriter.write(lastAccessDateTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully Updated Last Access Date & Time");
    }
}
