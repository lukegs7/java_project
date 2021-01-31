package me.lukegs7.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class LibraryDto implements Serializable {
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private List<BookDto> bookDtos = new ArrayList<>();
}