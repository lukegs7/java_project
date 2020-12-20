package com.example.demo.repoistory;

import com.example.demo.model.dto.UserDTO;
import com.example.demo.model.po.Person;
import jdk.nashorn.internal.runtime.options.Option;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void deleteById() {
        List<Person> personList1 = personRepository.findAll();
        System.out.println(personList1);
        personRepository.deleteById(1L);
        List<Person> personList2 = personRepository.findAll();
        System.out.println(personList2);
    }

    @Test
    public void savePerson() {
        Person geshuai = new Person("tom", 1112);
        personRepository.save(geshuai);
        List<Person> personList = personRepository.findAll();
        System.out.println(personList);
    }

    @Test
    public void modifyPerson() {
        Person dd = new Person("Lili", 12);
        Person savedPerson = personRepository.save(dd);
        savedPerson.setAge(100);
        personRepository.save(dd);
        System.out.println(personRepository.findByNameCustomeQuery("Lili"));
    }

    @Test
    public void findByAgeGreaterThan() {
        List<Person> personList = personRepository.findByAgeGreaterThan(90);
        System.out.println(personList);
    }

    @Test
    public void updateAgeById() {
        Optional<Person> person = personRepository.findById(2L);
        if (person != null) {
            System.out.println("before update" + person);
            personRepository.updateAgeById(99, 2L);
            Optional<Person> person1 = personRepository.findById(2L);
            System.out.println("after update" + person1);
        }
    }
    @Test
    public void getUserInfo() {
        Optional<UserDTO> user = personRepository.getUserInformation(2L);
        System.out.println(user);
    }
}