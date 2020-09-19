package com.ConstructionTeam.DataModels;

public interface DataModel {
     String getDateTime();
     void setDateTime(String line);
     void setId(String line);
     String getTitle();
     String getDescription();
     void setTitleDescription(String line);
}
