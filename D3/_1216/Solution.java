package D3._1216;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			tc = sc.nextInt();
			char[][] arr = new char[100][];
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.next().toCharArray();
			}
			//최대 길이 저장
			int result = 0;
			//가로 회문 검사
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					out : for(int k = 99; k > j; k--) {
						if(arr[i][j] == arr[i][k]) {
							int left = j;
							int right = k;
							while(left < right) {
								if(arr[i][left] != arr[i][right]) continue out; 
								left++;
								right--;
							}
							if(k - j + 1 >= result) result = k - j + 1;
							break out;
						}
					}
				}	
			}
			//세로 회문 검사
			for (int j = 0; j < 100; j++) {
				for (int i = 0; i < 100; i++) {
					out : for(int k = 99; k > i; k--) {
						if(arr[i][j] == arr[k][j]) {
							int top = i;
							int bottom = k;
							while(top < bottom) {
								if(arr[top][j] != arr[bottom][j]) continue out; 
								top++;
								bottom--;
							}
							if(k - i + 1 >= result) result = k - i + 1;
							break out;
						}
					}
				}	
			}
			//결과 출력
			System.out.println("#"+tc+" "+result);
		}
	}
}
