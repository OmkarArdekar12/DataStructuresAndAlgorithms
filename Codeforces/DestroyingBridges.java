// Destroying Bridges

import java.util.*;
import java.io.*;

public class DestroyingBridges {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        for(int i=0; i<t; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(k >= n - 1) {
                pw.println(1);;
            } else {
                pw.println(n);
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}