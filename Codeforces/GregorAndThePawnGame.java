// Gregor And The Pawn Game 1549-B

import java.util.*;
import java.io.*;

public class GregorAndThePawnGame {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for(int x=0; x<t; ++x) {
            int n = Integer.parseInt(br.readLine());
            int enemy[] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            int pawn[] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            int res = 0;
            boolean used[] = new boolean[n];
            for(int i=0; i<n; ++i) {
                if(pawn[i] == 1) {
                    if(enemy[i] == 0 && !used[i]) {
                        used[i] = true;
                        ++res;
                    } else {
                        if(i > 0 && !used[i - 1] && enemy[i - 1] == 1) {
                            used[i - 1] = true;
                            ++res;
                        } else if(i < n-1 && !used[i + 1] && enemy[i + 1] == 1) {
                            used[i + 1] = true;
                            ++res;
                        }
                    }
                }
            }
            pw.println(res);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}