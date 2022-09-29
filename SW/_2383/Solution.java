package SW._2383;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	//각 사람과 계단의 좌표를 List에 저장한다.
	//각 사람의 좌표에서 각 계단의 좌표까지의 거리도 저장한다.
	//각 계단을 통해 모든 사람이 내려가는데 까지 걸리는 시간을 구한다.
	static List<Person> personList;
	static Stair[] stairs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] arr = new int[N][N];
			personList = new ArrayList<>();
			stairs = new Stair[2];
			int stairCnt = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 1) personList.add(new Person(i, j));
					if(arr[i][j] > 1) stairs[stairCnt++] = new Stair(i, j, arr[i][j]); 
				}
			}
			//각 사람들이 두 계단까지의 거리가 얼마인지 저장
			for (Person person : personList) {
				person.toStair[0] = Math.abs(person.row - stairs[0].row) + Math.abs(person.col - stairs[0].col); 
				person.toStair[1] = Math.abs(person.row - stairs[1].row) + Math.abs(person.col - stairs[1].col); 
			}
			//각 사람들이 두 계단 중 어디로 갈지 dfs로 결정
			ans = Integer.MAX_VALUE;
			dfs(0);
			System.out.println("#" + tc + " "+ ans);
		}
	}
	static int n, ans;
	static int cntcnt = 0;
	//각 사람들이 둘 중 어느 계단으로 갈 지 결정하는 dfs
	static void dfs(int depth) {
		if(depth == personList.size()) {
			//각 계단으로 모두 이동하면
			int time = 0;
			//각 계단을 모두 내려가는데 걸리는 시간을 계산
			for (n = 0; n <= 1; n++) {
				int[] tmp = new int[stairs[n].people.size()];
				for (int i = 0; i < tmp.length; i++) {
					tmp[i] = stairs[n].people.get(i).toStair[n];
				}
				Arrays.sort(tmp);
				for (int i = 0; i < tmp.length; i++) {
					if(i >= 3) {
						tmp[i] = Math.max(tmp[i] + 1, tmp[i - 3]) + stairs[n].length;
					} else {
						tmp[i] += stairs[n].length + 1;
					}
				}
				if(tmp.length == 0) continue;
				time = Math.max(time, tmp[tmp.length - 1]);
			}
			ans = Math.min(ans, time);
			return;
		} 
		stairs[0].people.add(personList.get(depth));
		dfs(depth + 1);
		stairs[0].people.remove(stairs[0].people.size() - 1);
		stairs[1].people.add(personList.get(depth));
		dfs(depth + 1);
		stairs[1].people.remove(stairs[1].people.size() - 1);
	}
	//계단의 위치를 저장할 클래스
	static class Stair {
		int row;
		int col;
		int length;
		List<Person> people;
		public Stair(int row, int col, int length) {
			this.row = row;
			this.col = col;
			this.length = length;
			this.people = new ArrayList<>();
		}
	}
	//사람의 위치를 저장할 클래스
	static class Person{
		int row;
		int col;
		int[] toStair;
		public Person(int row, int col) {
			this.row = row;
			this.col = col;
			toStair = new int[2];
		}
		@Override
		public String toString() {
			return "Person [row=" + row + ", col=" + col + "]";
		}
		
	}
	
}
