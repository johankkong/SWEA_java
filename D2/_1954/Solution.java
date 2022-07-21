package D2._1954;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };
			int r = 0;
			int c = -1;
			int d = 0;
			int cnt = 1;
			for (int i = 0; i < n; i++) {
				for(int j = 1; j < 2 * (n - i); j++) {
					if(j == n - i + 1) {
						if (d == 3) {
							d = 0;
						} else {
							d++;
						}
					}
					r = r + dr[d];
					c = c + dc[d];
					arr[r][c] = cnt++;
				}
				if (d == 3) {
					d = 0;
				} else {
					d++;
				}
			}
			System.out.println("#"+tc);
			for (int i=0;i<n;i++) {
				for (int j=0;j<n;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
