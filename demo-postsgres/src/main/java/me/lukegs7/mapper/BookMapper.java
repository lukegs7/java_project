package me.lukegs7.mapper;


import me.lukegs7.dao.entity.Book;
import me.lukegs7.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper extends IEntityMapper<BookDto, Book> {

    // @Mapping(source = "library.id", target = "libraryId")
    @Override
    BookDto toDto(final Book book);

    // @Mapping(source = "libraryId", target = "library")
    @Override
    Book toEntity(final BookDto bookDTO);

    @Override
    List<Book> toEntity(final List<BookDto> bookDtos);
}
