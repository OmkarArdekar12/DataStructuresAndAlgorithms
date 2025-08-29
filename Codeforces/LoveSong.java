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
            int value = (s.charAt(i) - 'a') + 1;
            prefix[i+1] = prefix[i] + value;
        }
        
        for(int i=0; i<q; ++i) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            pw.println(prefix[r] - prefix[l-1]);
        }
        
        pw.flush();
        pw.close();
        br.close();
    }
}