package com.alclabs.auditoria.service;

import com.alclabs.auditoria.model.Person;
import com.alclabs.auditoria.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public ResponseEntity<Person> store(@RequestBody Person nuevaPersona,
                                        UriComponentsBuilder ucb) {
        //guardar la persona.
        Person personSaved = personRepository.save(nuevaPersona);

        URI uriPerson = ucb
                .path("api/persons/{id}")
                .buildAndExpand(personSaved.getId())
                .toUri();
        //return ResponseEntity.created(uriPerson).build();
        return ResponseEntity.created(uriPerson).body(personSaved);

    }


    public ResponseEntity<?> update(@RequestBody Person personActualizado, @PathVariable Long id) {

        return ResponseEntity.ok(personRepository.findById(id)
                .map(person -> {
                    person.setNames(personActualizado.getNames());
                    person.setAge(personActualizado.getAge());

                    personRepository.save(person);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> {
                    personRepository.save(personActualizado);
                    return ResponseEntity.ok(personActualizado);
                }));
    }

    public ResponseEntity<Person> findById(@PathVariable Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return ResponseEntity.ok(person.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
