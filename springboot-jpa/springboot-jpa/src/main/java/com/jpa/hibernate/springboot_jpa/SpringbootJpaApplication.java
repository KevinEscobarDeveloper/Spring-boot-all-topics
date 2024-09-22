package com.jpa.hibernate.springboot_jpa;

import com.jpa.hibernate.springboot_jpa.dto.PersonDto;
import com.jpa.hibernate.springboot_jpa.entities.Person;
import com.jpa.hibernate.springboot_jpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        personalizedQueriesDistinct();
    }

    @Transactional(readOnly = true)
    public void personalizedQueries(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================== Consulta solo el nombre por el id =====================");
        System.out.println("Ingrese el id para el nombre:");
        Long id = scanner.nextLong();
        String name = repository.getNameById(id);
        System.out.println(name);
        Long idDb = repository.getIdById(id);
        System.out.println(idDb);
        String fullName = repository.getFullNameById(id);
        System.out.println(fullName);
    }

    @Transactional(readOnly = true)
    public void personalizedQueries2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================== Consulta por objeto persona y lenguaje de programacion =====================");
        List<Object[]> personsRegs = repository.findAllMixPerson();

        personsRegs.forEach(reg -> {
            System.out.println("Programming Language= " + reg[1] +", person =" +reg[0]);
        });

        System.out.println("Consulta que puebla y devuelve objeto entity de una instancia personalizada");
        List<Person> persons = repository.findAllPersonalizedObjectPerson();
        persons.forEach(System.out::println);

        System.out.println("Consulta que puebla y devuelve objeto dto de una clase personalizada");
        List<PersonDto> personDtos = repository.findAllPersonDto();
        personDtos.forEach(System.out::println);
    }

    @Transactional(readOnly = true)
    public void personalizedQueriesDistinct(){
        System.out.println("Consultas con nombres de personas");
        List<String> names = repository.findAllNames();
        names.forEach(System.out::println);

        System.out.println("====================== Consultas con nombres unicos de personas =================");
        names = repository.findAllNamesDistinct();
        names.forEach(System.out::println);
    }

    @Transactional
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id de la persona: ");
        Long id = scanner.nextLong();

        Optional<Person> optionalPerson = repository.findById(id);

        optionalPerson.ifPresent(person -> {
            System.out.println(person);
            System.out.println("Ingrese el lenguaje de programacion: ");
            String programmingLanguage = scanner.next();
            person.setProgrammingLanguage(programmingLanguage);
            Person personDb = repository.save(person);
            System.out.println(personDb);
        });
        scanner.close();
    }

    @Transactional
    public void delete() {
        repository.findAll().forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id de la persona: ");
        Long id = scanner.nextLong();
        repository.deleteById(id);

        repository.findAll().forEach(System.out::println);
    }

    @Transactional
    public void delete2() {
        repository.findAll().forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id de la persona: ");
        Long id = scanner.nextLong();
        Optional<Person> optionalPerson = repository.findById(id);
        optionalPerson.ifPresentOrElse(person -> repository.delete(person), () -> System.out.println("Lo sentimos no existe la perosna con ese id"));

        repository.findAll().forEach(System.out::println);
    }

    @Transactional(readOnly = true)
    public void findOne() {
        Person person = null;
        Optional<Person> optionalPerson = repository.findByNameContaining("hn");
        if (optionalPerson.isPresent()) {
            person = optionalPerson.get();
        }
        System.out.println(person);
    }

    @Transactional
    public void create() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String lastName = scanner.next();
        String programmingLanguage = scanner.next();
        scanner.close();
        Person person = new Person(null, name, lastName, programmingLanguage);
        Person personNew = repository.save(person);
        System.out.println(personNew);
        repository.findById(personNew.getId()).ifPresent(System.out::println);
    }

    public void list() {
        //List<Person> persons = (List<Person>) repository.buscarByProgrammingLanguage("Java");
        //List<Person> persons = (List<Person>) repository.findAll();
        List<Object[]> personValues = repository.obtenerPersonData();
        personValues.stream().forEach(person -> System.out.println(person[0] + " Es expertoe en " + person[1]));
    }
}
