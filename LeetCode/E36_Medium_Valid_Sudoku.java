import java.util.HashSet;
import java.util.Set;

public class E36_Medium_Valid_Sudoku {

    /**
     * Runtime: 5 ms, faster than 70.34% of Java online submissions for Valid
     * Sudoku.
     * Memory Usage: 46.8 MB, less than 57.86% of Java online submissions for Valid
     * Sudoku.
     * 
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {

        // Valid rows;
        // Valid cols;
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rSet = new HashSet<>();
            HashSet<Character> cSet = new HashSet<>();

            for (int j = 0; i < 9; j++) {

                if (board[i][j] != '.' && !rSet.add(board[i][j])) {
                    return false;
                }

                if (board[j][i] != '.' && !cSet.add(board[j][i])) {
                    return false;
                }
            }
        }

        // valid Square

        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                HashSet<Character> dt = new HashSet<>();

                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (board[i][j] != '.' && !dt.add(board[i][j])) {
                            return false;
                        }
                    }
                }

            }
        }
        return true;

    }

    public boolean isValidSudokuV2(char[][] board) {
        Set<String> seen = new HashSet<String>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }
}
