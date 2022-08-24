package D3._2817;

import java.util.Scanner;

public class Solution {
	static int N, K, ans;
	static int[] arr;
	static boolean[] selected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			selected = new boolean[N];
			ans = 0;
			subset(0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void subset(int index) {
		if(index == N) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(selected[i]) sum += arr[i];
			}
			if(sum == K) ans++;
			return;
		}
		selected[index] = true;
		subset(index + 1);
		selected[index] = false;
		subset(index + 1);
	}
}
