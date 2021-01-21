package me.lukegs7.springboot.mapstruct.service;


import me.lukegs7.springboot.mapstruct.dto.BookDTO;

import java.util.List;
import java.util.UUID;

public interface BookService {
    List<BookDTO> findAllBooks();

    BookDTO findById(UUID id);
}
