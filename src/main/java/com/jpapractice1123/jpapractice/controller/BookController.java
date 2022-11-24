package com.jpapractice1123.jpapractice.controller;

import com.jpapractice1123.jpapractice.domain.dto.BookResponse;
import com.jpapractice1123.jpapractice.domain.entity.Book;
import com.jpapractice1123.jpapractice.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity<List<BookResponse>> makeList(Pageable pageable){
        return ResponseEntity.ok().body(bookService.makeList(pageable));
    }
}
