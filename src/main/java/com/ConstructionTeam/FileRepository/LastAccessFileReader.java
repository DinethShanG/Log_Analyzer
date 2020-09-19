package com.ConstructionTeam.FileRepository;

import java.io.BufferedReader;
import java.io.IOException;

public class LastAccessFileReader  {
    private String lastAccessDateTime;

    public String getLastAccessDateTime(String lastAccessFilePath) throws IOException {
        String line;
        InputFileReader fileReaderBuffered = new FileReaderBuffered();
        BufferedReader bufferedReader1= fileReaderBuffered.readFile(lastAccessFilePath);
        while((line = bufferedReader1.readLine())!=null)
        {
            lastAccessDateTime = line;
        }
        return lastAccessDateTime;
    }
}
