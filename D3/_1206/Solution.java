package D3._1206;

import java.util.Scanner;

public class Solution {
	//해당 위치의 조망권 확보 세대수를 찾는 메소드
	static int how(int[] arr,int idx) {
		int a = arr[idx] - arr[idx - 2];
		int b = arr[idx] - arr[idx - 1];
		int c = arr[idx] - arr[idx + 1];
		int d = arr[idx] - arr[idx + 2];
		
		if(Math.min(Math.min(a, b), Math.min(c, d)) <= 0) return 0;
		else return Math.min(Math.min(a, b), Math.min(c, d));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			//누적하여 세대수를 더할 변수 선언 
			int sum = 0;
			//조망권 확보 세대수를 더해준다.
			for(int i = 2; i <= n-3; i++) {
				sum += how(arr, i);
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
	

}
