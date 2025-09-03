// Restoring Three Numbers 1154-A

import java.util.*;
import java.io.*;

public class RestoringThreeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int a = arr[3] - arr[2];
        int b = arr[3] - arr[1];
        int c = arr[3] - arr[0];

        System.out.println(a + " " + b + " " + c);

        br.close();
    }
}