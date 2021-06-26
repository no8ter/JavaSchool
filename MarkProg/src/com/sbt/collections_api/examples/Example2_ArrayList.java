package com.sbt.collections_api.examples;

import com.sbt.collections_api.Person;
import com.sbt.collections_api.PersonFirstLoad;
import com.sbt.collections_api.Segment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example2_ArrayList {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        System.out.println("-1.-------------------------------");
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);
        // инициализируйте вызовом PersonFirstLoad.init()
        // выведите содержимое вызовом PersonFirstLoad.print()
        // проанализируйте порядок элементов

        System.out.println("-2.-------------------------------");
        System.out.println(persons.get(5));
        // выведите элемент ArrayList с индексом 5

        System.out.println("-3.-------------------------------");
        System.out.println(persons.contains(new Person(10L, "Бирюков Виктор Валерьевич", "79185551234", Segment.MASS)));
        // проверьте наличие в ArrayList клиента new Person(10L, "Бирюков Виктор Валерьевич", "79185551234", Segment.MASS)

        System.out.println("-4.-------------------------------");
        System.out.println(persons.contains(new Person(20L, "Египетская Зина Кукринкинович", "79185551237", Segment.MASS)));
        // проверьте наличие в ArrayList клиента new Person(20L, "Египетская Зина Кукринкинович", "79185551237", Segment.MASS)

        System.out.println("-5.-------------------------------");
        System.out.println(persons.indexOf(new Person(7L, "Павлов Иван Геннадьевич", "79185551228", Segment.MASS)));
        // выведите индекс в ArrayList клиента new Person(7L, "Павлов Иван Геннадьевич", "79185551228", Segment.MASS)

        System.out.println("-6.-------------------------------");
        PersonFirstLoad.print(persons);
        System.out.println("Sorting...");
        Collections.sort(persons);
        PersonFirstLoad.print(persons);
        // отстортируйте клиентов в ArrayList по ФИО и выведите результат

        System.out.println("-7.-------------------------------");

        for (int i = 0; i < persons.size(); i++) {
            Person p = persons.get(i);
            if (p.getSegment() == Segment.MASS) {
                persons.remove(i);
                i--;
            }
        }
        PersonFirstLoad.print(persons);
        // устраните из ArrayList всех клиентов из сегмента Segment.MASS и выведите результат

        System.out.println("-8.-------------------------------");
        // Попробуйте получить элемент ArrayList с несуществующим индексом (например, 100), проанализируйте результат
        System.out.println(persons.get(100));
    }
}
