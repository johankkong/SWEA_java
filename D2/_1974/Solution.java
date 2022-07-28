package D2._1974;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[][] sudoku = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			boolean flag = true;
			// 가로 검증
			for (int i = 0; i < 9; i++) {
				flag = lineTest(sudoku[i]);
				if (!flag)
					break;
				// 세로 검증
				int[] oneLine = new int[9];
				for (int j = 0; j < 9; j++) {
					oneLine[j] = sudoku[j][i];
				}
				flag = lineTest(oneLine);
				if (!flag)
					break;
			}
			// 네모 검증
			if (flag) {
				out : for (int i = 0; i < 9; i += 3) {
					for (int j = 0; j < 9; j += 3) {
						int[][] small = new int[3][3];
						for (int k = 0; k < 3; k++) {
							for (int l = 0; l < 3; l++) {
								small[k][l] = sudoku[i + k][j + l];
							}
						}
						flag = squareTest(small);
						if (!flag)
							break out;
					}
				}
			}
			if(flag)
				System.out.println("#"+tc+" 1");
			else
				System.out.println("#"+tc+" 0");
		}
	}

	// 가로세로 검증 메서드
	static boolean lineTest(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j])
					return false;
			}
		}
		return true;
	}

	// 정사각형 검증 메서드
	static boolean squareTest(int[][] arr) {
		int tmp = -1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				tmp = arr[i][j];
				for (int k = 0; k < arr.length; k++) {
					for (int l = 0; l < arr.length; l++) {
						if (!(k == i && l == j) && tmp == arr[k][l])
							return false;
					}
				}
			}
		}
		return true;
	}
}
