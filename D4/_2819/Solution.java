package D4._2819;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static int[][] arr;
	static Set<String> set;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			arr = new int[4][4];
			set = new HashSet<>();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					sb = new StringBuilder();
					subset(0, i, j);
				}
			}
			System.out.println("#" + tc + " " + set.size());
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void subset(int index, int r, int c) {
		// 기저 조건
		if (index == 7) {
			if (sb.length() == 7) {
				String temp = sb.toString();
				set.add(temp);
			}
			return;
		}
		// 반복 파트
		sb.append(arr[r][c]);
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4) {
				subset(index + 1, nr, nc);
				sb.setLength(index + 1);
			}
		}
	}
}
