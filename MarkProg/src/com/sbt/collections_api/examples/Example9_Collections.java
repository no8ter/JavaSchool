package com.sbt.collections_api.examples;

import com.sbt.collections_api.Person;
import com.sbt.collections_api.PersonFirstLoad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Example9_Collections {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        System.out.println("-1.-------------------------------");
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);
        // инициализируйте вызовом PersonFirstLoad.init()
        // выведите содержимое вызовом PersonFirstLoad.print()
        // проанализируйте порядок элементов

        System.out.println("-2.-------------------------------");
        Collections.sort(persons);
        PersonFirstLoad.print(persons);

        // отсортируйте содержимое в естественном порядке вызовом Collections.sort(List)
        // выведите содержимое вызовом PersonFirstLoad.print()
        // проанализируйте порядок элементов

        System.out.println("-3.-------------------------------");
        Collections.reverse(persons);
        PersonFirstLoad.print(persons);
        // обратите порядок клиентов вызовом Collections.reverse(List)
        // выведите содержимое вызовом PersonFirstLoad.print()
        // проанализируйте порядок элементов

        System.out.println("-4.-------------------------------");
        Comparator<Person> comp = new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getPhoneNumber().compareTo(t1.getPhoneNumber());
            }
        };
        Collections.sort(persons, comp);
        PersonFirstLoad.print(persons);
        // отсортируйте содержимое по телефонным номерам вызовом Collections.sort(List, Comparator)
        // выведите содержимое вызовом PersonFirstLoad.print()
        // проанализируйте порядок элементов


        System.out.println("-5.-------------------------------");
        comp = new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getId().compareTo(t1.getId());
            }
        };
        System.out.println(Collections.min(persons));
        System.out.println(Collections.max(persons, comp));
        // выведите минимальный по естественному порядку элемент вызовом Collections.min(List)
        // и максимальный по индексу элемент вызовом Collections.max(List, Comparator)


    }
}
