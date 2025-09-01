// Game of Life

import java.util.Arrays;

public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int neighbors[] = new int[8];
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                int liveCount = 0;
                boolean up = i - 1 >= 0;
                boolean down = i + 1 < m;
                boolean left = j - 1 >= 0;
                boolean right = j + 1 < n;
                neighbors[0] = up ? board[i-1][j] : -1; //top
                neighbors[1] = down ? board[i+1][j] : -1; //bottom
                neighbors[2] = left ? board[i][j-1] : -1; //left
                neighbors[3] = right ? board[i][j+1] : -1; //right
                neighbors[4] = (up && left) ? board[i-1][j-1] : -1; //top-left
                neighbors[5] = (up && right) ? board[i-1][j+1] : -1; //top-right
                neighbors[6] = (down && left) ? board[i+1][j-1] : -1; //bottom-left
                neighbors[7] = (down && right) ? board[i+1][j+1] : -1; //bottom-right
                //currentState: live=1, dead=0
                //nextState: live=3, dead=2
                for(int k=0; k<8; ++k) {
                    if(neighbors[k] == 1 || neighbors[k] == 2) {
                        ++liveCount;
                    }
                }
                
                if(board[i][j] == 0) {
                    if(liveCount == 3) {
                        board[i][j] = 3;
                    }
                } else {
                    if(liveCount < 2 || liveCount > 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
        return;

        // int m = board.length, n = board[0].length;
        // int neighbors[] = new int[8];
        // int ones = 0, zeros = 0;
        // for(int i=0; i<m; ++i) {
        //     for(int j=0; j<n; ++j) {
        //         ones = 0;
        //         zeros = 0;
        //         neighbors[0] = i-1 >= 0 ? board[i-1][j] : -1; // top
        //         neighbors[1] = i+1 < m ? board[i+1][j] : -1; // bottom
        //         neighbors[2] = j-1 >= 0 ? board[i][j-1] : -1; // left
        //         neighbors[3] = j+1 < n ? board[i][j+1] : -1; // right
        //         neighbors[4] = i-1 >= 0 && j-1 >= 0 ? board[i-1][j-1] : -1; // top-left
        //         neighbors[5] = i-1 >= 0 && j+1 < n ? board[i-1][j+1] : -1; // top-right
        //         neighbors[6] = i+1 < m && j-1 >= 0 ? board[i+1][j-1] : -1; // bottom-left
        //         neighbors[7] = i+1 < m && j+1 < n ? board[i+1][j+1] : -1; // bottom-right
        //         for(int k = 0; k < 8; k++) {
        //             if(neighbors[k] == 1 || neighbors[k] == 3) {
        //                 ones++;
        //             }
        //             if(neighbors[k] == 0 || neighbors[k] == 2) {
        //                 zeros++;
        //             }
        //         }
        //         if(board[i][j] == 0) {
        //             if(ones == 3) {
        //                 board[i][j] = 2;
        //             }
        //         } else {
        //             if(ones < 2 || ones > 3) {
        //                 board[i][j] = 3;
        //             }
        //         }
        //     }
        // }
        // for(int i=0; i<m; ++i) {
        //     for(int j=0; j<n; ++j) {
        //         if(board[i][j] == 2) {
        //             board[i][j] = 1;
        //         }
        //         if(board[i][j] == 3) {
        //             board[i][j] = 0;
        //         }
        //     }
        // }
        // return;
    
        // int m = board.length, n = board[0].length;
        // int neighbors[] = new int[8];
        // for(int i=0; i<m; ++i) {
        //     for(int j=0; j<n; ++j) {
        //         int liveCount = 0, deadCount = 0;
        //         boolean up = i - 1 >= 0;
        //         boolean down = i + 1 < m;
        //         boolean left = j - 1 >= 0;
        //         boolean right = j + 1 < n;
        //         neighbors[0] = up ? board[i-1][j] : -1; //top
        //         neighbors[1] = down ? board[i+1][j] : -1; //bottom
        //         neighbors[2] = left ? board[i][j-1] : -1; //left
        //         neighbors[3] = right ? board[i][j+1] : -1; //right
        //         neighbors[4] = (up && left) ? board[i-1][j-1] : -1; //top-left
        //         neighbors[5] = (up && right) ? board[i-1][j+1] : -1; //top-right
        //         neighbors[6] = (down && left) ? board[i+1][j-1] : -1; //bottom-left
        //         neighbors[7] = (down && right) ? board[i+1][j+1] : -1; //bottom-right
        //         //currentState: live=1, dead=0
        //         //nextState: live=3, dead=2
        //         for(int k=0; k<8; ++k) {
        //             if(neighbors[k] == 1 || neighbors[k] == 2) {
        //                 ++liveCount;
        //             } else { //neighbors[k] == 0 || neighbors[k] == 3
        //                 ++deadCount;
        //             }
        //         }
    
        //         if(board[i][j] == 0) {
        //             if(liveCount == 3) {
        //                 board[i][j] = 3;
        //             }
        //         } else {
        //             if(liveCount < 2 || liveCount > 3) {
        //                 board[i][j] = 2;
        //             }
        //         }
        //     }
        // }
        // for(int i=0; i<m; ++i) {
        //     for(int j=0; j<n; ++j) {
        //         if(board[i][j] == 2) {
        //             board[i][j] = 0;
        //         }
        //         if(board[i][j] == 3) {
        //             board[i][j] = 1;
        //         }
        //     }
        // }
        // return;
    }
    
    public static void main(String[] args) {
        int board[][] = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        for(int r[] : board) {
            System.out.println(Arrays.toString(r));
        }
        System.out.println();
        gameOfLife(board);
        for(int r[] : board) {
            System.out.println(Arrays.toString(r));
        }
    }
}