package com.ConstructionTeam.FileRepository;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

public class LastAccessFileWriterTest {
  @Test
  public void should_write_last_access_date_and_time() throws IOException {
    LastAccessFileWriter lastAccessFileWriter = new LastAccessFileWriter();
    lastAccessFileWriter.updateLastAccessDateTime("2020-09-17 14:52:50","src/test/java/com/ConstructionTeam/FileRepository/LastAccessFileWriterTest.txt");
    String actualContent = new String(Files.readAllBytes(Paths.get("src/test/java/com/ConstructionTeam/FileRepository/LastAccessFileWriterTest.txt")));
    assertEquals("2020-09-17 14:52:50",actualContent);
  }
}