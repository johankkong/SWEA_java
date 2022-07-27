package D3._6190;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트 케이스 갯수
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			//N개의 수를 저장할 배열 생성
			int[] nums = new int[N];
			for(int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			//결과를 출력
			System.out.println("#"+tc+" "+maxNum(nums));
		}
	}
	//정수 배열을 입력받아 문제에서 주어진 규칙대로 최댓값을 리턴하는 함수
	static int maxNum(int[] arr) {
		int max = 0; //최댓값을 저장할 변수
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				int tmp = arr[i] * arr[j];
				//곱하기 모든 경우의 수를 단조증가인지 판별하고 max보다 그 결과가 클 때 max에 그 값을 대입 
				if (isIncrease(tmp) && max < tmp ) {
					max = tmp;
				}
			}
		}
		if (max == 0) return -1; //단조 증가하는 수가 없는 경우 -1 을 출력
		return max;
	}
	//단조증가하는 수인지 판별하는 함수
	static boolean isIncrease(int num) {
		int pre = 10; //현재 자릿수를 저장할 변수
		while(num >= 1) {
			if(num % 10 <= pre) { //일의 자리부터 판별하며 수가 점점 작아지는 지 확인
				pre = num % 10;
				num /= 10;
			} else {
				return false;
			}
		}
		return true;
	}
}
