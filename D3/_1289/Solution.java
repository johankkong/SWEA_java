package D3._1289;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String text = sc.next();
			int ans = 0;
			boolean one = false;
			for(int i = 0; i < text.length(); i++) {  //문자열을 돌면서 다음 두가지 경우에만 1을 추가
				if(!one && text.charAt(i) == '1') {  //0다음에 1이 오는 경우
					one = true;
					ans++;
				} else if(one && text.charAt(i) == '0') {  //1다음에 0이 오는 경우
					one = false;
					ans++;
				} else {   // 나머지 경우엔 패스
					continue;
				}
			}	
			System.out.println("#"+tc+" "+ans);
		}
	}
}
