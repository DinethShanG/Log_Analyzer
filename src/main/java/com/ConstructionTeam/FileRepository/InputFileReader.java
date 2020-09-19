package com.ConstructionTeam.FileRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface InputFileReader {
    BufferedReader readFile(String path) throws IOException;
}