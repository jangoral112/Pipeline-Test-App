package com.example.service.a.service;

import com.example.service.a.model.Book;
import com.example.service.a.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book postBook() {

        var book = Book.builder()
                .author("Jan")
                .title("Title")
                .pagesNumber(45)
                .build();

        return bookRepository.save(book);
    }

    public Book getBook(Long id) {

        var optionalBook = bookRepository.findById(id);

        return optionalBook.get();
    }
}
