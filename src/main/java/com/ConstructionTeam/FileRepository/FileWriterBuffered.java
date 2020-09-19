package com.ConstructionTeam.FileRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterBuffered implements OutputFileWriter {
    @Override
    public BufferedWriter writeFile(String path) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert writer != null;
        BufferedWriter buffer = new BufferedWriter(writer);
        return buffer;
    }
}
