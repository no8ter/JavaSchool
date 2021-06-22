package com.sbt.collections_api.examples;

import com.sbt.collections_api.Person;
import com.sbt.collections_api.PersonFirstLoad;
import com.sbt.collections_api.Segment;

import java.sql.Statement;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Example4_PriorityQueue {
    public static void main(String[] args) {
        Queue<Person> persons = new PriorityQueue<>();
        System.out.println("-1.--------------------------------");
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);
        // инициализируйте вызовом PersonFirstLoad.init()
        // выведите содержимое вызовом PersonFirstLoad.print()
        // проанализируйте порядок элементов

        System.out.println("-2.--------------------------------");
        int size = persons.size();
        for (int i = 0; i < size; i++) {
            System.out.println(persons.poll());
        }
        // последовательно извлеките все элементы из PriorityQueue и проанализируйте порядок извлечения

        System.out.println("-3.--------------------------------");
        Comparator<Person> comp = new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                if (person.getSegment() == t1.getSegment()) {
                    return 0;
                } else if (person.getSegment() != Segment.MASS) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };
        persons = new PriorityQueue<>(11, comp);
        PersonFirstLoad.init(persons);

        size = persons.size();
        for (int i = 0; i < size; i++) {
            System.out.println(persons.poll());
        }
        // сформируйте новый объект PriorityQueue, с использованием внешнего Comparator,
        // который будет отдавать приоритет при извлечении клиентам из сегмента Segment.VIP
        // инициализируйте вызовом PersonFirstLoad.init(persons)
        // последовательно извлеките все элементы из PriorityQueue и проанализируйте порядок извлечения

        System.out.println("-4.--------------------------------");
        PersonFirstLoad.init(persons);
        for (int i = 0; i<20; i++) {
            System.out.println(persons.poll());
        }
        // инициализируйте вызовом PersonFirstLoad.init()
        // попробуйте извлечь 20 элементов
        // проанализируйте результат
    }
}
