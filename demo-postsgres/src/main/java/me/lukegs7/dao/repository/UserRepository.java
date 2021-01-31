package me.lukegs7.dao.repository;

import me.lukegs7.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select u from User u where u.username=:username")
    User findByUsername(String username);
}
