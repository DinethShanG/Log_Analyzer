package com.ConstructionTeam.DataModels;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

  User user = new User("dummyName","dummyEmail");
  @Test
  public void should_return_name(){
    String actualName = user.getName();
    assertEquals("dummyName",actualName);
  }

  @Test
  public void should_return_email(){
    String actualEmail = user.getEmail();
    assertEquals("dummyEmail",actualEmail);

  }
}
