package me.lukegs7.controller;

import io.swagger.annotations.Api;
import me.lukegs7.dto.BookDto;
import me.lukegs7.mapper.BookMapper;
import me.lukegs7.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
@Api(value="图书")
public class BookController {

    @Resource
    private BookService bookService;

    @Resource
    private BookMapper bookMapper;

    @GetMapping("")
    public List<BookDto> getAllBooks() {
        return bookMapper.toDto(bookService.findAll());
    }

    @GetMapping("/{id}")
    public BookDto findBookById(@PathVariable("id") UUID id) {
        return bookMapper.toDto(bookService.findById(id));
    }
}
