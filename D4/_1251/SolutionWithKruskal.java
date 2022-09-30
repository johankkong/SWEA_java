package D4._1251;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SolutionWithKruskal {
	 //간선의 클래스
	static class Edge implements Comparable<Edge> {
		int from, to;  //연결된 정점
		double cost;  //간선의 가중치
		public Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
			this.cost = distance(from, to);
		}
		public int compareTo(Edge o) {
			return this.cost > o.cost ? 1 : -1;
		}
	}
	
	static int N;
	static long[] X, Y;
	static double E;
	//부모 배열
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			X = new long[N];
			Y = new long[N];
			p = new int[N];
			for (int i = 0; i < N; i++) {
				X[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				Y[i] = sc.nextInt();
			}
			E = sc.nextDouble();
			
			//make-set
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}
			//간선을 넣을 PQ
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			//간선 만들기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					pq.offer(new Edge(i, j));
				}
			}
			double sum = 0;
			//크루스칼은 N - 1개의 간선을 이용한다.
			for (int i = 0; i < N - 1; i++) {
				 while(true) {
					 Edge edge = pq.poll();
					 //사이클 점검
					 int px = find(edge.from);
					 int py = find(edge.to);
					 
					 if(px != py) {
						 union(px, py);
						 sum += edge.cost;
						 break;
					 }
				 }
			}
			
			System.out.println("#" + tc + " " + Math.round(sum));
		}
		
	}
	
	//find-set - 대표자 찾기
	static int find(int x) {
		if(p[x] != x) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	//union
	static void union(int x, int y) {
			p[y] = x;
	}
	//간선의 가중치를 계산하는 함수
	static double distance(int i, int j) {
		return E * (Math.pow(X[i] - X[j], 2) + Math.pow(Y[i] - Y[j], 2));
	}
}
