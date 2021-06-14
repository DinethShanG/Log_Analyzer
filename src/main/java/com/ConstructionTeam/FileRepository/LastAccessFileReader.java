package com.ConstructionTeam.FileRepository;

import java.io.*;
import java.util.Objects;

public class LastAccessFileReader  {
    private String lastAccessDateTime;

    public String getLastAccessDateTime(String lastAccessFilePath){
        String line = null;
        InputFileReader fileReaderBuffered = new FileReaderBuffered();
        BufferedReader bufferedReader1= null;
        try {
            bufferedReader1 = fileReaderBuffered.readFile(lastAccessFilePath);
        } catch (IOException e) {
            System.out.println("Last Access Date File not Founded");
        }
        while(true)
        {
            try {
                if ((line = Objects.requireNonNull(bufferedReader1).readLine()) == null) break;
            } catch (IOException e) {
                System.out.println("last Access Date File is Empty");
            }
            lastAccessDateTime = line;
        }
        return lastAccessDateTime;
    }
}
