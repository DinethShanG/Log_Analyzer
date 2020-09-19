package com.ConstructionTeam.FileRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderBuffered implements InputFileReader {
    @Override
    public BufferedReader readFile(String path) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.out.println("File not Founded");
        }
        return new BufferedReader(fileReader);
    }
}
