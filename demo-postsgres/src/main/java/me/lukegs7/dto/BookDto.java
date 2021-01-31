package me.lukegs7.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BookDto implements Serializable{

    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String author;

    @NotNull
    private LocalDateTime publishedDate;

    private UUID libraryId;
}
