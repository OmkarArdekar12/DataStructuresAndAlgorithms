// Soft Drinking 151-A

import java.util.*;
import java.io.*;

public class SoftDrinking {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int nl = Integer.parseInt(st.nextToken());
        int np = Integer.parseInt(st.nextToken());

        int drink = (k * l) / nl;
        int slice = c * d;
        int salt = p / np;

        int res = Math.min(drink, Math.min(slice, salt)) / n;

        System.out.println(res);
    }
}