package D4._1231;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/D4/_1231/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int num = Integer.parseInt(in.readLine());
			String[] arr = new String[101];
			StringTokenizer st;
			for (int i = 0; i < num; i++) {
				st = new StringTokenizer(in.readLine());
				arr[Integer.parseInt(st.nextToken())] = st.nextToken();
			}
			inorder(arr, 1);
			System.out.println("#"+tc+" "+sb);
			sb = new StringBuilder();
		}
	}

	static StringBuilder sb = new StringBuilder();

	static public void inorder(String[] arr, int index) {
		if (arr[index] != null) {
			inorder(arr, index * 2);
			sb.append(arr[index]);
			inorder(arr, index * 2 + 1);
		}
	}
}
