package SW._1767;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			list = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] == 1 && !(i == 0 || i == N - 1 || j == 0 || j == N - 1))
						list.add(new RC(i, j));
				}
			}
			result = Integer.MAX_VALUE;
			for(int i = list.size(); i >= 0; i--) {
				//list에서 i개를 뽑아서 연결한다.
				selected = new boolean[list.size()];
				comb(0, 0, i);
				if(result != Integer.MAX_VALUE) break;
			}
			System.out.println("#" + tc + " " + result);
		}
	}
	static List<RC> list;
	static boolean[] selected;
	//list에서 i개를 뽑는다.
	static void comb(int start, int depth, int num) {
		if(depth == num) {
			linkPro(0, 0);
			return;
		}
		for(int i = start; i < list.size(); i++) {
			selected[i] = true;
			comb(i + 1, depth + 1, num);
			selected[i] = false;
		}
	}
	static int N;
	static int[][] arr;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static int result;
	static void linkPro(int depth, int sum) {
		if(depth == list.size()) {
			result = Math.min(result, sum);
			return;
		}
		if(sum >= result) return;
		//연결하지 않는 프로세서의 경우 그냥 넘어간다.
		if(!selected[depth]) 
			linkPro(depth + 1, sum);
		//연결해야하는 경우
		else {
			//4방향으로 이어나간다.
			for(int d = 0; d < 4; d++) {
				int nr = list.get(depth).row + dr[d];
				int nc = list.get(depth).col + dc[d];
				//경계선 안쪽이면서 0인 동안,
				while(nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 0) {
					arr[nr][nc] = 2;
					sum++;
					nr += dr[d];
					nc += dc[d];
				}
				//만약 멈췄을 때, 다른 선이나 프로세서를 만났다면 다시 되돌려야한다.
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					nr -= dr[d];
					nc -= dc[d];
					while(arr[nr][nc] == 2) {
						arr[nr][nc] = 0;
						sum--;
						nr -= dr[d];
						nc -= dc[d];
					}
					continue;
				}
				//바깥쪽과 연결되었다면 다음으로 넘어가고
				linkPro(depth + 1, sum);
				//다시 돌아오면 원상 복구
				nr -= dr[d];
				nc -= dc[d];
				while(arr[nr][nc] == 2) {
					arr[nr][nc] = 0;
					sum--;
					nr -= dr[d];
					nc -= dc[d];
				}
			}
		}
	}
}

class RC {
	int row;
	int col;
	public RC(int row, int col) {
		this.row = row;
		this.col = col;
	}
}