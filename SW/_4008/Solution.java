package SW._4008;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			oper = new int[4];
			for (int i = 0; i < 4; i++) {
				oper[i] = sc.nextInt();
			}
			arr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			order = new int[N - 1];
			int[] selected = new int[4];
			maxR = -Integer.MAX_VALUE;
			minR = Integer.MAX_VALUE;
			perm(0, selected);
			System.out.println("#" + tc + " " + (maxR - minR));
		}
	}

	static int N, maxR, minR;
	static int[] arr;
	static int[] oper;
	static int[] order;

	static void perm(int depth, int[] selected) {
		if (depth == N - 1) {
			int tmp = arr[0];
			for (int i = 0; i < N - 1; i++) {
				switch (order[i]) {
				case 0:
					tmp += arr[i + 1];
					break;
				case 1:
					tmp -= arr[i + 1];
					break;
				case 2:
					tmp *= arr[i + 1];
					break;
				case 3:
					tmp /= arr[i + 1];
					break;
				}
			}
			maxR = Math.max(maxR, tmp);
			minR = Math.min(minR, tmp);
			return;
		}

		for (int j = 0; j < 4; j++) {
			if (selected[j] < oper[j]) {
				selected[j]++;
				order[depth] = j;
				perm(depth + 1, selected);
				selected[j]--;
			}
		}
	}

}
