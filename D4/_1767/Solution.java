package D4._1767;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class RC {
	int row;
	int col;
	public RC(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
public class Solution {
	static int N;
	static int[][] arr;
	static List<RC> list ;
	static boolean[] selected;
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
					if(arr[i][j] == 1) 
						list.add(new RC(i, j));
				}
			}
			selected = new boolean[list.size()];
			for(int M = list.size() - 1; M > 0; M--) {
				combination(M, 0, 0);
			}
		}
	}
	
	static void combination(int M, int depth, int start) {
		if(depth == M) {
			
		}
		for(int i = start; i < list.size(); i++) {
			selected[i] = true;
			combination(M, depth + 1, start + 1);
			selected[i] = false;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static 
}
