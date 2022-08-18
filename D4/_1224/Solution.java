package D4._1224;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			String text = sc.next();
			Stack<Character> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();
			Map<Character, Integer> map = new HashMap<>();
			map.put('(', 0);
			map.put('+', 1);
			map.put('-', 1);
			map.put('*', 2);
			map.put('/', 2);
			for(int i = 0; i < len; i++) {
				char tmp = text.charAt(i);
				if(tmp >= '0' && tmp <= '9') sb.append(tmp);
				else {
					if(tmp == '(') stack.push(tmp);
					else if(tmp == ')') {
						while(!stack.isEmpty() && stack.peek() != '(') sb.append(stack.pop());
						stack.pop();
					} else {
						while(!stack.isEmpty() && map.get(stack.peek()) >= map.get(tmp)) sb.append(stack.pop());
						stack.push(tmp);
					}
				}
			}
			while(!stack.isEmpty()) sb.append(stack.pop());
			System.out.println("#"+tc+" "+cal(sb.toString()));
		}
	}
	
	static int cal(String text) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < text.length(); i++) {
			char tmp = text.charAt(i);
			if(tmp >= '0' && tmp <= '9') stack.push(tmp - '0');
			else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				switch(tmp) {
				case '+':
					stack.push(num1 + num2);
					break;
				case '-':
					stack.push(num1 - num2);
					break;
				case '*':
					stack.push(num1 * num2);
					break;
				case '/':
					stack.push(num1 / num2);
					break;
				}
			}
		}
		return stack.pop();
	}
}
