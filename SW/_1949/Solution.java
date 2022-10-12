package SW._1949;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	//가장 높은 봉우리의 좌표를 저장
	//각 위치에서 dfs를 진행
	//갈 수 없는 경우, 한 번에 한해서 현재 높이 보다 1작게끔만 깎기
	static int N, K;
	static int[][] arr;
	static int ans;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N][N];
			int highest = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					highest = Math.max(highest, arr[i][j]);
				}
			}
			//최고 높이 봉우리 위치 저장
			List<Top> list = new ArrayList<>();
			//최고 높이 위치 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(highest == arr[i][j]) {
						list.add(new Top(i, j));
					}
				}
			}
			ans = 0;
			tmp = null;
			origin = 0;
			visited = new boolean[N][N];
			//list에서 하나씩 꺼내어 dfs를 진행
			for (Top top : list) {
				dfs(top, 1, true);
			}
			//결과 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
	static Top tmp;
	static int origin;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void dfs(Top top, int depth, boolean dig) {
		int row = top.row;
		int col = top.col;
		//방문처리
		visited[row][col] = true;
		//현재 최고 길이보다 길면 갱신
		if(ans < depth) ans = depth;
		//네방향에 대해 탐색
		for (int d = 0; d < 4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];
			//경계선 안쪽인 경우에 방문하지 않은 경우에만
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
				//현재 칸보다 작으면 진행
				if(arr[nr][nc] < arr[row][col]) {
					dfs(new Top(nr, nc), depth + 1, dig);
				} 
				//아직 판적이 없다면
				else if(dig){
					//현재 칸보다 크거나 같으면 파고 지나갈 수 있는지 판단
					if(arr[nr][nc] - arr[row][col] < K) {
						//파낸 곳의 정보를 저장해둠
						tmp = new Top(nr, nc);
						origin = arr[nr][nc];
						arr[nr][nc] = arr[row][col] - 1;
						dfs(new Top(nr, nc), depth + 1, false);
						//파낸 곳 원상 복구
						arr[tmp.row][tmp.col] = origin;
						tmp = null;
						origin = 0;
					}
				}
			}
		}
		//방문처리 되돌리기
		visited[row][col] = false;
	}

	static class Top {
		int row;
		int col;
		public Top(int row, int col) {
			this.row = row;
			this.col = col;
		}
		@Override
		public String toString() {
			return "[" + row + ", " + col + "]";
		}
		
	}
}
