package D3._5215;

import java.util.Scanner;

public class Solution {
	static int N, L;
	static int[] taste, cal;
	static boolean[] check;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			taste = new int[N];
			cal = new int[N];
			for(int i = 0; i < N; i++) {
				taste[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			check = new boolean[N];
			ans = 0;
			powerSet(0);
//			solve(0, 0, 0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void powerSet(int idx) {
		if(idx == N) {
			int tSum = 0, kSum = 0;
			for(int i = 0; i < N; i++) {
				if(check[i]) {
					tSum += taste[i];
					kSum += cal[i];
				}
			}
			if(kSum <= L) {
				ans = Math.max(ans, tSum);
			}
			return;
		}
		check[idx] = true;
		powerSet(idx + 1);
		check[idx] = false;
		powerSet(idx + 1);
	}
	
	static void solve(int idx, int tSum, int kSum) {
		if(kSum > L) return;
		if(idx == N) {
			if(kSum <= L) 
				ans = Math.max(ans, tSum);
			return;
		}
		solve(idx + 1, tSum + taste[idx], kSum + cal[idx]);
		solve(idx + 1, tSum, kSum);
		
	}
}
