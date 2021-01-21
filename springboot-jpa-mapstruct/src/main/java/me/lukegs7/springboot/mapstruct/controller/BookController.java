package me.lukegs7.springboot.mapstruct.controller;

import me.lukegs7.springboot.mapstruct.dto.BookDTO;
import me.lukegs7.springboot.mapstruct.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("")
    public List<BookDTO> getAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public BookDTO findBookById(@PathVariable("id") UUID id) {
        return bookService.findById(id);
    }
}
