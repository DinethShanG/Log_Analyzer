package com.ConstructionTeam.DataModels;

public class ErrorData implements DataModel{
    private String dateTime;
    private String id;
    private String title;
    private String description;
    private String [] readTitleDescription;

    

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String line) {
        this.dateTime = line.substring(0 ,line.indexOf(","));

    }


    public void setId(String line) {
        id = line.substring(line.indexOf("[")+1,line.indexOf("]"));
        this.id = id;
    }

    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }


    public void setTitleDescription(String line){
        String str;
        str = line.substring(line.indexOf("ERROR -")+8,line.length()-1);
        readTitleDescription = str.split("- ", 2);
        title = readTitleDescription[0];
        description = readTitleDescription[1];
    }
}
