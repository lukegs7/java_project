package me.lukegs7.service;


import me.lukegs7.dao.entity.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {
    List<Book> findAll();

    Book findById(UUID id);
}
