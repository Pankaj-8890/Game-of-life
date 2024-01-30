package org.example;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

import static java.lang.Math.floor;

public class Board {

    private int row;
    private int column;
    private int seedingLive;
    private Cell[][] board;

    public Board(int row, int column, int seedingLive) {
        if (row <= 0 || column <= 0 || seedingLive < 0) {
            throw new IllegalArgumentException("Values must be greater than 0");
        }

        this.row = row;
        this.column = column;
        this.seedingLive = seedingLive;
        initializeBoard();
    }

    public void initializeBoard() {
        Cell[][] newBoard = new Cell[row][column];
        Random random = new Random();

        double noOfSeededLives = floor((row * column) * seedingLive * 0.01);
        int noOfSeededLive = (int) noOfSeededLives;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                newBoard[i][j] = new Cell(0);
            }
        }

        while (noOfSeededLive > 0) {
            int i = random.nextInt(row);
            int j = random.nextInt(column);

            if (!newBoard[i][j].isAlive()) {
                newBoard[i][j] = new Cell(1);
                noOfSeededLive--;
            }
        }
        this.board = newBoard;
    }

    public boolean checkAllDead() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j].isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }

    public String startGame() {
        int generation = 0;
        while (!checkAllDead()) {
            Cell[][] currentBoard = board;
            System.out.println("Generation " + (generation + 1) + ":");
            generation++;
            displayBoard();
            nextGenerationBoard();

            if (currentBoard.equals(board)) {
                System.out.println("equal");
                return "Can't generate the next generation";
            }
        }
        return "All cells are dead. The game has ended.";
    }

    public void nextGenerationBoard() {
        Cell[][] nextGeneration = new Cell[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);
                if (board[i][j] != null && board[i][j].isAlive()) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextGeneration[i][j] = new Cell(0);
                    } else {
                        nextGeneration[i][j] = new Cell(1);
                    }
                } else {
                    if (liveNeighbors == 3) {
                        nextGeneration[i][j] = new Cell(1);
                    }
                }
            }
        }
        board = nextGeneration;
    }

    private int countLiveNeighbors(int x, int y) {
        int count = 0;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int[] dir : directions) {
            int neighbourX = x + dir[0];
            int neighbourY = y + dir[1];

            if (neighbourX >= 0 && neighbourX < row && neighbourY >= 0 && neighbourY < column
                    && board[neighbourX][neighbourY] != null && board[neighbourX][neighbourY].isAlive()) {
                count++;
            }
        }
        return count;
    }

    public void displayBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(board[i][j].isAlive()){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
