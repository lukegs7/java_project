package me.lukegs7.service.impl;

import me.lukegs7.dao.entity.Library;
import me.lukegs7.dao.repository.LibraryRepository;
import me.lukegs7.service.LibraryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {

    @Resource
    private LibraryRepository libraryRepository;

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public Library findById(UUID id) {
        return libraryRepository.findById(id).orElse(null);
    }
}

