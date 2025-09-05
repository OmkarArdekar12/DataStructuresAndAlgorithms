// Stone on the Table 266-A

import java.io.*;

public class StoneOnTheTable {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int res = 0;
        for(int i=1; i<n; ++i) {
        	if(s.charAt(i - 1) == s.charAt(i)) {
        		++res;
        	}
        }
        System.out.println(res);
    }
}