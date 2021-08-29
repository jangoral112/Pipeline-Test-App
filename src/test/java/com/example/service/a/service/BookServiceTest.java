package com.example.service.a.service;

import com.example.service.a.model.dto.BookRequest;
import com.example.service.a.model.entity.Book;
import com.example.service.a.repository.BookRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void shouldFail() {
        fail("Should fail");
    }

    @Test
    public void shouldReturnMessageResponseWhenPostBook() {
        // Given
        var bookRequest = BookRequest.builder()
                .author("Jan")
                .title("TITLE")
                .pagesNumber(11)
                .build();

        var savedBook = Book.builder()
                .id(1L)
                .author("Jan")
                .title("TITLE")
                .pagesNumber(11)
                .build();

        when(bookRepository.save(any(Book.class))).thenReturn(savedBook);
        // When
        var messageResponse = bookService.postBook(bookRequest);

        // Then
        assertThat(messageResponse.getMessage(), is(not(emptyString())));
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenPostBook() {
        // Given
        var bookRequest = BookRequest.builder()
                .author("Jan")
                .pagesNumber(11)
                .build();

        when(bookRepository.save(any(Book.class))).thenThrow(new RuntimeException());

        // When
        try {
            bookService.postBook(bookRequest);

            // Then
            fail("Exception not thrown");
        } catch (RuntimeException e) {
            assertThat(e.getMessage(), is(not(emptyString())));
        }
    }

}
