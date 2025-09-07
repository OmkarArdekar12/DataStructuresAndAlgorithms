// 1-D Eraser 1873-D

import java.util.*;
import java.io.*;

public class OneDEraser {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        for(int x=0; x<t; ++x) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            int res = 0;
            int i = 0;
            while(i < n) {
                if(s.charAt(i) == 'B') {
                    ++res;
                    i += k;
                } else {
                    ++i;
                }
            }
            pw.println(res);
        }
        pw.close();
        br.close();
    }
}