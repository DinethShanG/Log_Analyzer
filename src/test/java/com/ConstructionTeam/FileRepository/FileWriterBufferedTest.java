package com.ConstructionTeam.FileRepository;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import java.io.BufferedWriter;
import org.junit.Test;

public class FileWriterBufferedTest {
  @Test
  public void should_return_a_buffered_writer_instance(){
    FileWriterBuffered fileWriterBuffered = new FileWriterBuffered();
    assertThat(fileWriterBuffered.writeFile("src/test/java/com/ConstructionTeam/FileRepository/LastAccessFileWriterTest.java"),instanceOf(BufferedWriter.class));

  }


}