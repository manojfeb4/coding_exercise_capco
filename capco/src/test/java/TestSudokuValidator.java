import com.capco.sudoku.SudokuMain;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class TestSudokuValidator {

    @Test
    public void test1() {

        String validFile1 = "src/test/resources/valid_grid_1.txt";
        String validFile2 = "src/test/resources/valid_grid_2.txt";
        String validFile3 = "src/test/resources/valid_grid_3.txt";
        String validFile4 = "src/test/resources/valid_grid_4.txt";

        assertEquals(true, SudokuMain.runSudokuValidator(validFile1));
        assertEquals(true, SudokuMain.runSudokuValidator(validFile2)); //Valid grid with missing cells
        assertEquals(true, SudokuMain.runSudokuValidator(validFile3));
        assertEquals(true, SudokuMain.runSudokuValidator(validFile4));


    }

    @Test
    public void test2() {

        String invalidFile1 = "src/test/resources/invalid_grid_1.txt";
        String invalidFile2 = "src/test/resources/invalid_grid_2.txt";

        assertEquals(false, SudokuMain.runSudokuValidator(invalidFile1));
        assertEquals(false, SudokuMain.runSudokuValidator(invalidFile2)); //Invalid grid with missing cells

    }

    @Test
    public void test3() {

        String missingFile = "src/test/resources/missing_file.txt";

        assertEquals(false, SudokuMain.runSudokuValidator(missingFile));

    }

    @Test
    public void test4() {

        String noArg = "";

        assertEquals(false, SudokuMain.runSudokuValidator(noArg));

    }

}
