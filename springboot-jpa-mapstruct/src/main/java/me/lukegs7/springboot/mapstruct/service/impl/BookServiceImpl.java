package me.lukegs7.springboot.mapstruct.service.impl;

import me.lukegs7.springboot.mapstruct.dao.entity.Book;
import me.lukegs7.springboot.mapstruct.dao.repository.IBookRepository;
import me.lukegs7.springboot.mapstruct.dto.BookDTO;
import me.lukegs7.springboot.mapstruct.dto.mapper.BookMapper;
import me.lukegs7.springboot.mapstruct.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    IBookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookDTO> findAllBooks() {
        return bookMapper.toDto(bookRepository.findAll());
    }

    @Override
    public BookDTO findById(UUID id) {
        Optional<Book> b = bookRepository.findById(id);
        return b.map(book -> bookMapper.toDto(book)).orElse(null);
    }
}
