package SW._5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	//W개의 열 중에서  N개를 중복을 허용하여 순열을 만든다.
	//순열 순서대로 터트려본다.
	//가장 적게 남은 경우가 답
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//W개의 열 중에서 N개 중복 순열로 만들고 터트려 본다.
			//0000 ~ W-1,W-1,W-1,W-1
			pick = new int [N];
			ans = Integer.MAX_VALUE;
			perm(0);
			System.out.println("#" + tc + " " + ans);
		}
	}
	static int N, W, H;
	static int[][] arr;
	static int[] pick;
	static int ans;
	//중복 순열
	static void perm(int depth) {
		if(depth == N) {
			int result = bomb();
				ans = Math.min(ans, result);
				return;
		}
		for (int i = 0; i < W; i++) {
			pick[depth] = i;
			perm(depth + 1);
		}
	}
	//중복 순열로 뽑은 열의 맨 위를 터트려 보기
	static int bomb() {
		//원본배열 복사하기
		int[][] tmp = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		//복사배열에서 터트려보기
		for (int p = 0; p < pick.length; p++) {
			int col = pick[p];
			//가장 위 인덱스 찾기
			int idx = -1;
			for (int i = 0; i < H; i++) {
				if(tmp[i][col] != 0) {
					idx = i;
					break;
				}
			}
			//없으면 리턴
			if(idx == -1) continue;
			//해당 칸이 1이면 그 칸만 0으로 만들고 넘어감
			if(tmp[idx][col] == 1) {
				tmp[idx][col] = 0;
				continue;
			}
			else {
			//1이 아닐 때만 bfs로 터트리기
				tmp = bfs(tmp, idx, col);
			}
			//터진뒤 아래로 정렬
			tmp = organize(tmp);
		}
		//뽑은 열을 무사히 다 터트렸으면 남은 블럭을 센다.
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(tmp[i][j] != 0) cnt++;
			}
		}
		return cnt;
	}
	//빈칸 있으면 아래로 정렬
	private static int[][] organize(int[][] tmp) {
		//모든 열에 대해서
		for (int col = 0; col < W; col++) {
			//아래에서 부터
			for (int row = H - 1; row >= 0; row--) {
				//0을 발견하면
				if(tmp[row][col] == 0) {
					//그 위를 탐색
					int idx = -1;
					for(int i = row - 1; i >= 0; i--) {
						if(tmp[i][col] != 0) {
							idx = i;
							break;
						}
					}
					//없으면 다음 줄
					if(idx == -1) break;
					//찾았으면 교환
					tmp[row][col] = tmp[idx][col];
					tmp[idx][col] = 0;
				}
			}
		}
		return tmp;
	}
	//bfs로 터뜨리기
	static int[][] bfs(int[][] arr, int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {row, col, arr[row][col]});
		arr[row][col] = 0;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int r = tmp[0];
			int c = tmp[1];
			int value = tmp[2];
			if(value == 1) continue;
			//value의 크기만큼
			for (int v = 1; v < value; v++) {
				//네 방향으로
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d] * v;
					int nc = c + dc[d] * v;
					//경계선 안 쪽 일때만
					if(nr >= 0 && nr < H && nc >= 0 && nc < W) {
						if(arr[nr][nc] != 0) {
							queue.add(new int[] {nr, nc, arr[nr][nc]});
							arr[nr][nc] = 0;
						}
					}
				}
			}
		}
		return arr;
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
