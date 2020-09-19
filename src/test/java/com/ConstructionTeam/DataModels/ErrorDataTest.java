package com.ConstructionTeam.DataModels;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class ErrorDataTest {
    ErrorData errorDataGet = new ErrorData("2020-01-25 16:16:51","15422630","j.psi.stubs.StubTreeLoaderImpl ","Last Action: Run");
    ErrorData errorDataSet = new ErrorData();
    @Test
    public void should_return_date_and_time()
    {
        assertEquals("2020-01-25 16:16:51",errorDataGet.getDateTime());
    }
    @Test
    public void should_return_title()
    {
        assertEquals("j.psi.stubs.StubTreeLoaderImpl ",errorDataGet.getTitle());
    }
    @Test
    public void should_return_description()
    {
        assertEquals("Last Action: Run",errorDataGet.getDescription());
    }

    @Test
    public void should_set_date_and_time()
    {
        errorDataSet.setDateTime("2020-01-25 16:16:51,484 [15422630]  ERROR - j.psi.stubs.StubTreeLoaderImpl - Last Action: Run ");
        assertEquals("2020-01-25 16:16:51",errorDataSet.getDateTime());
    }

    @Test
    public  void should_set_id()
    {
        errorDataSet.setId("2020-01-25 16:16:51,484 [15422630]  ERROR - j.psi.stubs.StubTreeLoaderImpl - Last Action: Run ");
        assertThat(errorDataSet,instanceOf(ErrorData.class));
    }

    @Test
    public  void  should_set_title_description()
    {
        errorDataSet.setTitleDescription("2020-01-25 16:16:51,484 [15422630]  ERROR - j.psi.stubs.StubTreeLoaderImpl - Last Action: Run ");
        assertEquals("j.psi.stubs.StubTreeLoaderImpl ",errorDataSet.getTitle());
        assertEquals("Last Action: Run",errorDataSet.getDescription());
    }


}