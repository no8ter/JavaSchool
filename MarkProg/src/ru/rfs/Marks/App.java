package ru.rfs.Marks;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] marks = new int[count];

        for (int i = 0; i < count; i++) {
            marks[i] = scanner.nextInt();
        }

        int[] countOfMarks = new int[4];
        for (int mark : marks) {
            switch (mark) {
                case (2) :
                    countOfMarks[3]++;
                    break;
                case (3) :
                    countOfMarks[2]++;
                    break;
                case (4) :
                    countOfMarks[1]++;
                    break;
                case (5) :
                    countOfMarks[0]++;
                    break;
            }
        }
        for (int c : countOfMarks) {
            System.out.print(c + " ");
        }
    }
}
