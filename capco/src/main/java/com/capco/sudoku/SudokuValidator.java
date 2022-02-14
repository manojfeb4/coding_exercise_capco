package com.capco.sudoku;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import org.apache.log4j.Logger;


public class SudokuValidator {
    Logger log = Logger.getLogger(SudokuValidator.class);
    boolean isExistsInRow(char arr[][], int row) {

        // Create Hashset to store grid row cell values
        HashSet<Character> rowHash = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            log.debug("Row validation : a[" + row + "][" + i + "]: " + arr[row][i] + "]");
            //if the fetched grid cell value is already present in the row hash set, returns the false
            if (rowHash.contains(arr[row][i])) {

                log.error("******Row Validation Failed: value '"+ arr[row][i] + "' duplicates in the cell : " + row + ", " + i );
                return false;
            }

            //Store each grid cell value in the row hash set
            if (arr[row][i] != '.')
                rowHash.add(arr[row][i]);
        }
        return true;
    }

    boolean isExistsInCol(char arr[][], int col) {
        // Create Hashset to store grid col cell values
        HashSet<Character> colHash = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            log.debug("Col validation : a[" + i + "][" + col + "]: " + arr[i][col] + "]");


            //if the fetched grid cell value is already present in the column hash set, returns the false

            if (colHash.contains(arr[i][col])) {
                log.error("******Column Validation Failed: value '"+ arr[i][col] + "' duplicates in the cell : " + i + ", " + col );


                return false;
            }

            //Store each grid cell value in the row hash set
            if (arr[i][col] != '.')
                colHash.add(arr[i][col]);
        }
        return true;
    }

    boolean isExistsInSquare(char arr[][], int startRow, int startCol) {

        // Create Hashset to store grid square cell values
        HashSet<Character> sqHash = new HashSet<>();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char curr = arr[row + startRow][col + startCol];
                log.debug("Square validation : a[" + row + "][" + col + "]: " + arr[row][col] + "]");


                //if the fetched grid cell value is already present in the square hash set, returns the false

                if (sqHash.contains(curr)) {
                    log.error("******Square Validation Failed: value '"+ arr[row][col] + "' duplicates in the cell : " + row + ", " + col );


                    return false;
                }

                //Store each grid cell value in the square hash set
                if (curr != '.')
                    sqHash.add(curr);
            }
        }
        return true;
    }

    boolean isValidGrid(char a[][], int row, int col) {
        return isExistsInRow(a, row) && isExistsInCol(a, col) && isExistsInSquare(a, row - row % 3, col - col % 3);
    }

    boolean validateGrid(char a[][], int n) {
        log.info("Sudoku Validation Process started....!");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // If current row or current column or
                // current 3x3 box is not valid, return
                // false
                if (!isValidGrid(a, i, j))
                    return false;


            }
        }
        return true;
    }

    char[][] readSudokuGrid(String sudokuFile) {
        log.info(sudokuFile);
        File gridFile = new File(sudokuFile);

        // Read the input file which contains the sudoku grid to be validated
        Scanner sc = null;
//try catch block to exit the program if the input grid is not found
        try {
            sc = new Scanner(new BufferedReader(new FileReader(gridFile)));
        } catch (Exception e) {
            log.error(sudokuFile + " grid not found");
            e.printStackTrace();
            return null;
        }
        int rows = 9;
        int columns = 9;

        /***************
         * Convert the grid into two dimensional array
         **************************/
        char[][] myArray = new char[rows][columns];
        while (sc.hasNextLine()) {

            for (int i = 0; i < myArray.length; i++) {
                String[] line = sc.nextLine().split(",");
                for (int j = 0; j < line.length; j++) {
                    myArray[i][j] = line[j].charAt(0);
                }
            }
        }

        log.info("Below is the input grid : ");
        log.info(Arrays.deepToString(myArray)); // print the grid to ensure that it was read properly
        log.info("\n\n");
        /***********************************************************************************/
        return myArray;
    }
}
