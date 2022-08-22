package D3._1873;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//지도 입력받기
			int H = sc.nextInt();
			int W = sc.nextInt();
			String[][] arr = new String[H][];
			for(int i = 0; i < H; i++) {
				arr[i] = sc.next().split("");
			}
			//초기 탱크 위치 찾기
			int[] pos = position(arr);
			//명령 입력 받기
			int comNum = sc.nextInt();
			String[] command = sc.next().split("");
			//명령 수행하기
			for(int i = 0; i < comNum; i++) {
				if(command[i].equals("S")) arr = shoot(arr, pos[0], pos[1]);
				else arr = move(arr, pos[0], pos[1], command[i]);
				//명령 수행할 때마다 위치 변경
				pos = position(arr);
			}
			//결과 출력하기
			System.out.print("#"+tc+" ");
			for(String[] row : arr) {
				for(String letter : row) {
					System.out.print(letter);
				}
				System.out.println();
			}
		}
	}
	
	static String tank = "^v<>";
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static String[][] shoot(String[][] arr, int r, int c) {
		int nr = r + dr[tank.indexOf(arr[r][c])];
		int nc = c + dc[tank.indexOf(arr[r][c])];
		while(nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[0].length && !arr[nr][nc].equals("*") && !arr[nr][nc].equals("#")) {
			nr = nr + dr[tank.indexOf(arr[r][c])];
			nc = nc + dc[tank.indexOf(arr[r][c])];
		}
		if(!(nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[0].length)) return arr;
		if(arr[nr][nc].equals("*")) arr[nr][nc] = ".";
		return arr;
	}
	
	static String[][] move(String[][] arr, int r, int c, String dir) {
		//일단 방향 바꾸기
		switch(dir) {
		case "U":
			arr[r][c] = "^";
			break;
		case "D":
			arr[r][c] = "v";
			break;
		case "L":
			arr[r][c] = "<";
			break;
		case "R":
			arr[r][c] = ">";
			break;
		}
		//앞 칸을 판별
		int nr = r + dr[tank.indexOf(arr[r][c])];
		int nc = c + dc[tank.indexOf(arr[r][c])];
		//앞칸이 평지일때만 이동
		if(nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[0].length && arr[nr][nc].equals(".")) {
			arr[nr][nc] = arr[r][c];
			arr[r][c] = ".";
		}
		return arr;
	}
	
	static int[] position(String[][] arr) {
		int[] pos = new int[2];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(tank.contains(arr[i][j])) {
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		return pos;
	}
}
