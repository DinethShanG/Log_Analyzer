package com.ConstructionTeam.DataModels;

public interface DataModel {
    public String getDateTime();
    public void setDateTime(String line);
    public void setId(String line);
    public String getTitle();
    public String getDescription();
    public void setTitleDescription(String line);
}
