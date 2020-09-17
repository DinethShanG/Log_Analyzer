package com.ConstructionTeam.FileRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LastAccessFileReader {
    private String lastAccessDateTime;

    public String getLastAccessDateTime() throws IOException {
        String lastAccessFilePath = "/home/dsgimhana/Desktop/Log_Analyzer/src/main/java/com/ConstructionTeam/FileRepository/LastAccessDateTime.txt";
        BufferedReader objReader = null;
        try {
            String strCurrentLine;

            objReader = new BufferedReader(new FileReader(lastAccessFilePath));

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
