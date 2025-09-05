// Seating in a Bus 2000-B

import java.util.*;
import java.io.*;

public class SeatingInABus {
    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
    	PrintWriter pw = new PrintWriter(System.out);
    	for(int x=0; x<t; ++x) {
    		int n = Integer.parseInt(br.readLine());
    		int a[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    		boolean occupied[] = new boolean[n + 2];
    		boolean res = true;
    		for(int i=0; i<n; ++i) {
    			if(i == 0) {
    				occupied[a[i]] = true;
    				continue;
    			}
    			if(!occupied[a[i] - 1] && !occupied[a[i] + 1]) {
    				res = false;
    				break;
    			}
    			occupied[a[i]] = true;
    		}

    		if(res) {
    			pw.println("YES");
    		} else {
    			pw.println("NO");
    		}
    	}

    	pw.close();
    	br.close();
    }
}