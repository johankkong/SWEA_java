package D4._1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	// 좌상단 좌표에서 우하단 좌표까지
	// 다익스트라 알고리즘을 사용하여 최소 비용 경로를 찾는다.
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] row = in.readLine().split("");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(row[j]);
				}
			}
			int[][] dijk = new int[N][N];
			int INF = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				Arrays.fill(dijk[i], INF);
			}
			boolean[][] visited = new boolean[N][N];
			PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> {
				return e1.dis - e2.dis;	
			});
			dijk[0][0] = 0;
			pq.offer(new Edge(0, 0, 0));
			while (!visited[N - 1][N - 1]) {
				//가장 거리가 짧은 Edge를 하나 꺼낸다.
				Edge edge = pq.poll();
				int row = edge.row;
				int col = edge.col;
				int minValue = edge.dis;
				visited[row][col] = true;
				// 최소칸과 연결된 칸 들을 갱신한다.
				for (int d = 0; d < 4; d++) {
					int nr = row + dr[d];
					int nc = col + dc[d];
					if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if(!visited[nr][nc] && minValue + arr[nr][nc] < dijk[nr][nc]) {
							dijk[nr][nc] = minValue + arr[nr][nc];
							pq.offer(new Edge(nr, nc, dijk[nr][nc]));
						}
					}
				}
			}
			//다익스트라완료
			System.out.println("#" + tc + " " + dijk[N - 1][N - 1]);
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static class Edge {
		int row;
		int col;
		int dis;
		public Edge(int row, int col, int dis) {
			super();
			this.row = row;
			this.col = col;
			this.dis = dis;
		}
	}
}
