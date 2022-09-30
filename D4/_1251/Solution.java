package D4._1251;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	//섬의 좌표를 저장
	//모든 섬을 연결할 수 있는 인접행렬을 만든다.
	//위 인접행렬을 통해 프림 알고리즘을 이용하여 최소 환경 부담금 출력한다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int num = Integer.parseInt(in.readLine());
			long[] x = new long[num];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < num; i++) {
				x[i] = Long.parseLong(st.nextToken());
			}
			long[] y = new long[num];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < num; i++) {
				y[i] = Long.parseLong(st.nextToken());
			}
			double tax = Double.parseDouble(in.readLine());
			//인접 행렬을 만든다.
			double[][] adjArr = new double[num][num];
			for (int i = 0; i < num; i++) {
				for (int j = i; j < num; j++) {
					adjArr[i][j] = tax * (double)(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
					adjArr[j][i] = adjArr[i][j];
				}
			}
			double ans = 0;
			//프림 알고리즘 사용하기
			double INF = Double.MAX_VALUE;
			double[] prim = new double[num];
			Arrays.fill(prim, INF);
			boolean[] visited = new boolean[num];
			prim[0] = 0;
			for (int i = 0; i < num; i++) {
				//가장 작은 것 찾기
				double localMin = INF;
				int idx = -1;
				for (int j = 0; j < prim.length; j++) {
					if(!visited[j] && prim[j] < localMin) {
						localMin = prim[j];
						idx = j;
					}
				}
				//해당 칸 방문 처리
				visited[idx] = true;
				//답에 추가하기
				ans += localMin;
				//인접 정점 갱신하기
				for (int j = 0; j < num; j++) {
					if(!visited[j] && adjArr[idx][j] < prim[j]) {
						prim[j] = adjArr[idx][j];
					}
				}
			}
			System.out.println("#" + tc + " " + Math.round(ans));
		}
	}
}
