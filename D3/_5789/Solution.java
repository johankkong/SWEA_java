package D3._5789;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			// N과 Q를 입력받음
			int N = sc.nextInt();
			int Q = sc.nextInt();

			// 크기 N 배열 생성
			int[] arr = new int[N]; // 이때 자동으로 0으로 초기화됨.

			// Q번 반복적으로 진행
			for (int i = 1; i <= Q; i++) {
				// L과 R을 바로 index로 활용하기 위해 1을 빼고 입력받음
				int L = sc.nextInt() - 1;
				int R = sc.nextInt() - 1;

				// L과 R 사이의 값을 i 로 변경
				for (int j = L; j <= R; j++) {
					arr[j] = i;
				}
			}

			// 결과를 출력
			System.out.print("#" + tc);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(" " + arr[i]);
			}
			System.out.println();
		}
		sc.close();
	}
}
