package D3._2930;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb;
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder("#").append(tc);
			int num = sc.nextInt();
			// 힙을 구현하기 위한 배열 생성
			int[] heap = new int[num * 3];
			// 수가 들어있는 마지막 index
			int end = 0;
			for (int i = 0; i < num; i++) {
				int command = sc.nextInt();
				if (command == 1) {
					heap[++end] = sc.nextInt();
					int curr = end;
					while (curr > 1 && heap[curr] > heap[curr / 2]) {
						int tmp = heap[curr];
						heap[curr] = heap[curr / 2];
						heap[curr / 2] = tmp;
						curr /= 2;
					}
				} else {
					if (end == 0)
						sb.append(" ").append(-1);
					else {
						sb.append(" ").append(heap[1]);
						heap[1] = heap[end--];
						heap[end + 1] = 0;
						int curr = 1;
						while (heap[curr] < heap[curr * 2] || heap[curr] < heap[curr * 2 + 1]) {
							if (heap[curr * 2] > heap[curr * 2 + 1]) {
								int tmp = heap[curr * 2];
								heap[curr * 2] = heap[curr];
								heap[curr] = tmp;
								curr *= 2;
							} else {
								int tmp = heap[curr * 2 + 1];
								heap[curr * 2 + 1] = heap[curr];
								heap[curr] = tmp;
								curr = curr * 2 + 1;
							}
						}
					}
				}
			}
			System.out.println(sb);
		}
	}
}
