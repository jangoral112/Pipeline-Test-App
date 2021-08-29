package com.example.service.a.service;

import com.example.service.a.exception.BookNotFoundException;
import com.example.service.a.model.entity.Book;
import com.example.service.a.model.dto.BookRequest;
import com.example.service.a.model.dto.BookResponse;
import com.example.service.a.model.dto.MessageResponse;
import com.example.service.a.repository.BookRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    @NonNull
    @Autowired
    private BookRepository bookRepository;

    public MessageResponse postBook(BookRequest bookRequest) {

        var book = Book.builder()
                .author(bookRequest.getAuthor())
                .title(bookRequest.getTitle())
                .pagesNumber(bookRequest.getPagesNumber())
                .build();

        var savedBook = bookRepository.save(book);

        if(savedBook.getId() != null) {
            return new MessageResponse("Book successfully saved");
        }

       throw new RuntimeException("Saving book failed");
    }

    public BookResponse getBook(Long id) {

        var optionalBook = bookRepository.findById(id);

        if(optionalBook.isEmpty()) {
            throw new BookNotFoundException("Book not found");
        }

        var book = optionalBook.get();

        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .pagesNumber(book.getPagesNumber())
                .build();
    }
}
