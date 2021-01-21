package me.lukegs7.springboot.mapstruct.controller;

import me.lukegs7.springboot.mapstruct.dto.LibraryDTO;
import me.lukegs7.springboot.mapstruct.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @GetMapping("")
    public List<LibraryDTO> getAllLibraries() {
        return libraryService.findAll();
    }
}
