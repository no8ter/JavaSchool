package ru.rfs.Cinema;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Room room = new Room();
        System.out.print("Enter size of room: ");
        room.createRoom(scan.nextInt(), scan.nextInt());
        System.out.println(room.showRoom().toString());
        while (true){
            try {
                room.sellSeat();
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
