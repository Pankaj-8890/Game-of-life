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

    public Board(int row, int column, int seedingLive) throws InvalidArguments {
        if (row <= 0 || column <= 0 || seedingLive < 0) {
            throw new InvalidArguments("Values must be greater than 0");
        }

        this.row = row;
        this.column = column;
        this.seedingLive = seedingLive;
        initializeBoard();
    }

    public Board(Integer rows, Integer columns, Cell[][] board) throws IllegalStateException {

        if (rows <= 0 || columns <= 0 || board == null) {
            throw new IllegalStateException("Invalid data provided...");
        }
        this.row = rows;
        this.column = columns;
        this.board = board;

    }

    private void initializeBoard() {
        Cell[][] newBoard = new Cell[row][column];
        Random random = new Random();

        double noOfSeededLives = floor((row * column) * seedingLive * 0.01);
        int noOfSeededLive = (int) noOfSeededLives;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                newBoard[i][j] = new Cell(CellType.DEAD);
            }
        }

        while (noOfSeededLive > 0) {
            int i = random.nextInt(row);
            int j = random.nextInt(column);

            if (!newBoard[i][j].isAlive()) {
                newBoard[i][j] = new Cell(CellType.ALIVE);
                noOfSeededLive--;
            }
        }
        this.board = newBoard;
    }

    public boolean checkAllDead() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j]!=null && board[i][j].isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean Compare(Cell[][] currentBord,Cell[][] board){
        for(int i=0;i<currentBord.length;i++){
            for(int j=0;j<currentBord.length;j++){
                if(currentBord[i][j] != null && !(currentBord[i][j].equals(board[i][j])))return false;
            }
        }
        return true;
    }
    public void startGame() throws GenerationNotPossible {
        int generation = 0;
        while (!checkAllDead()) {
            Cell[][] currentBoard = board;
            System.out.println("Generation " + (generation + 1) + ":");
            generation++;
            displayBoard();
            nextGenerationBoard();

            if (Arrays.deepEquals(currentBoard, board)) {
                throw new GenerationNotPossible("Can't generate the next generation");
            }
        }
        throw new GenerationNotPossible("Can't generate the next generation");
    }
    private void nextGenerationBoard() {
        Cell[][] nextGeneration = new Cell[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Cell currentCell = board[i][j];
                int liveNeighbors = currentCell != null ? countLiveNeighbors(i, j) : 0;

                if (currentCell != null && currentCell.isAlive()) {
                    nextGeneration[i][j] = currentCell.getNextGenerationCell(liveNeighbors);
                } else {
                    if (liveNeighbors == 3) {
                        nextGeneration[i][j] = new Cell(CellType.ALIVE);
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

            if (neighbourX >= 0 && neighbourX < board.length && neighbourY >= 0 && neighbourY < board[0].length
                    && board[neighbourX][neighbourY] != null && board[neighbourX][neighbourY].isAlive()) {
                count++;
            }
        }
        return count;
    }

    public void displayBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(board[i][j] != null && board[i][j].isAlive()){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean equals(Board board) {

        return this.row == board.row && this.column == board.column && Arrays.deepEquals(this.board, board.board);

    }

}
