package com.example.demo.repoistory;

import com.example.demo.model.dto.UserDTO;
import com.example.demo.model.po.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select p from Person p where p.age>:age")
    List<Person> findByAgeGreaterThan(int age);

    @Query("select p from Person p where p.name=:name")
    Optional<Person> findByNameCustomeQuery(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("update Person p set p.age=:age where p.id=:id")
    void updateAgeById(Integer age, Long id);

    @Query(value="select new com.example.demo.model.dto.UserDTO(p.name,p.age,c.companyName,s.name) from Person p left join Company c " +
            "on c.id=p.companyId left join School s on s.id=p.schoolId where p.id=:personId")
    Optional<UserDTO> getUserInformation(@Param("personId") Long personId);
}
