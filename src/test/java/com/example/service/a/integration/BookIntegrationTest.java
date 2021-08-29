package com.example.service.a.integration;

import com.example.service.a.model.dto.BookRequest;
import com.example.service.a.model.entity.Book;
import com.example.service.a.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        bookRepository.deleteAll();
    }

    @Test
    public void shouldRespondWithSuccess() throws Exception {
        // Given
        var bookRequestBody= toJson(BookRequest.builder()
                .author("Jan")
                .title("SAMPLE TITLE")
                .pagesNumber(100)
                .build());

        var httpPostRequest = post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookRequestBody);

        // When
        var result = mvc.perform(httpPostRequest);

        // Then
        var expectedResponseBody = "Book successfully saved";

        result.andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath(".message").value(expectedResponseBody));
    }

    @Test
    public void shouldCreateNewBook() throws Exception {
        // Given
        var bookRequestBody= toJson(BookRequest.builder()
                .author("Jan")
                .title("SAMPLE TITLE")
                .pagesNumber(100)
                .build());

        var httpPostRequest = post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookRequestBody);

        // When
        mvc.perform(httpPostRequest);

        // Then
        var expectedBook = Book.builder()
                .author("Jan")
                .title("SAMPLE TITLE")
                .pagesNumber(100)
                .build();

        var books = bookRepository.findAll();
        assertThat(books, hasSize(1));

        var actualBook = books.get(0);
        assertThat(actualBook.getId(), is(notNullValue()));
        assertThat(actualBook.getAuthor(), is(expectedBook.getAuthor()));
        assertThat(actualBook.getTitle(), is(expectedBook.getTitle()));
        assertThat(actualBook.getPagesNumber(), is(expectedBook.getPagesNumber()));
    }

    @SneakyThrows
    private String toJson(Object object) {
        return objectMapper.writeValueAsString(object);
    }
}
