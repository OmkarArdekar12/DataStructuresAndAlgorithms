// Array Coloring 1843-A

import java.util.*;
import java.io.*;

public class ArrayColoring {
	public static void main(String args[]) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        for(int x=0; x<t; ++x) {
            int n = Integer.parseInt(br.readLine());
            int a[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.parallelSort(a);
            int res = 0;
            for(int i=0, j=n-1; i<j; ++i, --j) {
                res += a[j] - a[i];
            }
            pw.println(res);
        }
        pw.close();
        br.close();
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int t = Integer.parseInt(br.readLine());
        // PrintWriter pw = new PrintWriter(System.out);
        // for(int x=0; x<t; ++x) {
        //     int n = Integer.parseInt(br.readLine());
        //     int a[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //     Arrays.sort(a);
        //     int res = 0;
        //     for(int i=0; i<n/2; ++i) {
        //         res += a[n - i - 1] - a[i];
        //     }
        //     pw.println(res);
        // }
        // pw.flush();
        // pw.close();
        // br.close();
	}
}