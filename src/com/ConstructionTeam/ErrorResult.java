package com.ConstructionTeam;

import java.text.ParseException;
import java.util.List;

public class ErrorResult {
    private String time;
    private String date;
    private String errorTree;
    private String errorDescription;

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getErrorTree() {
        return errorTree;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setErrorTree(String errorTree) {
        this.errorTree = errorTree;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
