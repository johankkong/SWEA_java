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
		
		// 0, 1, 2, 3, ... N - 1 ���� ���� �迭�� ����
		// arr[0], arr[1] ���� ������ �����ϴ�.
		// arr[N-1] : ������ ����
		// arr[N] :  ����
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// ũ�Ⱑ 3�� �迭���� index�� 0,1,2 ���� ����� 1
		// ũ�Ⱑ 5��� index�� 0,1,2,3,4 ���� ����� 2
		// 7�̶�� index�� 0,1,2,3,4,5,6 ����� 3
		// ���� 2�� �����ָ� �ȴ�.
				
		Arrays.sort(arr);
		System.out.println(arr[N/2]);
		*/
	}
}
