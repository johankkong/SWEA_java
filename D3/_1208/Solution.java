package D3._1208;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int dump = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < 100; i++) {
				list.add(sc.nextInt());
			}
			Collections.sort(list);
			for(int i = 0; i < dump; i++) {
				list.set(0, list.get(0) + 1);
				list.set(99, list.get(99) - 1);
				Collections.sort(list);				
			}
			System.out.println("#"+tc+" "+(list.get(99) - list.get(0)));
		}
	}
}
