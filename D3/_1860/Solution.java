package D3._1860;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/D3/_1860/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] time = new int[N];
			for (int i = 0; i < N; i++) {
				time[i] = sc.nextInt();
			}
			boolean flag = true;
			Arrays.sort(time);
			for (int i = 0; i < N; i++) {
				if ((time[i] / M) * K - i < 1) {
					flag = false;
					break;
				}
			}
			System.out.print("#" + tc + " ");
			if (flag) {
				System.out.println("Possible");
			} else {
				System.out.println("Impossible");
			}
		}
		sc.close();
	}
}
