// Pangram 520-A

import java.util.*;
import java.io.*;

public class Pangram {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int freq[] = new int[26];
        for(int i=0; i<n; ++i) {
        	char ch = Character.toLowerCase(s.charAt(i));
            if(freq[ch - 'a'] == 1) {
                continue;
            }
        	freq[ch - 'a'] = 1;
        }
        boolean isPangram = Arrays.stream(freq).sum() == 26;
        System.out.println(isPangram ? "YES" : "NO");
    }
}