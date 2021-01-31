package me.lukegs7.service.impl;

import me.lukegs7.dao.entity.Book;
import me.lukegs7.dao.repository.BookRepository;
import me.lukegs7.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(UUID id) {
        return bookRepository.findById(id).orElse(null);
    }
}
