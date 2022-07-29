package D2._12712;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] dr = { { 1, -1, 0, 0 }, { 1, -1, -1, 1 } };
			int[][] dc = { { 0, 0, 1, -1 }, { 1, -1, 1, -1 } };
			// 2차원 배열로 입력받음
			int[][] fly = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					fly[r][c] = sc.nextInt();
				}
			}
			// 최댓값 저장 변수
			int max = 0;
			// 행 탐색
			for (int r = 0; r < N; r++) {
				// 열 탐색
				for (int c = 0; c < N; c++) {
					//+ 모양 0, x 모양 1
					for (int k = 0; k < 2; k++) {
						// 해당 칸에서의 합산 저장 변수
						int sum = 0;
						// 해당칸을 먼저 더함
						sum += fly[r][c];
						// 네방향
						for (int i = 0; i < 4; i++) {
							// M만큼 뻗어나감
							for (int j = 1; j < M; j++) {
								// 탐색을 해 나갈 새로운 행과 열
								int nr = r + dr[k][i] * j;
								int nc = c + dc[k][i] * j;
								// 배열 밖으로 넘어가는 것을 방지
								if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
									sum += fly[nr][nc];
								}
							}
						}
						if (sum > max)
							max = sum;
					}
				}
			}
			System.out.println("#" + tc + " "+ max);
		}
	}
}
