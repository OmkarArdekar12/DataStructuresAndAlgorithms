// QAQ 894-A

import java.util.*;

public class QAQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();

        int count = 0;
        for(int i=0; i<n; ++i) {
            if(s.charAt(i) == 'Q') {
                for(int j=i+1; j<n; ++j) {
                    if(s.charAt(j) == 'A') {
                        for(int k=j+1; k<n; ++k) {
                            if(s.charAt(k) == 'Q') {
                                ++count;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}