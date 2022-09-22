package D4._1486;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			selected = new boolean[N];
			result = Integer.MAX_VALUE;
			subset(0);
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static int N, B;
	static int[] arr;
	static boolean[] selected;
	static int result;
	//부분집합 구하기
	static void subset(int depth) {
		if(depth == N) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(selected[i])
					sum += arr[i];
			}
			if(B > sum)
				return;
			else {
				result = Math.min(result, sum - B);
				return;
			}
		}
		
		selected[depth] = true;
		subset(depth + 1);
		selected[depth] = false;
		subset(depth + 1);
	}
}
