// Diameter of Graph 1581-B

import java.util.Scanner;

public class DiameterOfGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long k = sc.nextLong();
            k -= 2;
            if(m < n - 1 || m > n * (n - 1) / 2) {
                System.out.println("NO");
            } else if(k < 0) {
                System.out.println("NO");
            } else if(k == 0) {
                if(n == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else if(k == 1) {
                if(m == n * (n - 1) / 2) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("YES");
            }
        }
        sc.close();
    }
}