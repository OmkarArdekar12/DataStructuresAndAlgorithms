// Thorns and Coins 1932-A

import java.util.*;
import java.io.*;

public class ThornsAndCoins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        for(int x=0; x<t; ++x) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            
            int res = 0;
            int dp[] = new int[n];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for(int i=1; i<n; ++i) {
                if(s.charAt(i) == '*') {
                    continue;
                }
                int way1 = -1;
                if(i-1 >= 0 && dp[i-1] != -1) {
                    way1 = dp[i-1] + (s.charAt(i) == '@' ? 1 : 0);
                }
                int way2 = -1;
                if(i-2 >= 0 && dp[i-2] != -1) {
                    way2 = dp[i-2] + (s.charAt(i) == '@' ? 1 : 0);
                }
                dp[i] = Math.max(way1, way2);
                res = Math.max(dp[i], res);
            }

            pw.println(res);
        }
        
        pw.flush();
        pw.close();
        br.close();
    }
}