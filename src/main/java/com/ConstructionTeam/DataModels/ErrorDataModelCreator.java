package com.ConstructionTeam.DataModels;

public class ErrorDataModelCreator {
    public ErrorData createErrorData(String line){
        ErrorData errorData = new ErrorData();
        errorData.setDateTime(line);
        errorData.setId(line);
        errorData.setTitleDescription(line);
        return errorData;
    }
}
