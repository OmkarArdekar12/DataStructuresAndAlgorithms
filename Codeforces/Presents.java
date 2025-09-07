// Presents 136-A

import java.util.Scanner;

public class Presents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n];
        for(int i=0; i<n; ++i) {
            p[i] = scanner.nextInt();
        }
        int[] ans = new int[n + 1];
        for(int i=0; i<n; ++i) {
            ans[p[i]] = i + 1;
        }
        for(int i=1; i<=n; ++i) {
            System.out.print(ans[i] + " ");
        }
    }
}