// Calculating Function 486-A

import java.util.*;

public class CalculatingFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long res = n % 2 == 0 ? n / 2 : -(n + 1) / 2;
        System.out.println(res);
        sc.close();
        
        // Scanner sc = new Scanner(System.in);
        // long n = sc.nextLong();
        // long oddSum = ((n + 1) / 2) * ((n + 1) / 2);
        // long evenSum = (n / 2) * ((n / 2) + 1);
        // long res = evenSum - oddSum;
        // System.out.println(res);
        // sc.close();
    }
}