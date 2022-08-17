import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static int[] dr = {0, -1, 0, 1, 0};
	public static int[] dc = {0, 0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());

			Pair AP = new Pair(1, 1);
			Pair BP = new Pair(10, 10);
			List<Integer> A_list = new ArrayList<>();
			List<Integer> B_list = new ArrayList<>();

			int[] A_Move = new int[M];
			int[] B_Move = new int[M];
			int[] sum = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				A_Move[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B_Move[i] = Integer.parseInt(st.nextToken());
			}

			AC[] ac_list = new AC[A];

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				ac_list[i] = new AC(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			int answer = 0;
			int AM = 0, BM = 0;
			// 시작 단계엣 체크
			for (int i = 0; i < A; i++) {
				// A체크
				if (ac_list[i].range >= Math.abs(ac_list[i].row - AP.row) + Math.abs(ac_list[i].col - AP.col)) {
					A_list.add(ac_list[i].num);
					AM = Math.max(AM, ac_list[i].ac);
				}
				// B체크
				if (ac_list[i].range >= Math.abs(ac_list[i].row - BP.row) + Math.abs(ac_list[i].col - BP.col)) {
					B_list.add(ac_list[i].num);
					BM = Math.max(BM, ac_list[i].ac);
				}
			}
			
			int MAX_AC = 0;
			
			if(A_list.size() == 0) {
				if(B_list.size() == 0)
					MAX_AC = 0;
				else
					MAX_AC = BM;
			}
			if(B_list.size() == 0) {
				if(A_list.size() == 0)
					MAX_AC = 0;
				else
					MAX_AC = AM;
			}
			
			for(int i = 0; i < A_list.size(); i++) {
				for(int j = 0; j < B_list.size(); j++) {
					if(A_list.get(i) == B_list.get(j)) {
						MAX_AC = Math.max(MAX_AC, ac_list[B_list.get(j)].ac);
					}
					else {
						MAX_AC = Math.max(MAX_AC, ac_list[A_list.get(i)].ac +ac_list[B_list.get(j)].ac);
					}
				}
			}				
			
			answer += MAX_AC;

			A_list.clear();
			B_list.clear();

			for (int move = 0; move < M; move++) {
				// 움직이고
				AP.change(A_Move[move]);
				BP.change(B_Move[move]);
				
				AM = 0; BM = 0;
				// 충전소 check 범위안이면 sum에 추가
				for (int i = 0; i < A; i++) {
					// A체크
					if (ac_list[i].range >= Math.abs(ac_list[i].row - AP.row) + Math.abs(ac_list[i].col - AP.col)) {
						A_list.add(ac_list[i].num);
						AM = Math.max(AM, ac_list[i].ac);
					}
					// B체크
					if (ac_list[i].range >= Math.abs(ac_list[i].row - BP.row) + Math.abs(ac_list[i].col - BP.col)) {
						B_list.add(ac_list[i].num);
						BM = Math.max(BM, ac_list[i].ac);
					}					
				}
				
				MAX_AC = 0;
				if(A_list.size() == 0) {
					if(B_list.size() == 0)
						MAX_AC = 0;
					else
						MAX_AC = BM;
				}
				if(B_list.size() == 0) {
					if(A_list.size() == 0)
						MAX_AC = 0;
					else
						MAX_AC = AM;
				}
				
				for(int i = 0; i < A_list.size(); i++) {
					for(int j = 0; j < B_list.size(); j++) {
						if(A_list.get(i) == B_list.get(j)) {
							MAX_AC = Math.max(MAX_AC, ac_list[B_list.get(j)].ac);
						}
						else {
							MAX_AC = Math.max(MAX_AC, ac_list[A_list.get(i)].ac + ac_list[B_list.get(j)].ac);
						}
					}
				}				
				
				answer += MAX_AC;

				A_list.clear();
				B_list.clear();
			}

			System.out.println("#" + tc + " " + answer);
		}
	}
	
	static class AC {
		int num;
		int row;
		int col;
		int range;
		int ac;
		
		public AC(int num, int col, int row, int range, int ac) {
			this.num = num;
			this.row = row;
			this.col = col;
			this.range = range;
			this.ac = ac;
		}
	}
	
	static class Pair {
		int row;
		int col;
		
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		public void change(int dir) {
			if(dir == 0) {
				;
			}
			else if(dir == 1) {
				this.row += dr[1];
				this.col += dc[1];
			}
			else if(dir == 2) {
				this.row += dr[2];
				this.col += dc[2];
			}
			else if(dir == 3) {
				this.row += dr[3];
				this.col += dc[3];
			}
			else if(dir == 4) {
				this.row += dr[4];
				this.col += dc[4];
			}
		}
	}
}
