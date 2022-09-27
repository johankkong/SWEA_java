package D4._7733;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxNum = 0;
			for (int day = 0; day <= 100; day++) {
				int localNum = 0;
				visited = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(arr[i][j] > day && !visited[i][j]) {
							localNum++;
							dfs(i, j, day);
						}
					}
				}
				maxNum = Math.max(maxNum, localNum);
				if(localNum == 0) break;
			}
			System.out.println("#" + tc + " " + maxNum);
		}
	}
	static int N;
	static boolean[][] visited;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] arr;
	private static void dfs(int i, int j, int day) {
		visited[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if(arr[i][j] > day && !visited[nr][nc])
					dfs(nr, nc, day);
			}
		}
	}
}
