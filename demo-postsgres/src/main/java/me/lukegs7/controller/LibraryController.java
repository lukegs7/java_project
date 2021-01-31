package me.lukegs7.controller;

import io.swagger.annotations.Api;
import me.lukegs7.dto.LibraryDto;
import me.lukegs7.mapper.LibraryMapper;
import me.lukegs7.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/library")
@Api(value = "图书馆管理")
public class LibraryController {

    @Resource
    private LibraryService libraryService;
    @Resource
    private LibraryMapper libraryMapper;

    @GetMapping
    public List<LibraryDto> getAllLibraries() {
        return libraryMapper.toDto(libraryService.findAll());
    }
}
