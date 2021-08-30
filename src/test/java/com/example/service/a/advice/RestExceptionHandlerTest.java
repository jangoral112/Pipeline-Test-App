package com.example.service.a.advice;

import com.example.service.a.exception.BookNotFoundException;
import com.example.service.a.model.dto.MessageResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public class RestExceptionHandlerTest {

    private RestExceptionHandler restExceptionHandler = new RestExceptionHandler();

    @Test
    public void shouldFail() {
        fail("Should fail");
    }

    @Test
    public void shouldReturnInternalServerErrorMessageResponseWhenHandlingExceptionGenerically() {
        // Given
        var sampleMessage = "SAMPLE_MESSAGE";
        var genericException = new RuntimeException(sampleMessage);

        // When
        var response = restExceptionHandler.handleExceptionsGenerically(genericException);

        // Then
        var expectedStatus = INTERNAL_SERVER_ERROR;
        var expectedBody = new MessageResponse(sampleMessage);

        assertThat(response.getStatusCode(), is(expectedStatus));
        assertThat(response.getBody().getMessage(), is(expectedBody.getMessage()));
    }

    @Test
    public void shouldReturnNotFoundMessageResponseWhenHandlingBookNotFoundException() {
        // Given
        var sampleMessage = "SAMPLE_MESSAGE";
        var bookNotFoundException = new BookNotFoundException(sampleMessage);

        // When
        var response = restExceptionHandler.handleBookNotFoundException(bookNotFoundException);

        // Then
        var expectedStatus = NOT_FOUND;
        var expectedBody = new MessageResponse(sampleMessage);

        assertThat(response.getStatusCode(), is(expectedStatus));
        assertThat(response.getBody().getMessage(), is(expectedBody.getMessage()));
    }

}
