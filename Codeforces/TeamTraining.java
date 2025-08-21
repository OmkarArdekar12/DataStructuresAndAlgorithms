// Team Training 2091-B

import java.util.*;
import java.io.*;

public class TeamTraining {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int a[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            long res = 0;
            long count = 0;
            Arrays.sort(a);
            for(int i=n-1; i>=0; --i) {
                ++count;
                if(a[i] * count >= x) {
                    ++res;
                    count = 0;
                }
            }
            pw.println(res);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}