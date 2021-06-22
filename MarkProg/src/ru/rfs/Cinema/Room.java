package ru.rfs.Cinema;

import java.util.Scanner;

public class Room {

    int w = 0;
    int h = 0;
    String[][] room;
    int emptySeats;
    Scanner scan = new Scanner(System.in);

    void createRoom(int iw, int ih) {
        room = new String[h][w];
        w = iw;
        h = ih;
        room = new String[h][w];
        emptySeats = w * h;
        for (int i = 0; i<h; i++) {
            for (int j = 0; j<w; j++){
                room[i][j] = "E";
            }
        }
    }

    void sellSeat() {
        System.out.print("Enter seat address: ");
        int pw = scan.nextInt();
        int ph = scan.nextInt();
        takeSeat(pw, ph);
    }

    private void takeSeat(int pw, int ph){
        checkSeatPos(pw, ph);
        seatIsEmpty(pw, ph);
        System.out.println("Cost of ticket: " + costCheck(pw, ph));
        room[pw-1][ph-1] = "S";
        emptySeats--;
        System.out.println(showRoom());
        soldOut();
    }

    private void checkSeatPos(int pw, int ph) {
        if (pw > w || ph > h) {
            throw new ArrayIndexOutOfBoundsException("Invalid address of seat!");
        }
    }

    private void soldOut() {
        if (emptySeats == 0) {
            throw new ArrayIndexOutOfBoundsException("Sold Out!");
        }
    }

    private void seatIsEmpty(int pw, int ph){
        if (room[pw-1][ph-1] != "E") {
            throw new ArrayIndexOutOfBoundsException("This seat is taken already");
        }
    }

    String showRoom() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i<h; i++){
            for (int j = 0; j<w; j++){
                temp.append(room[i][j] + " ");
            }
            temp.append("\n");
        }
        return temp.toString();
    }

    int costCheck(int pw, int ph){
        if (emptySeats < 60) {
            return 10;
        } else {
            return 8;
        }
    }

}