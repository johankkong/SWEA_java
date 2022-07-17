package D2._1946;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.println("#" + tc);
			int N = sc.nextInt();
			String str = "";
			for (int i = 0; i < N; i++) {
				String c = sc.next(); //°ø¹éÀ¸·Î ²÷¾î¼­ °¡Á®¿È
				int num = sc.nextInt();
				for (int j = 0; j < num; j++) {
					str += c;
				}
			}
			char[] arr = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
				if (i % 10 == 9 || i == arr.length - 1){
					System.out.println();
				}
			}
		}
		sc.close();
	}
}
