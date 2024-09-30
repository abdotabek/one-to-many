package com.example.demosimple.service;

import com.example.demosimple.dto.BookDto;
import com.example.demosimple.entity.Book;
import com.example.demosimple.reposotory.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public Book createBook(BookDto dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setDescription(dto.getDescription());
        return bookRepo.save(book);
    }

    public Book updateBook(Long id, BookDto dto) {
        Book book = bookRepo.findById(id).orElse(null);
        book.setTitle(dto.getTitle());
        book.setDescription(dto.getDescription());
        return bookRepo.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepo.deleteById(id);
    }

    public Book getById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    public void deleteAllBooks() {
        bookRepo.deleteAll();
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
}
