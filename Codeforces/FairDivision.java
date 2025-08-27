// Fair Division 1472-B

import java.util.*;
import java.io.*;

public class FairDivision {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; ++i) {
			int n = Integer.parseInt(br.readLine());
			int wt[] = new int[n];
			int candy1 = 0, candy2 = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; ++j) {
				wt[j] = Integer.parseInt(st.nextToken());
				if(wt[j] == 1) {
					++candy1;
				} else {
					++candy2;
				}
			}

			//first using maximum amount of 2gram(candy2) candies
			//to form the half wt of the candy and another half wt will be equal only
			//after using the maximum amount of candy2 to form the
			//half wt of tht total checking how much more wt will be 
			//required to form the remaining wt to complete half wt
			//So, if candy1 (1gram candy) can be form the remaining wt to 
			//complete half wt then we can divide the candies in the
			//equal wt between alice and bob
			int totalCandyWt = candy1 + 2 * candy2;
			if(totalCandyWt % 2 != 0) {
				pw.println("NO");
			} else {
				int half = totalCandyWt / 2;
				int usedCandy2 = Math.min(candy2, half / 2);
				int remaining = half - 2 * usedCandy2;
				if(remaining <= candy1) {
					pw.println("YES");
				} else {
					pw.println("NO");
				}
			}
		}
		pw.flush();
		pw.close();
		br.close();
	}
}