package com.example.service.a.service;

import com.example.service.a.model.entity.Book;
import com.example.service.a.model.dto.BookRequest;
import com.example.service.a.model.dto.BookResponse;
import com.example.service.a.model.dto.MessageResponse;
import com.example.service.a.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public MessageResponse postBook(BookRequest bookRequest) {

        var book = Book.builder()
                .author(bookRequest.getAuthor())
                .title(bookRequest.getTitle())
                .pagesNumber(bookRequest.getPagesNumber())
                .build();

        var savedBook = bookRepository.save(book);

        var responseMessage = savedBook.getId() != null ? "Book successfully saved" : "Saving book failed";
        return new MessageResponse(responseMessage);
    }

    public BookResponse getBook(Long id) {

        var book = bookRepository.findById(id).get();

        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .pagesNumber(book.getPagesNumber())
                .build();
    }
}
