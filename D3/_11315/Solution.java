package D3._11315;

import java.util.Scanner;

public class Solution {
	static int N;
	static String[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new String[N][];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next().split("");
			}
			boolean flag = false;
			out : for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j].equals("o") && isWin(i, j)) {
						flag = true;
						break out;
					}
				}
			}
			if(flag) System.out.println("#"+tc+" YES");
			else System.out.println("#"+tc+" NO");
		}
	}

					// 우상, 우, 우하, 하
	static int[] dr = { -1, 0, 1, 1 };
	static int[] dc = { 1, 1, 1, 0 };

	static boolean isWin(int i, int j) {
		out : for (int d = 0; d < 4; d++) { // 네가지 방향으로 탐색
			for (int k = 1; k < 5; k++) {
				int nr = i + dr[d] * k;
				int nc = j + dc[d] * k;
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue out;
				if(!arr[nr][nc].equals("o")) continue out;
			} //5개 모두 continue 안됐으면 true
			return true;
		}  // 4방향 다 봤는데 return 안됐으면 false
		return false;
	}
}
