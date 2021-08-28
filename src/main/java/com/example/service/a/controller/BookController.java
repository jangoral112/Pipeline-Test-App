package com.example.service.a.controller;

import com.example.service.a.model.Book;
import com.example.service.a.model.BookResponse;
import com.example.service.a.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/")
    public ResponseEntity<String> postBook() {
        var response = bookService.postBook();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable("id") Long id) {
        var book = bookService.getBook(id);
        return ResponseEntity.ok(book);
    }
}
