package com.ConstructionTeam.UserInterface;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class UITest {
  @Rule
  public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

  @Test
  public void should_fetch_file_path_from_UI(){
    systemInMock.provideLines("src/test/java/com/ConstructionTeam/FileRepository/LogFileReaderTest.log");
    UI UI = new UI();
    assertEquals("src/test/java/com/ConstructionTeam/FileRepository/LogFileReaderTest.log", UI.executeUI());
  }
}