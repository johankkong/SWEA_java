package D4._5432;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String iron = sc.next();
			//레이져 부분을 L로 바꿔준다.
			String newIron = iron.replace("()", "L"); 
			//스택에 넣으면서 판단한다.
			Stack<Character> stack = new Stack<>();
			//결과 저장 변수
			int sum = 0;
			for(int i = 0; i < newIron.length(); i++) {
				// ( 인 경우 push
				if(newIron.charAt(i) == '(') stack.push('(');
				// L 인 경우 현재 stack에 있는 갯수를 sum에 더한다.
				else if(newIron.charAt(i) == 'L') sum += stack.size();
				// ) 인 경우, stack에서 하나를 pop하면서 sum에 1을 더해준다.
				else if(newIron.charAt(i) == ')') {
					stack.pop();
					sum++;
				}
			}
			//결과를 출력한다.
			System.out.println("#"+tc+" "+sum);
		}
	}
}
