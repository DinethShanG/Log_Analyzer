package com.ConstructionTeam.FileRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LastAccessFileReader  {
    private String lastAccessDateTime;

    public String getLastAccessDateTime() throws IOException {
        String lastAccessFilePath = "src/main/java/com/ConstructionTeam/FileRepository/LastAccessDateTime.txt";
        BufferedReader objReader = null;
        com.ConstructionTeam.FileRepository.FileReader bufferFileReader = new BufferFileReader();
        BufferedReader bufferedReader = bufferFileReader.readFile(lastAccessFilePath);
        String strCurrentLine = bufferedReader.readLine();
        try {
            while ((strCurrentLine!= null)) {

                lastAccessDateTime = strCurrentLine;
            }

        } finally {

            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (lastAccessDateTime != null){
            return lastAccessDateTime;
        }
        else{
            return null;
        }

    }
}
