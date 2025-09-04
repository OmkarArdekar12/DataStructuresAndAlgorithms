// Fox and Snake 510-A

import java.util.*;
import java.io.*;

public class FoxAndSnake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char res[][] = new char[n][m];
        int cell = m - 1;
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                res[i][j] = ((i % 2) == 0) ? '#' : '.';
            }
            if(i % 2 != 0) {
                res[i][cell] = '#';
                cell = cell == 0 ? m - 1 : 0;
            }
        }

        PrintWriter pw = new PrintWriter(System.out);
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                pw.print(res[i][j]);
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}