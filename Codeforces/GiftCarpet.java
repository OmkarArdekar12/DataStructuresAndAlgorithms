// Gift Carpet 1862-A

import java.util.*;
import java.io.*;

public class GiftCarpet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        char name[] = {'v', 'i', 'k', 'a'};
        for(int i=0; i<t; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String carpet[] = new String[n];
            for(int j=0; j<n; ++j) {
                carpet[j] = br.readLine();
            }
            
            int count = 0;
            boolean isLike = false;
            for(int x=0; x<m; ++x) {
                for(int y=0; y<n; ++y) {
                    if(carpet[y].charAt(x) == name[count]) {
                        ++count;
                        break;
                    }
                }

                if(count >= name.length) {
                    isLike = true;
                    break;
                }
            }

            pw.println(isLike ? "YES" : "NO");
        }

        pw.flush();
        pw.close();
        br.close();
    }
}