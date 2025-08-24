// Candies and Two Sisters 1335-A

import java.io.*;

public class CandiesAndTwoSisters {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        for(int i=0; i<t; ++i) {
            int n = Integer.parseInt(br.readLine());
            int res = (n / 2) + ((n % 2 != 0) ? 0 : -1);
            pw.println(res);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}