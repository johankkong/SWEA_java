package D4._3074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] times;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			times = new int[N];
			for (int i = 0; i < N; i++) {
				times[i] = Integer.parseInt(in.readLine());
			}
			Arrays.sort(times);
			//가장 오래걸리는 창구가 다 처리하는 경우, 최대값
			long max = (long)times[N - 1] * (long)M + 1;
			long min = 0;
			//이분 탐색으로 찾아나간다.
			ans = -1;
			binary(min, max);
			System.out.println("#" + tc + " " + ans);
		}
	}
	static long ans;
	private static void binary(long min, long max) {
		long mid = min + (max - min) / 2;
		if(min >= max) {
			if(cal(max) >= M) ans = max;
			else if(cal(max - 1) >= M) ans = max - 1;
			return;
		} 
		//가운데 값동안 모든 창구가 몇명을 해결하는 지 계산
		long people = cal(mid);
		if(people >= M) {
			binary(min, mid);
		} else {
			binary(mid + 1, max);
		}
	}
	
	private static long cal(long time) {
		long people = 0;
		for (int i = 0; i < N; i++) {
			people += time / times[i];
		}
		return people;
	}
}
