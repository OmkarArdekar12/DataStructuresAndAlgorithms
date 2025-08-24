// Cipher Shifer 1840-A

import java.io.*;

public class CipherShifer {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        for(int x=0; x<t; ++x) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            StringBuilder a = new StringBuilder("");
            Character prev = null;
            for(int i=0; i<n; ++i) {
                char curr = s.charAt(i);
                if(prev == null) {
                    a.append(curr);
                    prev = curr;
                } else if(prev == curr) {
                    prev = null;
                }
            }
            pw.println(a);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}