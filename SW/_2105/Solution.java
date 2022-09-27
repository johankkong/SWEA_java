package SW._2105;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			result = -1;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					//1열, 마지막 2행, 꼭짓점 제외
					//왜냐하면 좌측 하단으로 탐색을 시작할 거라서
					 if(j == 0 || i >= N - 2 || (i == 0 && j == N - 1) || (i == N - 1 && j == N - 1))
						 continue;
					//나머지 칸에서 탐색 시작
					 spr = i;
					 spc = j;
					 List<Integer> list = new ArrayList<>();
					 list.add(arr[i][j]);
					 tour(i + 1, j - 1, 0, 1, list);
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}
	static int N;
	static int[][] arr;
	//대각선 움직임
	static int[] dr = {1, 1, -1, -1};
	static int[] dc = {-1, 1, 1, -1};
	static int result;
	static boolean[][] visited;
	static int spr, spc;
	static void tour(int i, int j, int d, int sum, List<Integer> list) {
		if(i == spr && j == spc) {
			result = Math.max(result, sum);
			return;
		}
		//현재까지 방문한 적이 있는 지 확인
		if(list.contains(arr[i][j]))
			return;
		//방문한 적이 없다면 추가
		list.add(arr[i][j]);
		//방향은 지금 방향 혹은 90도 돌아간 방향만 가능
		//사각형을 만들어야 하기 때문에
		//현재 방향이 왼쪽위로 올라가는 방향이라면 그 방향만 가능
		if(d == 3) {
			if(i + dr[d] >= 0 && i + dr[d] < N && j + dc[d] >= 0 && j + dc[d] < N)
				tour(i + dr[d], j + dc[d], d, sum + 1, list);
		} else {
			//방향 유지
			if(i + dr[d] >= 0 && i + dr[d] < N && j + dc[d] >= 0 && j + dc[d] < N) 
				tour(i + dr[d], j + dc[d], d, sum + 1, list);
			//90도 전환
			d++;
			if(i + dr[d] >= 0 && i + dr[d] < N && j + dc[d] >= 0 && j + dc[d] < N) 
				tour(i + dr[d], j + dc[d], d, sum + 1, list);
		}
		//돌아갈 때, 한칸 제거
		list.remove(list.size() - 1);
	}
}
