package D3._2806;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++ ) {
			N = sc.nextInt();
			ans = 0;
			arr = new int[N][N];
			
			putQueen(0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	private static void putQueen(int r) {
		if(r == N) {
			ans++;
			return;
		}
		//해당 행의 어떤 자리에 놓을 지 검사
		for(int c = 0; c < N; c++) {
			if(isPutable(r, c)) {
				arr[r][c] = 1;
				putQueen(r + 1);
				arr[r][c] = 0;
			}
		}
	}

	private static boolean isPutable(int r, int c) {
		int left = c;
		int right = c;
		for(int i = r - 1; i >= 0; i--) {
			left--;
			right++;
			
			if(arr[i][c] == 1) return false;
			if(left >= 0 && arr[i][left] == 1) return false;
			if(right < N && arr[i][right] == 1) return false;
		}
		return true;
	}

	static int N;
	static int[][] arr;
	static int ans;
	
}
