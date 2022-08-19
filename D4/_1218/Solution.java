package D4._1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			int len = Integer.parseInt(in.readLine());
			String text = in.readLine();
			String[] brackets = text.split("");
			Stack<String> stack = new Stack<>();
			String open = "({[<";
			String close = ")}]>";
			boolean flag;
			for(int i = 0; i < len; i++) {
				String tmp = brackets[i];
				if(open.contains(tmp)) stack.push(tmp);
				else {
					if(open.indexOf(stack.peek()) == close.indexOf(tmp)) stack.pop();
					else {
						break;
					}
				}
			}
			flag = stack.isEmpty();
			if(flag) System.out.println("#"+tc+" "+1);
			else System.out.println("#"+tc+" "+0);
		}
	}
}
