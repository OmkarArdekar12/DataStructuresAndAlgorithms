// Remove Two Letters 1800-D

import java.io.*;

public class RemoveTwoLetters {
	public static int removeTwoLetters(int n, String s) {
		int res = n - 1;
		for(int i=1; i<n-1; ++i) {
			if(s.charAt(i-1) == s.charAt(i+1)) {
				--res;
			}		
		}

		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; ++i) {
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			pw.println(removeTwoLetters(n, s));
		}
		pw.flush();
		pw.close();
		br.close();
	}
}
