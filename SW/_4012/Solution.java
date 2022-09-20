package SW._4012;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			sin = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sin[i][j] = sc.nextInt();
				}
			}
			selected = new boolean[N];
			result = Integer.MAX_VALUE;
			comb(0, 0);
			System.out.println("#" + tc + " " + result);
		}
	}
	static int N;
	static int[][] sin;
	static boolean[] selected;
	static int result;
	static void comb(int start, int depth) {
		if(depth == N / 2) {
			List<Integer> T = new ArrayList<>();
			List<Integer> F = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				if(selected[i]) T.add(i);
				else F.add(i);
			}
			result = Math.min(Math.abs(sinergy(T) - sinergy(F)), result);
			return;
		}
		for(int i = start; i < N; i++) {
			selected[i] = true;
			comb(i + 1, depth + 1);
			selected[i] = false;
		}
	}
	static int sinergy;
	private static int sinergy(List<Integer> t) {
		sinergy = 0;
		selectedForSin = new boolean[N / 2];
		combForSin(0, 0, t);
		return sinergy;
	}
	static boolean[] selectedForSin;
	private static void combForSin(int start, int depth, List<Integer> t) {
		if(depth == 2) {
			int[] temp = new int[2];
			for(int i = 0; i < N / 2; i++) {
				if(selectedForSin[i]) {
					if(temp[0] != 0)
						temp[1] = t.get(i);
					else
						temp[0] = t.get(i);
				}
			}
			sinergy += sin[temp[0]][temp[1]] + sin[temp[1]][temp[0]];
			return;
		}
		for(int i = start; i < N / 2; i++) {
			selectedForSin[i] = true;
			combForSin(i + 1, depth + 1, t);
			selectedForSin[i] = false;
		}
	}
	
	
}
