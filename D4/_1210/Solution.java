package D4._1210;

import java.util.Scanner;

public class Solution {
	
	//좌 상 우 하로 움직이는 델타이동
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static int d = 1; //현재 진행 방향 인덱스
	//왼쪽이 1인지 판단하는 메소드
	static boolean isLeft(int[][] arr, int i, int j) {
		int t = 0; //왼쪽 방향을 나타내는 인데스
		if(d == 0) t = 3;
		else t = d - 1;
		//왼쪽이 경계선 바깥쪽인 경우, false를 리턴 
		if(i+dr[t] < 0 || i+dr[t] > 99 || j+dc[t] < 0 || j+dc[t] > 99) return false;
		//경계선 안쪽이면서 왼쪽이 1이면 true를 리턴
		else {
			if(arr[i+dr[t]][j+dc[t]] == 1) return true;
			else return false;
		}
	}
	//오른쪽이 1인지 판단하는 메소드
	static boolean isRight(int[][] arr, int i, int j) {
		int t = d + 1; //왼쪽 방향을 나타내는 인데스
		//오른쪽이 경계선 바깥쪽인 경우, false를 리턴 
		if(i+dr[t] < 0 || i+dr[t] > 99 || j+dc[t] < 0 || j+dc[t] > 99) return false;
		//경계선 안쪽이면서 오른쪽이 1이면 true를 리턴
		else {
			if(arr[i+dr[t]][j+dc[t]] == 1) return true;
			else return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			d = 1;
			tc = sc.nextInt();
			int[][] arr = new int[100][100];  //배열 입력 받기
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			//맨 아랫줄에서 2 찾기(시작 지점)
			int startR = 99;
			int startC = 0;
			for(int i = 0; i <= 99; i++) {
				if(arr[99][i] == 2) {
					startC = i;
					break;
				}
			}
			
			
			//맨 위까지 도달할 때 까지 이동
			while(startR != 0) {
				//방향 전환
				//직진 - 좌우가 모두 0인 경우, 
				if(!isLeft(arr, startR, startC) && !isRight(arr, startR, startC)) {
				}
				//우회전 - 오른쪽만 1인 경우
				else if(!isLeft(arr, startR, startC) && isRight(arr, startR, startC)) {
					d = 2;
				}
				//좌회전 - 왼쪽만 1인 경우
				else if(isLeft(arr, startR, startC) && !isRight(arr, startR, startC)) {
					d = 0;
				}
				//양쪽다 1인 경우 - 좌우로 이동중에 세로 줄을 만난 경우
				else if(isLeft(arr, startR, startC) && isRight(arr, startR, startC)) {
					d = 1;
				}
				//앞으로 이동
				startR += dr[d];
				startC += dc[d];
			}
			//결과 출력
			System.out.println("#"+tc+" "+startC);
		}
	}
}
