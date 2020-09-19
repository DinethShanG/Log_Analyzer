package com.ConstructionTeam.DataModels;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;
import org.junit.Test;

public class DateTimeTest {
  // DateTime.getCurrentDateTime()  return real Calender so we don't test this method
  @Test
  public void should_return_formatted_date_and_time() throws ParseException {
    DateTime dateTime = new DateTime();
    Date formattedDateTime = dateTime.formatDateTime("2020-09-19 13:38:27");
    assertEquals("Sat Sep 19 13:38:27 IST 2020",formattedDateTime.toString());
  }
}