package me.lukegs7.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserDto implements Serializable{

    private UUID id;

    private String name;

    private String author;

    private LocalDateTime publishedDate;

    private UUID libraryId;
}
