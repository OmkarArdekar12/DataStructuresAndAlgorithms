// Valid Sudoku

public class ValidSudoku {
    public static boolean checkSudoku(char[][] board, int row, int col, char check) {
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for(int i=0; i<9; ++i) {
            if(board[row][i] == check || board[i][col] == check || board[sr + i / 3][sc + i % 3] == check) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; ++i) {
            for(int j=0; j<9; ++j) {
                if(board[i][j] != '.') {
                    char ch = board[i][j];
                    board[i][j] = '.';
                    if(!checkSudoku(board, i, j, ch)) {
                        return false;
                    }
                    board[i][j] = ch;
                }
            }
        }
        return true;
    }

    // public static boolean checkSudoku(char[][] board, int row, int col) {
    //     char check = board[row][col];
    //     int count = 0;
    //     for(int i=0; i<9; ++i) {
    //         if(board[i][col] == check) {
    //             count++;
    //         }
    //         if(count > 1) {
    //             return false;
    //         }
    //     }
    //     count = 0;
    //     for(int i=0; i<9; ++i) {
    //         if(board[row][i] == check) {
    //             count++;
    //         }
    //         if(count > 1) {
    //             return false;
    //         }
    //     }
    //     count = 0;
    //     int sr = (row / 3) * 3;
    //     int sc = (col / 3) * 3;
    //     for(int i = sr; i < sr+3; i++) {
    //         for(int j = sc; j < sc+3; j++) {
    //             if(board[i][j] == check) {
    //                 count++;
    //             }
    //             if(count > 1) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    // public static boolean isValidSudoku(char[][] board) {
    //     for(int i=0; i<9; ++i) {
    //         for(int j=0; j<9; ++j) {
    //             if(board[i][j] != '.') {
    //                 if(!checkSudoku(board, i, j)) {
    //                     return false;
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }

    public static void main(String[] args) {
        char board[][] = 
        {{'5','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }
}