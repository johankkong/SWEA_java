package D4._1223;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			StringBuilder sb = new StringBuilder();
			Stack<Character> stack = new Stack<>();
			int len = sc.nextInt();
			String text = sc.next();
			for(int i = 0; i < len; i++) {
				char tmp = text.charAt(i);
				if(tmp == '*') {
					while(!stack.isEmpty() && stack.peek() != '+') sb.append(stack.pop());
					stack.push(tmp);
				}
				else if(tmp == '+') {
					while(!stack.isEmpty()) sb.append(stack.pop());
					stack.push(tmp);
				} else sb.append(tmp);
			}
			while(!stack.isEmpty()) sb.append(stack.pop());
			System.out.println("#"+tc+" "+cal(sb.toString()));
		}
	}
	
	static int cal(String text) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < text.length(); i++) {
			char tmp = text.charAt(i);
			if(tmp != '+' && tmp != '*') stack.push(tmp - '0');
			else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				if(tmp == '+') stack.push(num1 + num2);
				else stack.push(num1 * num2);
			}
		}
		return stack.pop();
	}
}
