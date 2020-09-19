package com.ConstructionTeam.FileRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ConstructionTeam.DataModels.ErrorData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.ConstructionTeam.DataModels.ErrorDataModelCreator;
import org.junit.Test;

public class LogFileReaderTest {

  @Test
  public void should_return_error_data_list() throws IOException {
    LogFileReader logFileReader = new LogFileReader();

    InputFileReader inputFileReade = mock(InputFileReader.class);
    BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/java/com/ConstructionTeam/FileRepository/LogFileReaderTest.log"));
    when(inputFileReade.readFile("src/test/java/com/ConstructionTeam/FileRepository/LogFileReaderTest.log")).thenReturn(bufferedReader);

    ErrorDataModelCreator errorDataModelCreator=mock(ErrorDataModelCreator.class);
    ErrorData errorData = new ErrorData();
    when(errorDataModelCreator.createErrorData("2020-01-25 16:16:51,484 [15422630]  ERROR - j.psi.stubs.StubTreeLoaderImpl - Last Action: Run ")).thenReturn(errorData);

    ArrayList <ErrorData> errorDataList = new ArrayList<>();

    assertEquals(errorDataList,logFileReader.getData("src/test/java/com/ConstructionTeam/FileRepository/LogFileReaderTest.log","2020-09-18 23:20:13","src/main/java/com/ConstructionTeam/FileRepository/LastAccessDateTime.txt"));

  }

}