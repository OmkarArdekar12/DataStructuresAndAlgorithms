// Prepend And Append 1791-C

import java.io.*;

public class PrependAndAppend {
	static int minBinaryStringStarted(int n, String s) {
		int i = 0, j = n - 1;
		while(i < j) {
			if(s.charAt(i) == s.charAt(j)) {
				break;
			}
			++i;
			--j;
		}

		return j - i + 1;
	}
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; ++i) {
        	int n = Integer.parseInt(br.readLine());
        	String s = br.readLine();
        	System.out.println(minBinaryStringStarted(n, s));
        }
    }
}