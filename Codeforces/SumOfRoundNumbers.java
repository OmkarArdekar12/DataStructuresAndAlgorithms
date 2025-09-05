// Sum of Round Numbers 1352-A

import java.io.*;

public class SumOfRoundNumbers {
	static String[] helper(int n) {
		int place = 0;
		int count = 0;
		StringBuilder sb = new StringBuilder("");
		while(n > 9) {
			int ld = n % 10;
			if(ld != 0) {
				sb.append(ld * (int)Math.pow(10, place)).append(" ");
				++count;
			}
			n /= 10;
			++place;
		}
		sb.append(n * (int)Math.pow(10, place));
		++count;

		return new String[]{Integer.toString(count), sb.toString()};
	}
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int nums[] = new int[t];
        for(int i=0; i<t; ++i) {
        	nums[i] = Integer.parseInt(br.readLine());
        }

        PrintWriter pw = new PrintWriter(System.out);
        for(int i=0; i<t; ++i) {
        	String curr[] = helper(nums[i]);
        	pw.println(curr[0]);
        	pw.println(curr[1]);
        }

        pw.flush();
    }
}