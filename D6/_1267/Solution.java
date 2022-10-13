package D6._1267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			//그래프를 인접 리스트로 표현
			ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
			for (int i = 0; i < V + 1; i++) {
				adjList.add(new ArrayList<>());
			}
			//in-degree를 표시할 배열
			int[] inD = new int[V+1];
			for (int i = 0; i < E; i++) {
				int sta = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				//인접 리스트에 추가
				adjList.get(sta).add(end);
				inD[end]++;
			}
			boolean[] visited = new boolean[V+1];
			visited[0] = true;
			StringBuilder ans = new StringBuilder();
			//in-degree가 0인 것부터 빼면서 시행한다.
			for (int i = 0; i < V; i++) {
				//0인 것을 찾기
				for (int j = 0; j <= V; j++) {
					if(!visited[j] && inD[j] == 0) {
						//해당 정점과 연결된 정점들의 in-degree를 1 줄여준다.
						for (Integer ed : adjList.get(j)) {
							inD[ed]--;
						}
						//답에 추가
						ans.append(j).append(" ");
						//방문처리
						visited[j] = true;
						break;
					}
				}
			}
			//결과 출력
			System.out.println("#" + tc + " " + ans.toString());
		}
	}
}
