package me.lukegs7.springboot.mapstruct.dto.mapper;


import me.lukegs7.springboot.mapstruct.dao.entity.Book;
import me.lukegs7.springboot.mapstruct.dto.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", uses = {LibraryMapper.class})
public interface BookMapper extends IEntityMapper<BookDTO, Book> {

    @Mapping(source="library.id", target="libraryId")
    BookDTO toDto(final Book book);

    List<BookDTO> toDto(final List<Book> book);

    @Mapping(source="libraryId", target="library")
    Book toEntity(final BookDTO bookDTO);

    List<Book> toEntity(final List <BookDTO> bookDTOs);

    default Book fromId(final UUID id) {

        if (id == null) {
            return null;
        }

        final Book book=new Book();
        book.setId(id);

        return book;
    }
}
