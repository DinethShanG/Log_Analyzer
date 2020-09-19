package com.ConstructionTeam.DataModels;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ErrorDataModelCreatorTest {

    @Test
    public void should_return_error_data(){
        ErrorDataModelCreator errorDataModelCreator = new ErrorDataModelCreator();
        assertThat(errorDataModelCreator.createErrorData("2020-01-25 16:16:51,484 [15422630]  ERROR - j.psi.stubs.StubTreeLoaderImpl - Last Action: Run "),instanceOf(ErrorData.class));
    }
}