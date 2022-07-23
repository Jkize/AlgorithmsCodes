public class E130_Medium_Sorrounded_Regions {

    public static void main(String[] args) {
        char[][] board = {
                { 'X', 'O', 'X', 'O', 'X', 'O' },
                { 'O', 'X', 'O', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'O', 'X', 'O' },
                { 'O', 'X', 'O', 'X', 'O', 'X' } };

        E130_Medium_Sorrounded_Regions sol = new E130_Medium_Sorrounded_Regions();

        sol.solve(board);

    }

    /**
     * Runtime: 2 ms, faster than 86.44% of Java online submissions for Surrounded
     * Regions.
     * Memory Usage: 51.6 MB, less than 56.97% of Java online submissions for
     * Surrounded Regions.
     * Next challenges:
     * 
     * @param board
     */
    public void solveV2(char[][] board) {

        for (int i = 0; i < board[0].length; i++) {
            // ROWS
            if (board[0][i] == 'O') {
                dfsMark(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                dfsMark(board, board.length - 1, i);
            }
        }

        for (int i = 0; i < board.length; i++) {
            // COLS
            if (board[i][0] == 'O') {
                dfsMark(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfsMark(board, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'N') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfsMark(char[][] board, int i, int j) {

        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && board[i][j] == 'O') {
            board[i][j] = 'N';

            dfsMark(board, i - 1, j);
            dfsMark(board, i, j - 1);
            dfsMark(board, i + 1, j);
            dfsMark(board, i, j + 1);
        }

    }

    public void solve(char[][] board) {

        int visited[][] = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (visited[i][j] == 0 && board[i][j] == 'O') {

                    if (dfsFindBorder(board, i, j, visited) == 1) {
                        dfsChange(board, i, j, visited);
                    }

                }
            }
        }

    }

    public short dfsFindBorder(char[][] board, int i, int j, int[][] visited) {
        if (j < 0 || i < 0 || i == board.length || j == board[0].length || visited[i][j] == 1 || board[i][j] == 'X') {
            return 0;
        }
        visited[i][j] = 1;

        if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
            dfsFindBorder(board, i - 1, j, visited);
            dfsFindBorder(board, i, j - 1, visited);
            dfsFindBorder(board, i + 1, j, visited);
            dfsFindBorder(board, i, j + 1, visited);
            return 1;
        }

        int total = dfsFindBorder(board, i - 1, j, visited) + dfsFindBorder(board, i, j - 1, visited)
                + dfsFindBorder(board, i + 1, j, visited) + dfsFindBorder(board, i, j + 1, visited);

        if (total > 0) {
            return 1;
        }

        return 0;
    }

    // 1 -> change, 0 No
    public void dfsChange(char[][] board, int i, int j, int[][] visited) {

        if (j < 0 || i < 0 || i == board.length || j == board[0].length || board[i][j] == 'X') {
            return;
        }
        board[i][j] = 'X';

        dfsChange(board, i - 1, j, visited);
        dfsChange(board, i, j - 1, visited);
        dfsChange(board, i + 1, j, visited);
        dfsChange(board, i, j + 1, visited);
    }
}
