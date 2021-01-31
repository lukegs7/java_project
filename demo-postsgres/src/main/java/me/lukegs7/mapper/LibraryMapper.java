package me.lukegs7.mapper;

import me.lukegs7.dao.entity.Library;
import me.lukegs7.dto.LibraryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface LibraryMapper extends IEntityMapper<LibraryDto, Library> {

    // @Mapping(source = "books", target = "bookDtos")
    @Override
    LibraryDto toDto(final Library library);

    @Override
    Library toEntity(final LibraryDto libraryDto);
}
