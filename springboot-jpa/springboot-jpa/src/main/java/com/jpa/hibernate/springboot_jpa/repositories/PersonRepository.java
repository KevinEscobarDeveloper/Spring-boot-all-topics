package com.jpa.hibernate.springboot_jpa.repositories;

import com.jpa.hibernate.springboot_jpa.dto.PersonDto;
import com.jpa.hibernate.springboot_jpa.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select p.name from Person p where p.id=?1")
    String getNameById(Long id);

    @Query("SELECT CONCAT(p.name, ' ', p.lastName) AS fullname FROM Person p WHERE p.id = ?1")
    String getFullNameById(Long id);


    @Query("select p.id from Person p where p.id=?1")
    Long getIdById(Long id);

    List<Person> findByProgrammingLanguage(String programmingLanguaje);

    @Query("select p from Person p where p.programmingLanguage=?1 ")
    List<Person> buscarByProgrammingLanguage(String programmingLanguaje);

    @Query("select p.name, p.programmingLanguage from Person p ")
    List<Object[]> obtenerPersonData();

    @Query("select p from Person p where p.id=?1")
    Optional<Person> findOne(Long id);
    @Query("select p from Person p where p.name=?1")
    Optional<Person> findOneName(String name);
    @Query("select p from Person p where p.name like %?1%")
    Optional<Person> findOneLikeName(String name);

    @Query("select p, p.programmingLanguage from Person p")
    List<Object[]> findAllMixPerson();

    @Query("select new Person(p.name, p.lastName) from Person  p")
    List<Person> findAllPersonalizedObjectPerson();

    @Query("select new com.jpa.hibernate.springboot_jpa.dto.PersonDto(p.name, p.lastName) from Person  p")
    List<PersonDto> findAllPersonDto();


    @Query("select p.name from Person p")
    List<String> findAllNames();

    @Query("select distinct(p.name) from Person p")
    List<String> findAllNamesDistinct();

    Optional<Person> findByNameContaining(String name);

}
