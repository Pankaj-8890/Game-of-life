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

    private boolean checkAlive() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (newBoard[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void startGame() {

        Scanner scanner = new Scanner(System.in);
        int generations = 0;

        while (!checkAlive()) {
            System.out.println("Type 'next' for the next generation or 'quit' to end the game:");
            String choice = scanner.next();

            switch (choice) {
                case "quit":
                    System.out.println("Quitting the game!");
                    return;
                case "next":
                    System.out.println("Generation " + (generations + 1) + ":");
                    generations++;
                    displayBoard();
                    updateBoard();
                    break;
                default:
                    System.out.println("Invalid choice. Type 'next' or 'quit'.");
            }
        }

        System.out.println("All cells are dead. The game has ended.");

    }

    private void updateBoard() {

    }

    private void displayBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(newBoard[i][j] == 1 ? "■ " : "□ ");
            }
            System.out.println();
        }
        System.out.println();
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

        game.startGame();
    }


}
