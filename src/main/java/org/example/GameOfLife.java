package org.example;

import java.util.Random;
import java.util.Scanner;

public class GameOfLife {
    private int row;
    private int column;
    private int seedingLive;
    private int[][] newBoard;

    public GameOfLife(int row, int column, int seedingLive) {
        this.row = row;
        this.column = column;
        this.seedingLive = seedingLive;
        initializeBoard();
    }

    private void initializeBoard() {
        Board board = new Board(row, column, seedingLive);
        this.newBoard = board.getBoard();
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the dimension for row");
        int row = scanner.nextInt();

        System.out.println("Enter the dimension for column");
        int column = scanner.nextInt();

        System.out.println("Enter the seeding Percentage for live cells");
        int seedingLive = scanner.nextInt();

        GameOfLife game = new GameOfLife(row, column, seedingLive);
    }


}
