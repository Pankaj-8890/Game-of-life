package org.example;

import java.util.Arrays;
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

    public boolean checkAlive() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (newBoard[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public String startGame() {

        Scanner scanner = new Scanner(System.in);
        int generations = 0;
        while (!checkAlive()) {

            int[][] currentBoard = Arrays.copyOf(newBoard, newBoard.length);
            System.out.println("Type 'next' for the next generation or 'quit' to end the game:");
            String choice = scanner.next();

            switch (choice) {
                case "quit":
                    System.out.println("Quitting the game!");
                    return "game has ended";
                case "next":
                    System.out.println("Generation " + (generations + 1) + ":");
                    generations++;
                    displayBoard();
                    updateBoard();
                    if (Arrays.deepEquals(currentBoard, newBoard)) {
                        return "boards are same";
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Type 'next' or 'quit'.");
            }
        }

        return "All cells are dead. The game has ended.";
    }

    private void updateBoard() {
        int[][] nextGeneration = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);

                if (newBoard[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextGeneration[i][j] = 0;
                    } else {
                        nextGeneration[i][j] = 1;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        nextGeneration[i][j] = 1;
                    }
                }
            }
        }

        newBoard = nextGeneration;
    }

    private int countLiveNeighbors(int x, int y) {
        int count = 0;

        return count;
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
