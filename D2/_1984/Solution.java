package D2._1984;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int[] nums = new int[10];
			for(int i = 0; i < 10; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			int sum = 0;
			for(int i = 1; i < 9; i++) {
				sum += nums[i];
			}
			int avg = 0;
			if(sum % 8 < 4) avg = sum / 8;
			else avg = sum / 8 + 1;
			System.out.println("#"+tc+" "+avg);
		}
	}
}
