This document contains the illustration of sudoku validation process.

Algorithm:
1.	Split the Grid into 3x3 blocks
2.	Each row values should be unique
3.	Each column values should be unique
4.	Also each 3x3 block values should be unique
If the grid satisfies all the above criteria, it is valid sudoku grid, otherwise it is invalid


1.	Copy sudoku.jar and validate.bat
2.	Execute the validate.bat with the path of valid or invalid grid text file as below
validate.bat C:\Users\manoj\local-workspace\interview\src\test\resources\valid_grid_1.txt
validate.bat C:\Users\manoj\local-workspace\interview\src\test\resources\invalid_grid_1.txt

Artifacts:
Executable_jar: 
src/test/resources/sudoku.jar
Batch file: 
src/test/resources/validate.bat
