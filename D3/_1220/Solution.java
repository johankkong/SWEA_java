package D3._1220;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int result = 0;
			for (int j = 0; j < N; j++) {
				int tmp = 0;
				for (int i = 0; i < N; i++) {
					if (arr[i][j] == 0)
						continue;
					else if (arr[i][j] == 1) 
						tmp = 1;
					else if (arr[i][j] == 2) {
						if (tmp == 1) {
							result++;
							tmp = 0;
						}
					}
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}
