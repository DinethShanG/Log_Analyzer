package com.ConstructionTeam.FileRepository;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
public class LastAccessFileReaderTest {

    @Test
    public void should_return_last_access_date_and_time() throws IOException {
        LastAccessFileReader lastAccessFileReader=new LastAccessFileReader();
        String lastAccessDateAndTime=lastAccessFileReader.getLastAccessDateTime("src/test/java/com/ConstructionTeam/FileRepository/LastAccessDateTimeTest.txt");
        assertEquals("2020-09-17 14:52:50",lastAccessDateAndTime);
    }
  
}