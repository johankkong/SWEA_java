package D4._3074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SolutionTimeEx {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] times = new int[N];
			for (int i = 0; i < N; i++) {
				times[i] = Integer.parseInt(in.readLine());
			}

			boolean[] interview = new boolean[N];
			int[] remain = new int[N];

			int ans = 0;
			int complete = 0;

			Arrays.fill(interview, true);
			for (int i = 0; i < N; i++) {
				remain[i] = times[i];
			}

			while (complete < M) {
				ans++;
				for (int i = 0; i < N; i++) {
					if (interview[i]) {
						remain[i]--;
						if (remain[i] == 0) {
							interview[i] = false;
							remain[i] = times[i];
							complete++;
						}
					}
				}
				// 가장 적게 걸리는 곳을 찾는다.
				while (true) {
					int wait = Integer.MAX_VALUE;
					int idx = -1;
					for (int i = 0; i < N; i++) {
						if (!interview[i]) {
							if(wait > remain[i]) {
								wait = remain[i];
								idx = i;
							}								
						} else if (interview[i]) {
							if(wait > remain[i] + times[i]) {
								wait = remain[i] + times[i];
								idx = i;
							}
						}
					}
					//비어있으면 다음 사람 들어감
					if (!interview[idx]) {
						interview[idx] = true;
					} else {
						break;
					}
				}	
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
