package D3._1213;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc= 1; tc<=10; tc++) {
			int n = sc.nextInt();
			String pt = sc.next();  //패턴
			String text = sc.next(); //원문
			
			int result = 0; //갯수 저장 변수
			
			//text 탐색
			text : for(int i = 0; i <= text.length() - pt.length(); i++) {
				//한글자씩 비교
				for(int j = 0; j < pt.length(); j++) {
					if(text.charAt(i+j) != pt.charAt(j)) {
						continue text;
					}
				}
				//위 조건이 실행되지 않았다면 패턴 일치!
				result++;
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
