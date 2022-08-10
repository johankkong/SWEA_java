package D3._1209;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			tc = sc.nextInt();
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int[] sums = new int[202];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if(i == j) sums[200] += arr[i][j];
					if(i + j == 99) sums[201] += arr[i][j];
					sums[i] += arr[i][j];
					sums[j+100] += arr[i][j];
				}
			}
			int max = 0;
			for(int i = 0; i < 202; i++) {
				if(sums[i] > max) max = sums[i];
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
