package com.ConstructionTeam.FileRepository;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LastAccessFileReaderTest {

    @Test
    public void should_return_last_access_date_and_time_if_not_null() throws IOException {
        LastAccessFileReader lastAccessFileReader=new LastAccessFileReader();
        String lastAccessDateAndTime=lastAccessFileReader.getLastAccessDateTime("src/test/java/com/ConstructionTeam/FileRepository/LastAccessFileReaderTest.txt");
        assertEquals("2020-09-17 14:52:50",lastAccessDateAndTime);
    }

    @Test
    public void should_return_last_access_date_and_time_if_null() throws IOException {
        LastAccessFileReader lastAccessFileReader=new LastAccessFileReader();
        String lastAccessDateAndTime=lastAccessFileReader.getLastAccessDateTime("src/test/java/com/ConstructionTeam/FileRepository/LastAccessFileReaderTestNull.txt");
        assertEquals(null,lastAccessDateAndTime);
    }
  
}