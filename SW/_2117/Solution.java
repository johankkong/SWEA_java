package SW._2117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = -1;
			//방범서비스의 범위를 1부터 N까지 늘려나간다.
			for (int scope = 1; scope <= N + 1; scope++) {
				int cost = (int) (Math.pow(scope, 2) + Math.pow(scope - 1, 2));
				//모든 칸에 대해서 방범서비스를 시도
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int pay = 0;
						int house = 0;
						//범위 안에 있는 집을 찾는다.
						for (int i2 = 0; i2 < N; i2++) {
							for (int j2 = 0; j2 < N; j2++) {
								if(Math.abs(i2 - i) + Math.abs(j2 - j) < scope) {
									if(arr[i2][j2] == 1) {
										pay += M;
										house++;
									}
								}
							}
						}
						//만약 적자가 아니라면
						if(pay >= cost) {
							ans = Math.max(ans, house);
						}
					}
				}
			}
			//결과를 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
}
