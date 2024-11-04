package com.alclabs.auditoria.controller;

import com.alclabs.auditoria.model.Person;
import com.alclabs.auditoria.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> store(@RequestBody Person person, UriComponentsBuilder ucb){
        return personService.store(person, ucb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Person person, @PathVariable Long id) {
        return personService.update(person, id);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        return personService.findById(id);
    }


}
