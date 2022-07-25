package D3._4789;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String people = sc.next();
			int[] applause = new int[people.length()];
			for (int i = 0; i < people.length(); i++) {
				applause[i] = people.charAt(i) - 48;
			}
			int present = 0;
			int need = 0;
			for (int i = 0; i < people.length(); i++) {
				if (present >= i) {
					present += applause[i];
				} else {
					int tmp = i - present;
					present += applause[i] + tmp;
					need += tmp;
				}
			}
			System.out.println("#" + tc + " " + need);
		}
		sc.close();
	}
}
