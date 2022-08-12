package D3._1215;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			char[][] arr = new char[8][];
			for (int i = 0; i < 8; i++) {
				String row = sc.next();
				arr[i] = row.toCharArray();
			}
			// 결과
			int result = 0;
			// 가로 회문 검사
			for (int i = 0; i < 8; i++) {
				out : for (int k = 0; k <= 8 - len; k++) {
					for (int j = 0; j < len / 2; j++) {
						if (arr[i][k + j] != arr[i][k + len - 1 - j])
							continue out;
					}
					result++;
				}
			}
			// 세로 회문 검사
			for (int i = 0; i <= 8 - len; i++) {
				out : for (int k = 0; k < 8; k++) {
					for (int j = 0; j < len / 2; j++) {
						if (arr[i + j][k] != arr[i + len - 1 - j][k])
							continue out;
					}
					result++;
				}
			}
			//결과출력
			System.out.println("#"+tc+" "+result);
		}
	}
}
