package com.sbt.collections_api.examples;

import com.sbt.collections_api.Person;
import com.sbt.collections_api.PersonFirstLoad;

import java.util.*;

public class Example6_TreeSet {
    public static void main(String[] args) {
        Set<Person> persons = new TreeSet<>();
        System.out.println("-1.--------------------------------");
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);
        // инициализируйте вызовом PersonFirstLoad.init()
        // выведите содержимое вызовом PersonFirstLoad.print()
        // проанализируйте порядок элементов

        System.out.println("-2.--------------------------------");
        Comparator<Person> comp = Collections.reverseOrder();
//        Set<Person> persons2 = new TreeSet<Person>(11, comp);
        // сформируйте новый объект TreeSet, с использованием внешнего Comparator,
        // который будет производить сортировку в обратном естественному порядке
        // инициализируйте вызовом PersonFirstLoad.init(persons)
        // последовательно извлеките все элементы из PriorityQueue и проанализируйте порядок извлечения


    }
}
