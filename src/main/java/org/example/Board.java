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

        if (rows <= 0 || columns <= 0 || !(board instanceof Cell[][])) {
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
    public String startGame() throws GenerationNotPossible {
        int generation = 0;
        while (!checkAllDead()) {
            Cell[][] currentBoard = board;
            System.out.println("Generation " + (generation + 1) + ":");
            generation++;
            displayBoard();
            nextGenerationBoard();

            if (Compare(currentBoard,board)) {
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
                int liveNeighbors = currentCell != null ? currentCell.countLiveNeighbors(board, i, j) : 0;

                if (currentCell != null && currentCell.isAlive()) {
                    nextGeneration[i][j] = currentCell.getNextGenerationCell(liveNeighbors);
                } else {
                    if (liveNeighbors == 3) {
                        nextGeneration[i][j] = new Cell(1);
                    }
                }
            }
        }
        board = nextGeneration;
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
