// Computer Game 1598-A

import java.util.Scanner;

public class ComputerGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            String row1 = sc.next();
            String row2 = sc.next();
            boolean possible = true;
            for(int i=0; i<n; ++i) {
                if(row1.charAt(i) == '1' && row2.charAt(i) == '1') {
                    possible = false;
                    break;
                }
            }
            System.out.println(possible ? "YES" : "NO");
        }
        sc.close();
    }
}