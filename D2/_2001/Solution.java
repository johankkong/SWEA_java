package D2._2001;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int size = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int sum = 0;
			int max = 0;
			for (int i = 0; i < N - size + 1; i++) {
				for (int j = 0; j < N - size + 1; j++) {
					for (int k = i; k < i + size; k++) {
						for (int l = j; l < j + size; l++) {
							sum += arr[k][l];
						}
					}
					if (sum > max) {
						max = sum;
					}
					sum = 0;
				}
			}
			System.out.println("#"+tc+" "+max);
		}
		sc.close();
	}
}
