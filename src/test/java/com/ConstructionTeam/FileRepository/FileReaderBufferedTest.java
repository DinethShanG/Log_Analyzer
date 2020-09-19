package com.ConstructionTeam.FileRepository;

import org.junit.Test;

import java.io.BufferedReader;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class FileReaderBufferedTest {

    @Test
    public void should_return_a_buffer_reader()
    {
        FileReaderBuffered fileReaderBuffered = new FileReaderBuffered();
        assertThat(fileReaderBuffered.readFile("src/test/java/com/ConstructionTeam/FileRepository/LastAccessFileReaderTest.txt"),instanceOf(BufferedReader.class));
    }

}