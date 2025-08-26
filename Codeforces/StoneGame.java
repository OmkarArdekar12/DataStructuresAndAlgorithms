// Stone Game 1538-A

import java.util.*;
import java.io.*;

public class StoneGame {
	public static int stoneGame(int n, int arr[]) {
		int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
		int minIdx = -1, maxIdx = -1;
		for(int i=0; i<n; ++i) {
			if(arr[i] < minVal) {
				minVal = arr[i];
				minIdx = i;
			}
			if(arr[i] > maxVal) {
				maxVal = arr[i];
				maxIdx = i;
			}
		}

		//keep minIdx at left and maxIdx at right for easy calculation
		if(minIdx > maxIdx) {
			int temp = minIdx;
			minIdx = maxIdx;
			maxIdx = temp;
		}

		int case1 = maxIdx + 1; //removing both minIdx & maxIdx from left
		int case2 = n - minIdx; //removing both minIdx & maxIdx from right
		int case3 = (minIdx + 1) + (n - maxIdx); //removing minIdx from left and maxIdx from right

		int minMoves = Math.min(Math.min(case1, case2), case3);

		return minMoves;		
	}

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; ++i) {
        	int n = Integer.parseInt(br.readLine());
        	int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	pw.println(stoneGame(n, arr));
        }
        pw.flush();
        pw.close();
        br.close();
    }
}