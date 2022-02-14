package com.capco.sudoku;

/*
    Author: Manoj Manokar
    Description: Sudoku Validation created for Capco Screening
 */

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SudokuMain {


    public static boolean runSudokuValidator(String sudokuFile) {

        SudokuValidator s = new SudokuValidator();
        char grid[][] = s.readSudokuGrid(sudokuFile);

        if (grid != null)
            //validates the grid, as soon as the first duplicate is found, it returns false
            return s.validateGrid(grid, 9);
        else
            //if the file is not present, it returns false
            return false;
    }


    public static void main(String args[]) {

        //Checks if the input grid file is passed, else returns the error
        if (args.length != 1) {
            log.info("Usage : SudokuMain.jar <file_path>");
            log.error("Expected number of arguments : 1, Actual arguments passed:  {}", args.length);
            System.exit(1);
        }

        //Invokes runSudokuValidator Method with the input file passed in command line argument

        if (runSudokuValidator(args[0]))
            log.info("Final Result : Grid is valid");
        else
            log.info("Final Result : Grid is invalid");


    }

}
