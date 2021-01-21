package me.lukegs7.springboot.mapstruct.dao.repository;

import me.lukegs7.springboot.mapstruct.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IBookRepository extends JpaRepository<Book, UUID> {
}
