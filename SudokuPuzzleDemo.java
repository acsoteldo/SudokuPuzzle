//Andrea Soteldo
//COSC-2430.501
//Project2
//29Apr2021
//Sudoku
package college;

import java.util.Scanner;

public class SudokuPuzzleDemo {
    public static void setPuzzle(SudokuPuzzle setValue) {
    	setValue.addInitial(0, 0, 1);
    	setValue.addInitial(0, 1, 2);
    	setValue.addInitial(0, 2, 3);
    	setValue.addInitial(0, 3, 4);
    	setValue.addInitial(0, 4, 9);
    	setValue.addInitial(0, 5, 7);
    	setValue.addInitial(0, 6, 8);
    	setValue.addInitial(0, 7, 6);
    	setValue.addInitial(0, 8, 5);
    	setValue.addInitial(1, 0, 4);
    	setValue.addInitial(1, 1, 5);
    	setValue.addInitial(1, 2, 9);
    	setValue.addInitial(2, 0, 6);
    	setValue.addInitial(2, 1, 7);
    	setValue.addInitial(2, 2, 8);
    	setValue.addInitial(3, 0, 3);
    	setValue.addInitial(3, 4, 1);
    	setValue.addInitial(4, 0, 2);
    	setValue.addInitial(5, 0, 9);
    	setValue.addInitial(5, 5, 5);
    	setValue.addInitial(6, 0, 8);
    	setValue.addInitial(7, 0, 7);
    	setValue.addInitial(8, 0, 5);
    	setValue.addInitial(8, 3, 9);
    }
    public static void main(String[] args) {
        System.out.println("Sudoku Game: ");
        SudokuPuzzle puzzle = new SudokuPuzzle();
        setPuzzle(puzzle);
        System.out.print("The puzzle is: \n" + puzzle);
        Scanner keyboard = new Scanner(System.in);
        boolean solving = true;
        while (solving) {
            System.out.println("What would you like to do?");
            System.out.println("Clear puzzle(C) Set a square (S) Get possible values (G) Quit (Q)");
            String move = keyboard.next();
            move = move.toLowerCase();

            if (move.equals("q")) {
                System.out.println("Game Over.");
                solving = false;
                } 
            else if (move.equals("g")) {
                System.out.println("Which row (1-9) and column (1-9) do you want to get values for?");
                int row = keyboard.nextInt() - 1;
                int col = keyboard.nextInt() - 1;
                boolean allowed[] = puzzle.getAllowedValues(row, col);
                System.out.print("Allowed values are: ");
                for (int i = 0; i < 9; i++) {
                    if (allowed[i])
                        System.out.print((i + 1) + " ");
                }
                System.out.println();
            } 
            else if (move.equals("s")) {
                System.out.println("Which row (1-9) and column (1-9) do you want to change?");
                int row = keyboard.nextInt() - 1;
                int col = keyboard.nextInt() - 1;
                System.out.println("What should the value (1-9) be?");
                int value = keyboard.nextInt();
                puzzle.addGuess(row, col, value);
                } 
            else if (move.equals("c")) {
                puzzle.reset();
            }
            System.out.print("The puzzle is now: \n" + puzzle);

            if (!puzzle.checkPuzzle())
                System.out.println("Not an allowed value. Check again.");
            else if (puzzle.isFull())
                System.out.println("Puzzle is full.");
        }
        keyboard.close();
    }
}