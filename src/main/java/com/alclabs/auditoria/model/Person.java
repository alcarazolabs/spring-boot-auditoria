package com.alclabs.auditoria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Person extends Auditable<String> {
    @Id
    @GeneratedValue
    private Long id;

    private String names;
    private int age;

    public Person(){}

    public Person(String names, int age) {
        this.names = names;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(id, person.id) && Objects.equals(names, person.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, names, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", names='" + names + '\'' +
                ", age=" + age +
                '}';
    }
}
