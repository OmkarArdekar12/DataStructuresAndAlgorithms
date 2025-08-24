// Race 2112-A

import java.util.Scanner;

public class Race {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; ++i) {
            int a = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            int aliceDistX = Math.abs(a - x);
            int aliceDistY = Math.abs(a - y);
            
            int lowerX = x - aliceDistX + 1;
            int upperX = x + aliceDistX - 1;
            int lowerY = y - aliceDistY + 1;
            int upperY = y + aliceDistY - 1;
            
            int overlapLow = Math.max(lowerX, lowerY);
            int overlapHigh = Math.min(upperX, upperY);
            
            boolean found = false;
            if (overlapLow <= overlapHigh) {
                if (a < overlapLow || a > overlapHigh) {
                    found = true;
                } else {
                    if (overlapLow < overlapHigh) {
                        found = true;
                    } else {
                        if (overlapLow != a) {
                            found = true;
                        }
                    }
                }
            }
            sc.close();
            
            System.out.println(found ? "YES" : "NO");
        }
    }
}