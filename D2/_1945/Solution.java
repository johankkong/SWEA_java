package D2._1945;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int num = sc.nextInt();
			int[] nums = {2, 3, 5, 7, 11};
			int[] result = new int[5];
			for (int i = 0; i < nums.length; i++) {
				if (num % nums[i] == 0) {
					while (num % nums[i] == 0) {
						num /= nums[i];
						result[i]++;
					}
				}
			}
			System.out.print("#"+tc);
			for (int i =0; i < 5; i++) {
				System.out.print(" "+result[i]);
			}
			System.out.println();
		}
	}
}
