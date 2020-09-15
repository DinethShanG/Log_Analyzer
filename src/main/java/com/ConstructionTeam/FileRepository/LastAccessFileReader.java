package com.ConstructionTeam.FileRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LastAccessFileReader {
    private String lastAccessDateTime;

    public String getLastAccessDateTime(String lastAccessDateTimeFilePath) throws IOException {
        BufferedReader objReader = null;
        try {
            String strCurrentLine;

            objReader = new BufferedReader(new FileReader(lastAccessDateTimeFilePath));

            while ((strCurrentLine = objReader.readLine()) != null) {

                lastAccessDateTime = strCurrentLine;
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return lastAccessDateTime;
    }
}
