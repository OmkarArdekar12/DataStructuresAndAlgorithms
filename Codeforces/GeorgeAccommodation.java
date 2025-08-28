// George Accommodation 467-A

import java.util.*;
import java.io.*;

public class GeorgeAccommodation {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for(int i=0; i<n; ++i) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int p = Integer.parseInt(st.nextToken());
        	int q = Integer.parseInt(st.nextToken());
        	int count = q - p;
        	if(count >= 2) {
        		++res;
        	}
        }
        System.out.println(res);
    }
}