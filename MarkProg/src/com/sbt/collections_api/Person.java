package com.sbt.collections_api;

import java.util.Objects;

/**
 * Учётная запись клиента
 */
public class Person implements Comparable<Person>{
    /**
     * Идентификатор
     */
    private Long id;

    /**
     * ФИО
     */
    private String name;

    /**
     * Телефонный номер
     */
    private String phoneNumber;

    /**
     * Сегмент обслуживания
     */
    private Segment segment;

    public Person(Long id, String name, String phoneNumber, Segment segment) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.segment = segment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", segment=" + segment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) && name.equals(person.name) && phoneNumber.equals(person.phoneNumber) && segment == person.segment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, segment);
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareToIgnoreCase(person.name);
    }
}

