// Favorite Sequence 1462-A

import java.util.*;
import java.io.*;

public class FavoriteSequence {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for(int x=0; x<t; ++x) {
            int n = Integer.parseInt(br.readLine());
            int seq[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int left = 0, right = n - 1;
            boolean turn = true;
            for(int i=0; i<n; ++i) {
                if(turn) {
                    pw.print(seq[left] + " ");
                    ++left;
                } else {
                    pw.print(seq[right] + " ");
                    --right;
                }
                turn = !turn;
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();
    }
}