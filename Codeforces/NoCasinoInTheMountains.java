// No Casino in the Mountains 2126-B

import java.util.*;
import java.io.*;

public class NoCasinoInTheMountains {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        for(int x=0; x<t; ++x) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int a[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            int totalHikes = 0;
            int currSegment = 0;
            for(int i=0; i<n; ++i) {
                if(a[i] == 0) {
                    ++currSegment;
                } else {
                    if(currSegment >= k) {
                        totalHikes += 1 + (currSegment - k) / (k + 1);
                    }
                    currSegment = 0;
                }
            }
            if(currSegment >= k) {
                totalHikes += 1 + (currSegment - k) / (k + 1);
            }

            pw.println(totalHikes);

            // int dp[] = new int[n];
            // dp[0] = a[0] == 0 ? 1 : 0;
            // int res = 0;
            // for(int i=1; i<n; ++i) {
            //     if(dp[i - 1] == k) {
            //         dp[i] = 0;
            //         ++res;
            //         continue;
            //     }
            //     dp[i] = a[i] == 1 ? 0 : dp[i - 1] + 1;
            // }
            // if(dp[n - 1] == k) {
            //     ++res;
            // }
            // pw.println(res);
        }

        pw.flush();
        pw.close();
        br.close();
    }
}