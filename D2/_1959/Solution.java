package D2._1959;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			int[] first_array = new int[first];
			for(int i = 0; i < first; i++) {
				first_array[i] = sc.nextInt();
			}
			int[] second_array = new int[second];
			for (int i = 0; i < second; i++) {
				second_array[i] = sc.nextInt();
			}
			int max = 0; 
			if (first < second) {
				int tmp = second - first;
				for (int i = 0; i <= tmp; i++) {
					int sum = 0;
					for (int j = 0; j < first; j++) {
						sum += first_array[j]*second_array[i + j];
					}
					if (max < sum) {
						max = sum;
					}
				}
			} else {
				int tmp = first - second;
				for (int i = 0; i <= tmp; i++) {
					int sum = 0;
					for (int j = 0; j < second; j++) {
						sum += second_array[j]*first_array[i + j];
					}
					if (max < sum) {
						max = sum;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}
		sc.close();
	}
}
