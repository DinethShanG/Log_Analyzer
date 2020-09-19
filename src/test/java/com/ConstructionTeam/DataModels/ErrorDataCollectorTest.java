package com.ConstructionTeam.DataModels;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import org.junit.Test;

public class ErrorDataCollectorTest {
  private ArrayList<ErrorData> errorDataList = new ArrayList<>();
  @Test
  public void should_collect_error_data(){
    ErrorData errorData = mock (ErrorData.class);
    ErrorDataModelCreator errorDataModelCreator = mock(ErrorDataModelCreator.class);
    ErrorDataCollector errorDataCollector = new ErrorDataCollector();
    errorData = errorDataModelCreator.createErrorData("2020-01-25 16:16:51,484 [15422630]  ERROR - j.psi.stubs.StubTreeLoaderImpl - Last Action: Run ");
    errorDataList.add(errorData);
    assertEquals("add new error data to errorDataList",1,errorDataList.size());
  }
}