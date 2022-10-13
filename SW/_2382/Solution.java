package SW._2382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static List<Integer> same = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			//미생물 군집 list
			List<Micro> list = new ArrayList<>();
			for (int i = 0; i < K; i++) {
				list.add(new Micro(in.readLine()));
			}
			//M시간이 흐른다.
			for (int i = 0; i < M; i++) {
				//모든 미생물 군집에 대해서
				for (Micro micro : list) {
					//이동시키기
					micro.row += dr[micro.dir];
					micro.col += dc[micro.dir];
					//경계선에 도달하면
					if(micro.row == 0 || micro.col == 0 || micro.row == N - 1 || micro.col == N - 1) {
						//수를 절반으로 줄인다.
						micro.num /= 2;
						//방향을 거꾸로 바꾼다.
						if(micro.dir == 1) micro.dir = 0;
						else if(micro.dir == 0) micro.dir = 1;
						else if(micro.dir == 2) micro.dir = 3;
						else if(micro.dir == 3) micro.dir = 2;
					}
				}
				//모두 이동시키고 난 뒤에 그 수가 0인 군집은 삭제
				for (int j = 0; j < list.size(); j++) {
					Micro curr = list.get(j);
					if(curr.num == 0) {
						list.remove(j);
						j--;
						continue;
					}
					//같은 위치에 오는 군집의 인덱스를 저장한다.
					for (int k = j + 1; k < list.size(); k++) {
						Micro tmp = list.get(k);
						if(curr.row == tmp.row && curr.col == tmp.col) {
							same.add(k);
						}
					}
					//가장 많은 수의 군집을 찾는다.
					if(!same.isEmpty()) {
						int sum = curr.num;
						int max = curr.num;
						int idx = j;
						for (Integer s : same) {
							int curNum = list.get(s).num;
							sum += curNum;
							if(max < curNum) {
								idx = s;
								max = curNum;
							}
						}
						curr.num = sum;
						curr.dir = list.get(idx).dir;
						int cnt = 0;
						for (Integer s : same) {
							list.remove((int)s - cnt++);
						}
						same.clear();
					}
				}
			}
			//모든 미생물 군집의 수를 더한다.
			int ans = 0;
			for (Micro micro : list) {
				ans += micro.num;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Micro {
		int row;
		int col;
		int num;
		byte dir;

		public Micro(String text) {
			StringTokenizer st = new StringTokenizer(text);
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			dir = (byte) (Byte.parseByte(st.nextToken()) - 1);
		}

		@Override
		public String toString() {
			return "[" + row + ", " + col + "]";
		}
		
		
	}
}
