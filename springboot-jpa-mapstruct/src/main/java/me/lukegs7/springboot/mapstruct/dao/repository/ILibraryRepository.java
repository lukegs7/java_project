package me.lukegs7.springboot.mapstruct.dao.repository;

import me.lukegs7.springboot.mapstruct.dao.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ILibraryRepository extends JpaRepository<Library, UUID> {

}
