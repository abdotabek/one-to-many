package com.example.demosimple.controller;

import com.example.demosimple.dto.BookDto;
import com.example.demosimple.entity.Book;
import com.example.demosimple.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<Book> addBooks(@RequestBody BookDto dto) {
        Book book = bookService.createBook(dto);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody BookDto dto, @PathVariable Long id) {
        Book book = bookService.updateBook(id, dto);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book byId = bookService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllBooks() {
        bookService.deleteAllBooks();
        return ResponseEntity.ok().build();
    }
}
