package D2._1948;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int m1 = sc.nextInt(); //날짜 2개를 입력받는다.
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
			int[] year = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //각 월의 일수를 배열로 저장한다.
			int sum = 0;
			for (int i = m1; i < m2; i++) { //첫번째 달부터 두번째 달 이전까지의 월의 일수를 더한다.
				sum += year[i - 1];
			}
			sum = sum - d1 + 1; //첫번째 달의 일수를 빼준다.(당일 포함)
			sum += d2; //두번째달의 일수를 더해준다.
			System.out.println("#"+tc+" "+sum);
		}
	}
}
