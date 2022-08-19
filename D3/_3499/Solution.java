package D3._3499;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int cardNum = sc.nextInt();
			String[] cards = new String[cardNum];
			for (int i = 0; i < cardNum; i++) {
				cards[i] = sc.next();
			}
			//왼쪽 카드 더미
			Queue<String> leftCards = new LinkedList<>();
			for(int i = 0; i < cards.length / 2 + (cards.length % 2); i++) {
				leftCards.offer(cards[i]);
			}
			//오른쪽 카드 더미
			Queue<String> rightCards = new LinkedList<>();
			for(int i = cards.length / 2 + (cards.length % 2); i < cardNum; i++) {
				rightCards.offer(cards[i]);
			}
			//각 카드 더미에서 하나씩 뽑아서 결과를 출력
			System.out.print("#"+tc);
			while(!leftCards.isEmpty() && !rightCards.isEmpty()) {
				System.out.print(" " + leftCards.poll());
				System.out.print(" " + rightCards.poll());
			}
			//왼쪽 카드 더미에 하나 남아있다면 출력
			if(!leftCards.isEmpty()) System.out.println(" " + leftCards.poll());
			else System.out.println();
		}
	}
}
