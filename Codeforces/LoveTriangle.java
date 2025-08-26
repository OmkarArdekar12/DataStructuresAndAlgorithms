// Love Triangle 939-A

import java.util.*;
import java.io.*;

public class LoveTriangle {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int f[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isLoveTriangle = false;
        for(int i=0; i<n; ++i) {
            int a = i + 1;
            int b = f[a - 1];
            int c = f[b - 1];
            int d = f[c - 1];

            if(a == d) {
                isLoveTriangle = true;
                break;
            }
        }
        System.out.println(isLoveTriangle ? "YES" : "NO");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // int f[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // boolean isLoveTriangle = false;
        // for(int i=0; i<n; ++i) {
        //     int curr = i + 1;
        // 	int a = f[i];
        // 	int b = f[a - 1];
        // 	int c = f[b - 1];

        // 	if(curr == c) {
        // 		isLoveTriangle = true;
        // 		break;
        // 	}
        // }
        // System.out.println(isLoveTriangle ? "YES" : "NO");
    }
}