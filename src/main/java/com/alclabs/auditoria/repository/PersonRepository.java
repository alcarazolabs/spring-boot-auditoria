package com.alclabs.auditoria.repository;

import com.alclabs.auditoria.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
