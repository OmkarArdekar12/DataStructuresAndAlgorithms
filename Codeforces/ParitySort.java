// Parity Sort 1851-B

import java.util.*;
import java.io.*;

public class ParitySort {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        for(int x=0; x<t; ++x) {
            int n = Integer.parseInt(br.readLine());
            int a[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            List<Integer> odd = new ArrayList<>();
            List<Integer> even = new ArrayList<>();
            for(int i=0; i<n; ++i) {
                if(a[i] % 2 != 0) {
                    odd.add(a[i]);
                } else {
                    even.add(a[i]);
                }
            }
            Collections.sort(odd);
            Collections.sort(even);

            int evenPtr = 0, oddPtr = 0;
            int sorted[] = new int[n];
            for(int i=0; i<n; ++i) {
                if(a[i] % 2 != 0) {
                    sorted[i] = odd.get(oddPtr++);
                } else {
                    sorted[i] = even.get(evenPtr++);
                }
            }

            boolean isPossible = true;
            for(int i=1; i<n; ++i) {
                if(sorted[i - 1] > sorted[i]) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
        out.close();
        br.close();
    }
}