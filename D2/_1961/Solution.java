package D2._1961;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/D2/_1961/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] =sc.nextInt();
				}
			}
			int[][] arr90 = turning(arr);
			int[][] arr180 = turning(arr90);
			int[][] arr270 = turning(arr180);
			System.out.println("#"+tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr270[i][j]);
				}
				System.out.println();
			}
		}
		sc.close();
	}
	static int[][] turning(int[][] arr) {
		int N = arr.length;
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = arr[N-j-1][i];
			}
		}
		return result;
	}
}
