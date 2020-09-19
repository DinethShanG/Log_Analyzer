package com.ConstructionTeam.FileRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LastAccessFileReader  {
    private String lastAccessDateTime;

    public String getLastAccessDateTime(String lastAccessFilePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(lastAccessFilePath));
        lastAccessDateTime = bufferedReader.readLine();

        return lastAccessDateTime;

    }
}
