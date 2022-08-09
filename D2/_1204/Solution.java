package D2._1204;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int testCase = sc.nextInt();
			int[] scores = new int[101];
			for(int i = 0; i < 1000; i++) {
				scores[sc.nextInt()]++;
			}
			int max = 0;
			int maxIdx = -1;
			for(int i = 0; i < 101; i++) {
				if(scores[i] >= max) {
					maxIdx = i;
					max = scores[i];
				}
			}
			System.out.println("#"+tc+" "+maxIdx);
		}
	}
}
