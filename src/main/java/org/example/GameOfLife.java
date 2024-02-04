package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameOfLife {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the dimension for row");
        int row = scanner.nextInt();

        System.out.println("Enter the dimension for column");
        int column = scanner.nextInt();

        System.out.println("Enter the seeding Percentage for live cells");
        int seedingLive = scanner.nextInt();

        Board board = new Board(row,column,seedingLive);
        board.startGame();
    }


}
