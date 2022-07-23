package D2._1940;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/D2/_1940/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int vel = 0;
			int dis = 0;
			for (int i = 0; i < N; i++) {
				int sign = sc.nextInt();
				int acc = 0;
				if(sign == 1) { 
					acc = sc.nextInt();
					vel += acc;
				}
				else if (sign == 2) {
					acc = sc.nextInt();
					vel -= acc;
					if (vel < 0) vel = 0;
				}
				dis += vel;
			}
			System.out.println("#"+tc+" "+dis);
		}
		sc.close();
	}
}
