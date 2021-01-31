package me.lukegs7.service;


import me.lukegs7.dao.entity.Library;

import java.util.List;
import java.util.UUID;

public interface LibraryService {
    List<Library> findAll();

    Library findById(UUID id);
}
