package D2._1979;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int num = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int tmp = 0;
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						tmp += 1;
					}
					if (arr[i][j] == 0 || j == N - 1) {
						if (tmp == num) {
							result += 1;
						}
						tmp = 0;
					}
				}
			}
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if (arr[i][j] == 1) {
						tmp += 1;
					}
					if (arr[i][j] == 0 || i == N - 1) {
						if (tmp == num) {
							result += 1;
						}
						tmp = 0;
					}
				}
			}
			System.out.println("#"+tc+" "+result);
		}
		sc.close();
	}
}
