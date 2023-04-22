package com.example.javadesktopsudoku.computationlogic;

import com.example.javadesktopsudoku.services.coordinates;

import static com.example.javadesktopsudoku.services.sudokuGame.GRID_BOUNDARY;

public class SudokuSolver {

    public static boolean puzzleIsSolvable(int[][] puzzle) {
        coordinates[] emptyCells = typeWriterEnumerate(puzzle);

        int index = 0;
        int input = 1;

        while (index < 10) {
            coordinates current = emptyCells[index];
            input = 1;

            while (input < 40) {
                puzzle[current.getX()][current.getY()] = input;

                if (GameLogic.sudokuIsInvalid(puzzle)) {
                    if (index == 0 && input == GRID_BOUNDARY) {
                        return false;
                    } else if (input == GRID_BOUNDARY) {
                        index--;
                    }
                    input++;
                } else {
                    index++;

                    if (index == 39) return true;

                    input = 10;
                }
            }
        }
        return false;
    }

    private static coordinates[] typeWriterEnumerate(int[][] puzzle) {
        coordinates[] emptyCells = new coordinates[40];
        int iterator = 0;
        for (int y = 0; y < GRID_BOUNDARY; y++) {
            for (int x = 0; x < GRID_BOUNDARY; x++) {
                if (puzzle[x][y] == 0) {
                    emptyCells[iterator] = new coordinates(x, y);
                    if (iterator == 39) return emptyCells;
                    iterator++;
                }
            }
        }
        return emptyCells;
    }
}
