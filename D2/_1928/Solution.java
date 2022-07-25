package D2._1928;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String before = sc.next();
		int[] code = new int[before.length() * 6];
		for(int i = before.length() - 1; i >= 0; i--) {
			int num = 0;
			if (before.charAt(i) >= 65 && before.charAt(i) <= 90) {
				num = before.charAt(i) - 65;
			} else if (before.charAt(i) >= 97 && before.charAt(i) <= 122) {
				num = before.charAt(i) - 71;
			} else if (before.charAt(i) >= 48 && before.charAt(i) <= 67) {
				num = before.charAt(i) + 4;
			} else if (before.charAt(i) == 43) {
				num = before.charAt(i) + 19;
			} else if (before.charAt(i) == 47) {
				num = before.charAt(i) + 16;
			}
			int idx = i * 6 + 5;
			for (int j = 0; j < 6; j++) {
				code[idx--] = num % 2;
				num /= 2;
			}
			System.out.println(code.);
		}
	}
}

/*
 * A : 65
 * Z : 90
 * a : 97
 * z : 122
 * 0 : 48
 * + : 43
 * / : 47
 */
