// Same Difference 150-D

import java.util.*;
import java.io.*;

public class SameDifferences {
	//pair to find: Aj - Ai = j - i
	//let it can be written as: Aj - j = Ai - i
	//So, let find the total count of each pair Ai - i
	//And then form there pairs by total count of that pair
	public static long sameDifferences(int n, int a[]) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=1; i<=n; ++i) {
			int val = a[i] - i;
			map.put(val, map.getOrDefault(val, 0) + 1);
		}

		long res = 0;
		for(int count : map.values()) {
			long totalPairs = (long) count * (count - 1) / 2;
			res += totalPairs;
		}

		return res;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; ++i) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a[] = new int[n + 1];
			for(int idx=1; idx<=n; ++idx) {
				a[idx] = Integer.parseInt(st.nextToken());
			}

			pw.println(sameDifferences(n, a));
		}

		pw.flush();
		pw.close();
		br.close();
	}
}