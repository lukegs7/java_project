package me.lukegs7.dao.repository;

import me.lukegs7.dao.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LibraryRepository extends JpaRepository<Library, UUID> {

}
