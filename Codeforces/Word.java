// Word 59-A

import java.util.Scanner;

public class Word {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		int n = s.length();
		int lower = 0, upper = 0;
		for(int i=0; i<n; ++i) {
			char ch = s.charAt(i);
			if('a' <= ch && ch <= 'z') {
				++lower;
			} else {
				++upper;
			}
		}

		String res = "";
		if(lower >= upper) {
			res = s.toLowerCase();
		} else {
			res = s.toUpperCase();
		}

		System.out.println(res);
		sc.close();
	}
}