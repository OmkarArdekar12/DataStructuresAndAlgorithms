// Bit++ 282-A

import java.io.*;

public class BitPlusPlus {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int x = 0;
		for(int i=0; i<n; ++i) {
			String s = br.readLine();

			if(s.contains("++")) {
				++x;
			} else if(s.contains("--")) {
				--x;
			}
		}
		System.out.println(x);
		br.close();
	}
}