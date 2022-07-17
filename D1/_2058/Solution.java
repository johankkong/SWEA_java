package D1._2058;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		while (num > 1) {
			sum += num % 10;
			num /= 10;
		}
		System.out.println(sum);
		sc.close();
	}
}
