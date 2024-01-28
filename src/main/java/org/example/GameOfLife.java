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

    public boolean checkAllDead() {
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

        int generation = 0;
        while (!checkAllDead()) {
            int[][] currentBoard = Arrays.copyOf(newBoard, newBoard.length);
            System.out.println("Generation " + (generation + 1) + ":");
            generation++;
            displayBoard();
            updateBoard();
            if (Arrays.deepEquals(currentBoard, newBoard)) {
                return "Can't generate next generation";
            }
        }
        return "All cells are dead. The game has ended.";
    }

    public void updateBoard() {
        int[][] nextGeneration = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);
                if (newBoard[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextGeneration[i][j] = 0;
                    }else{
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
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < row && newY >= 0 && newY < column) {
                count += newBoard[newX][newY];
            }
        }

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
