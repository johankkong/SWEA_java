package D4._1222;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			String text = sc.next();
			StringBuilder sb = new StringBuilder();
			sb.append(text.charAt(0));
			for(int i = 1; i < len / 2 + 1; i++) {
				sb.append(text.charAt(2 * i));
				sb.append(text.charAt(2 * i - 1));
			}
			System.out.println("#" + tc + " " + cal(sb.toString()));
		}
	}
	
	static int cal(String text) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < text.length(); i++) {
			char tmp = text.charAt(i);
			if(tmp == '+') {
				int num2 = stack.pop();
				int num1 = stack.pop();
				stack.push(num1 + num2);
			} else {
				stack.push(tmp - '0');
			}
		}
		return stack.pop();
	}
}
