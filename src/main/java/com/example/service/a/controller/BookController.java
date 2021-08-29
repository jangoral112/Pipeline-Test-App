package com.example.service.a.controller;

import com.example.service.a.model.dto.BookRequest;
import com.example.service.a.model.dto.BookResponse;
import com.example.service.a.model.dto.MessageResponse;
import com.example.service.a.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/")
    public ResponseEntity<MessageResponse> postBook(@RequestBody BookRequest bookRequest) {
        var messageResponse = bookService.postBook(bookRequest);
        return ResponseEntity.ok(messageResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable("id") Long id) {
        var book = bookService.getBook(id);
        return ResponseEntity.ok(book);
    }
}
