package com.example.service.a.service;

import com.example.service.a.model.Book;
import com.example.service.a.model.BookResponse;
import com.example.service.a.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public String postBook() {

        var book = Book.builder()
                .author("Jan")
                .title("Title")
                .pagesNumber(45)
                .build();

        var savedBook = bookRepository.save(book);

        return savedBook.getId() != null? "Book successfully saved" : "Saving book failed";
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
