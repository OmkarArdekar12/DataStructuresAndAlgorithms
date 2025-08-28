// Fall Down 1669-G

//Optimized Solution
import java.util.Scanner;

public class FallDown {
    public static void fallDown(int n, int m, char[][] grid) {
        // Process each column separately
        for (int j = 0; j < m; j++) {
            // The position where the next stone should fall
            int bottom = n - 1;
            
            // Process column from bottom to top
            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] == '*') {
                    // If it's not already at the bottom position, move it down
                    if (i != bottom) {
                        grid[bottom][j] = '*';
                        grid[i][j] = '.';
                    }
                    bottom--;
                } else if (grid[i][j] == 'o') {
                    // Obstacle - reset the bottom position
                    bottom = i - 1;
                }
            }
        }
        
        // Print the result
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < m; j++) {
                    grid[i][j] = s.charAt(j);
                }
            }
            fallDown(n, m, grid);
        }
        sc.close();
    }
}

// import java.util.*;

// public class FallDown {
// 	public static void fallDown(int n, int m, char grid[][]) {
// 		char res[][] = new char[n][m];
// 		for(int j=0; j<m; ++j) {
// 			StringBuilder sb = new StringBuilder("");
// 			for(int i=0; i<n; ++i) {
// 				char ch = grid[i][j];
// 				if(ch == '.') {
// 					int k = sb.length() - 1;
// 					if(sb.length() == 0 || sb.charAt(k) != '*') {
// 						sb.append(ch);
// 						continue;
// 					}
// 					while(k >= 0 && sb.charAt(k) == '*') {
// 						--k;
// 					}
// 					sb.insert(k+1, ch);
// 				} else {
// 					sb.append(ch);
// 				}
// 			}

// 			for(int i=0; i<n; ++i) {
// 				res[i][j] = sb.charAt(i);
// 			}
// 		}

// 		for(int i=0; i<n; ++i) {
// 			for(int j=0; j<m; ++j) {
// 				System.out.print(res[i][j]);
// 			}
// 			System.out.println();
// 		}
// 		System.out.println();
// 	}

// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
// 		int t = sc.nextInt();
// 		for(int k=0; k<t; ++k) {
// 			int n = sc.nextInt();
// 			int m = sc.nextInt();
// 			char grid[][] = new char[n][m];
// 			for(int i=0; i<n; ++i) {
// 				String s = sc.next();
// 				for(int j=0; j<m; ++j) {
// 					grid[i][j] = s.charAt(j);
// 				}
// 			}
// 			fallDown(n, m, grid);
// 		}
// 		sc.close();
// 	}
// }

//Optimized Solution
// import java.io.*;
// import java.util.*;

// public class FallDown {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int t = Integer.parseInt(br.readLine());
//         while (t-- > 0) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             int n = Integer.parseInt(st.nextToken());
//             int m = Integer.parseInt(st.nextToken());
            
//             char[][] grid = new char[n][m];
//             for (int i = 0; i < n; i++) {
//                 String s = br.readLine();
//                 for (int j = 0; j < m; j++) {
//                     grid[i][j] = s.charAt(j);
//                 }
//             }
//             fallDown(n, m, grid);
//         }
//     }

//     public static void fallDown(int n, int m, char[][] grid) {
//         for (int j = 0; j < m; j++) {
//             int bottom = n - 1;
//             for (int i = n - 1; i >= 0; i--) {
//                 if (grid[i][j] == '*') {
//                     if (i != bottom) {
//                         grid[bottom][j] = '*';
//                         grid[i][j] = '.';
//                     }
//                     bottom--;
//                 } else if (grid[i][j] == 'o') {
//                     bottom = i - 1;
//                 }
//             }
//         }

//         for (char[] row : grid) {
//             System.out.println(new String(row));
//         }
//         System.out.println();
//     }
// }