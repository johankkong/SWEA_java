package D3._6485;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/D3/_6485/s_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] busStop = new int[N][2];
			for (int i = 0; i < N; i++) {
				busStop[i][0] = sc.nextInt();
				busStop[i][1] = sc.nextInt();
			}
			int P = sc.nextInt();
			System.out.print("#" + tc);
			for (int i = 0; i < P; i++) {
				int busNum = sc.nextInt();
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if (busNum >= busStop[j][0] && busNum <= busStop[j][1]) {
						cnt++;
					}
				}
				System.out.print(" " + cnt);
			}
			System.out.println();
		}
		sc.close();
	}
}
