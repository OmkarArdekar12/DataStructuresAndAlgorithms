// Domino Piling 50-A

import java.util.Scanner;

public class DominoPiling {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        
        int res = (m * n) / 2;
        
        System.out.println(res);
    }
}