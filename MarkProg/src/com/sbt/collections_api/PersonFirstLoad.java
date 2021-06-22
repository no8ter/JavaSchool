package com.sbt.collections_api;

import java.util.*;

// new Person(1L, "Байда Илья Вадимович", "79185551234", Segment.MASS)
// new Person(2L, "Истамов Аскар Зохитович", "79185551219", Segment.MASS)
// new Person(3L, "Кириловский Сергей Владимирович", "79185551232", Segment.MASS)
// new Person(5L, "Коджаев Шамиль Амил оглы", "79185551231", Segment.MASS)
// new Person(4L, "Нешин Антон Сергеевич", "79185551230", Segment.MASS)
// new Person(6L, "Орловский Николай Михайлович", "79185551221", Segment.VIP)
// new Person(7L, "Павлов Иван Геннадьевич", "79185551228", Segment.MASS)
// new Person(8L, "Романюта Александр Сергеевич", "79185551227", Segment.MASS)
// new Person(9L, "Комягин Денис Михайлович", "79185551226", Segment.MASS)
// new Person(9L, "Комягин Денис Михайлович", "79185551226", Segment.MASS)
// new Person(10L, "Чернявский Александр Игоревич", "79185551225", Segment.VIP)
// new Person(11L, "Шмалько Светлана Григорьевна", "79185551224", Segment.MASS)
// new Person(12L, "Малеванный Михаил Сергеевич", "79185551223", Segment.MASS)
// new Person(13L, "Малахова Елена Александровна", "79185551222", Segment.MASS)
// new Person(14L, "Плешаков Владимир Владимирович", "79185551229", Segment.MASS)
// new Person(15L, "Жовнир Екатерина Юрьевна", "79185551220", Segment.MASS)
// new Person(16L, "Смолянинова Дарья Дмитриевна", "79185551233", Segment.VIP)

// init
// print

public class PersonFirstLoad {

    public static void init(Collection<Person> link) {
        link.add(new Person(1L, "Байда Илья Вадимович", "79185551234", Segment.MASS));
        link.add(new Person(2L, "Истамов Аскар Зохитович", "79185551219", Segment.MASS));
        link.add(new Person(3L, "Кириловский Сергей Владимирович", "79185551232", Segment.MASS));
        link.add(new Person(5L, "Коджаев Шамиль Амил оглы", "79185551231", Segment.MASS));
        link.add(new Person(4L, "Нешин Антон Сергеевич", "79185551230", Segment.MASS));
        link.add(new Person(6L, "Орловский Николай Михайлович", "79185551221", Segment.VIP));
        link.add(new Person(7L, "Павлов Иван Геннадьевич", "79185551228", Segment.MASS));
        link.add(new Person(8L, "Романюта Александр Сергеевич", "79185551227", Segment.MASS));
        link.add(new Person(9L, "Комягин Денис Михайлович", "79185551226", Segment.MASS));
        link.add(new Person(9L, "Комягин Денис Михайлович", "79185551226", Segment.MASS));
        link.add(new Person(10L, "Чернявский Александр Игоревич", "79185551225", Segment.VIP));
        link.add(new Person(11L, "Шмалько Светлана Григорьевна", "79185551224", Segment.MASS));
        link.add(new Person(12L, "Малеванный Михаил Сергеевич", "79185551223", Segment.MASS));
        link.add(new Person(13L, "Малахова Елена Александровна", "79185551222", Segment.MASS));
        link.add(new Person(14L, "Плешаков Владимир Владимирович", "79185551229", Segment.MASS));
        link.add(new Person(15L, "Жовнир Екатерина Юрьевна", "79185551220", Segment.MASS));
        link.add(new Person(16L, "Смолянинова Дарья Дмитриевна", "79185551233", Segment.VIP));
    }

    public static void print(Collection<Person> link) {
        Queue<Person> temp = new PriorityQueue<>();
        for (Person p : link) {
            System.out.println(p);
        }
    }
   
}
