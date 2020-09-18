package com.ConstructionTeam.DataModels;

import java.util.ArrayList;

public class ErrorDataCollector {
    public void collectErrorData(ArrayList<ErrorData> errorDataList, String line){
        ErrorData errorData;
        ErrorDataModelCreator errorDataModelCreator = new ErrorDataModelCreator();
        errorData = errorDataModelCreator.createErrorData(line);
        errorDataList.add(errorData);
    }
}
