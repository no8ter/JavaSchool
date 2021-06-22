package com.sbt.collections_api.examples;

import com.sbt.collections_api.Person;
import com.sbt.collections_api.PersonFirstLoad;
import com.sbt.collections_api.Segment;

import java.util.LinkedList;
import java.util.List;

public class Example3_LinkedList {
    public static void main(String[] args) {
        LinkedList<Person> persons = new LinkedList<>();
        System.out.println("-1.-------------------------------");
        PersonFirstLoad.init((List<Person>) persons);
        PersonFirstLoad.print(persons);
        // инициализируйте вызовом PersonFirstLoad.init()
        // выведите содержимое вызовом PersonFirstLoad.print()
        // проанализируйте порядок элементов

        System.out.println("-2.-------------------------------");
        System.out.println(persons.get(5));
        // выведите элемент LinkedList с индексом 5

        System.out.println("-3.-------------------------------");
        System.out.println(persons.contains(new Person(10L, "Бирюков Виктор Валерьевич", "79185551234", Segment.MASS)));
        // проверьте наличие в LinkedList клиента new Person(10L, "Бирюков Виктор Валерьевич", "79185551234", Segment.MASS)

        System.out.println("-4.-------------------------------");
        for (int i = 0; i < 4; i++) {
            System.out.println(persons.poll());
        }
        System.out.println("Removed");
        PersonFirstLoad.print(persons);
        // выведите 4 элемента LinkedList с извлечением
        // выведите содержимое LinkedList вызовом PersonFirstLoad.print()
        // проанализируйте состав элементов

        System.out.println("-5.-------------------------------");
        persons.add(new Person(30L, "Шишкин Кирилл Иванович", "79185551332", Segment.MASS));
        System.out.println(persons.getLast());
        PersonFirstLoad.print(persons);
        // Добавьте в LinkedList клиента new Person(30L, "Шишкин Кирилл Иванович", "79185551332", Segment.MASS)
        // выведите последний элемент LinkedList без извлечения
        // выведите содержимое LinkedList вызовом PersonFirstLoad.print()
        // проанализируйте состав элементов

        System.out.println("-6.-------------------------------");
        for (Person p : persons) {
            System.out.println(p);
        }
        // выведите содержимое LinkedList, используя метод forEach

        System.out.println("-7.-------------------------------");
        System.out.println(persons.pollLast());
        // Выведите последний элемент LinkedList с извлечением

        System.out.println("-8.-------------------------------");
        System.out.println(persons.pollFirst());
        // Выведите первый элемент LinkedList с извлечением
    }
}
