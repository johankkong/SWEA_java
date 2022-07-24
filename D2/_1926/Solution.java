package D2._1926;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 1; i <= N; i++) {
			if (check(i) == 0) {
				System.out.print(i + " ");
			} else {
				for(int j = 0; j < check(i); j++) {
					System.out.print("-");
				}
				System.out.print(" ");
			}
		}
	}
	static int check(int num) {
		int result = 0;
		while (num > 1) {
			if((num % 10) % 3 == 0 && num % 10 != 0) result++;
			num /= 10;
		}
		return result;
	}
}
