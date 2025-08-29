// Love Song

import java.io.*;
import java.util.*;

public class LoveSong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        long[] prefix = new long[n+1];
        for(int i=0; i<n; ++i) {
            int currVal = (s.charAt(i) - 'a') + 1;
            prefix[i+1] = prefix[i] + currVal;
        }
        
        for(int i=0; i<q; ++i) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            long curr = prefix[r] - prefix[l - 1];
            pw.println(curr);
        }

        pw.flush();
        pw.close();
        br.close();
    }
}