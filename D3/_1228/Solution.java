package D3._1228;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int num = sc.nextInt();
			List<Integer> list = new LinkedList<>();
			//원본 암호문을 하나씩 list에 저장
			for(int i = 0; i < num; i++) {
				list.add(sc.nextInt());
			}
			//명령어 수
			int comNum = sc.nextInt();
			//각 명령어 별로
			for(int i = 0; i < comNum; i++) {
				String line = sc.next();
				int pos = sc.nextInt();
				int numNum = sc.nextInt();
				//해당 인덱스에 차례대로 넣어준다
				for(int j = 0; j < numNum; j++) {
					list.add(pos + j, sc.nextInt());
				}
			}
			//결과 출력
			System.out.print("#"+tc);
			for(int i = 0; i < 10; i++) {
				System.out.print(" "+list.get(i));
			}
			System.out.println();
		}
	}
}
