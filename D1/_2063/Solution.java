package D1._2063;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] count = new int[101];
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			count[num] += 1;
		}
		
		int sum = 0;
		for (int i = 0; i < 101; i++) {
			sum += count[i];
			if (sum >= (N+1)/2) {
				System.out.println(i);
				break;
			}
		}
		
		sc.close();
		
		/*
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		// 0, 1, 2, 3, ... N - 1 까지 들어가는 배열을 정의
		// arr[0], arr[1] 으로 접근이 가능하다.
		// arr[N-1] : 마지막 원소
		// arr[N] :  에러
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 크기가 3인 배열에서 index는 0,1,2 에서 가운데는 1
		// 크기가 5라면 index는 0,1,2,3,4 에서 가운데는 2
		// 7이라면 index는 0,1,2,3,4,5,6 가운데는 3
		// 각각 2로 나눠주면 된다.
				
		Arrays.sort(arr);
		System.out.println(arr[N/2]);
		*/
	}
}
