// Games

import java.util.*;
import java.io.*;

public class Games {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int home[] = new int[n];
        int guest[] = new int[n];
        for(int i=0; i<n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            home[i] = Integer.parseInt(st.nextToken());
            guest[i] = Integer.parseInt(st.nextToken());
        }
        
        int res = 0;
        for(int i=0; i<n; ++i) {
            for(int j=0; j<n; ++j) {
                if(i != j && home[i] == guest[j]) {
                    ++res;
                }
            }
        }
        
        System.out.println(res);
    }
}