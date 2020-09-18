package com.ConstructionTeam.FileRepository;

import static org.junit.Assert.*;

import com.ConstructionTeam.DataModels.ErrorData;
import java.util.ArrayList;
import org.junit.Test;

public class LogFileReaderTest {

  @Test
  public void should_return_error_data_list(){
    LogFileReader logFileReader = new LogFileReader();
    ArrayList<ErrorData> actualErrorDataList = logFileReader.getData("src/test/java/com/ConstructionTeam/FileRepository/LogFileReaderTest.log","2020-01-25 16:07:06");
    ArrayList<ErrorData> expectedErrorDataList=new ArrayList<ErrorData>();
    //expectedErrorDataList.add();
  }

}