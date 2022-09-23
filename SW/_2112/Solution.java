package SW._2112;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int D, W, K;
	static boolean[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			arr = new boolean[D][W];
			for(int i = 0; i < D; i++) {
				for(int j = 0; j < W; j++) {
					arr[i][j] = sc.nextInt() == 1 ? true : false;
				}
			}
			//안 바꾸는 것부터 전부다 바꾸는 것 까지 확인
			int result = 0;
			for(result = 0; result <= W; result++) {
				 if(result == 0) {
					 if(isPass()) break;
				 }
				 else {
					 selected = new boolean[D];
					 flag = false;
					 //D열 중에서 result개를 뽑아서 검사한다.
					 comb(0, 0, result);
					 if(flag) break;
				 }
			}
			System.out.println("#" + tc + " " + result);
		}
	}
	static boolean[] selected;
	//D열 중에서 result개를 뽑아서 바꾸는 작업
	static void comb(int start, int depth, int r) {
		if(flag) return;
		if(depth == r) {
			int[] changedR = new int[r];
			int cnt = 0;
			for(int i = 0; i < D; i++) {
				if(selected[i])
					changedR[cnt++] = i;
			}
			selectedR = new boolean[r];
			change(0, r, changedR);
			return;
		}
		for(int i = start; i < D; i++) {
			selected[i] = true;
			comb(i + 1, depth + 1, r);
			selected[i] = false;
		}
	}
	static boolean flag;
	static boolean[] selectedR;
	//r개 행을 A 혹은 B로 바꾸는 재귀 함수
	static void change(int depth, int r, int[] changedR) {
		if(depth == r) {
			//바꾸고 검사한다.
			boolean[] tmp = new boolean[D];
			//모든 열에 대해서
			for(int j = 0; j < W; j++) {
				//임시 열을 만든다. 
				for(int i = 0; i < D; i++) {
					tmp[i] = arr[i][j];
				}
				for(int i = 0; i < r; i++) {
					tmp[changedR[i]] = selectedR[i];
				}
				if(!isColPass(tmp)) {
					flag = false;
					return;
				}
			}
			flag = true;
			return;
		}
		selectedR[depth] = true;  //A
		change(depth + 1, r, changedR);
		if(flag) return;
		selectedR[depth] = false; //B
		change(depth + 1, r, changedR);
		
	}
	//현재 필름이 성능 검사를 통과하는 지 판단
	static boolean isPass() {
		//모든 열에 대해서 판단
		out : for(int j = 0; j < W; j++) {
			boolean tmp = false;
			int cnt = 1;
			for(int i = 0; i < D; i++) {
				if(i == 0) tmp = arr[i][j];
				else {
					if(tmp != arr[i][j]) {
						tmp = arr[i][j];
						cnt = 1;
					} else
						cnt++;
				}
				if(cnt == K) continue out;
			}
			return false;
		}
		return true;
	}
	//한 열이 성능 검사를 통과하는 지 판단
	static boolean isColPass(boolean[] col) {
			boolean tmp = false;
			int cnt = 1;
			for(int j = 0; j < D; j++) {
				if(j == 0) tmp = col[j];
				else {
					if(tmp != col[j]) {
						tmp = col[j];
						cnt = 1;
					} else
						cnt++;
				}
				if(cnt == K) return true;
			}
			return false;
	}
}
