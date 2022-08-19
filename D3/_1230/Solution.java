package D3._1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			int len = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			//저장할 List 선언
			LinkedList<Integer> list = new LinkedList<>();
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			//명령어 갯수
			int comNum = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < comNum; i++) {
				switch(st.nextToken()) {
				// I인 경우 순차적으로 넣는다.
				case "I":
					int pos = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					for(int j = 0; j < num; j++) {
						list.add(pos + j, Integer.parseInt(st.nextToken()));
					}
					break;
				//D인 경우,그 자리를 연속적으로 삭제
				case "D":
					int posD = Integer.parseInt(st.nextToken());
					int numD = Integer.parseInt(st.nextToken());
					for(int j = 0; j < numD; j++) list.remove(posD);
					break;
				//A인 경우 맨뒤에 추가
				case "A":
					int numA = Integer.parseInt(st.nextToken());
					for(int j = 0; j < numA; j++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
				}
			}
			//처음 10개만 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			for(int i = 0; i < 10; i++) {
				sb.append(" ").append(list.get(i));
			}
			System.out.println(sb);
		}
	}
}
