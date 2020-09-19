package com.ConstructionTeam.FileRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferFileReader implements InputFileReader {
    @Override
    public BufferedReader readFile(String path) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println("File is not Founded");
        }
        try {
            if (bufferedReader == null) {
                System.exit(0);
            } else if (bufferedReader.readLine() == null) {
                System.out.println("File is empty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }
}
