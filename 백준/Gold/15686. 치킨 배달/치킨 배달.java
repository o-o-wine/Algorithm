import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 15686
// 해야할 거 
// 치킨집 개수 구하기
// 치킨집 개수를 바탕으로 조합 (치킨집 개수 N 남을 치킨집)
// 집의 개수
// 남은 치킨집 조합으로 최소 거리 구해주기
// 사용할 알고리즘 DFS, 조합

public class Main {
	public static int N, M, answer;
	public static int min = Integer.MAX_VALUE;
	public static List<Pair> home_list;
	public static List<Pair> chicken_list;
	public static int[][] dist;
	public static int[] order;
	public static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		home_list = new ArrayList<>();
		chicken_list = new ArrayList<>();	
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c] == 1) {
					home_list.add(new Pair(r, c));
				}
				else if(arr[r][c] == 2) {
					chicken_list.add(new Pair(r, c));
				}
			}
		}
		
		dist = new int[chicken_list.size()][home_list.size()];
		order = new int[chicken_list.size()];
		visit = new boolean[chicken_list.size()];
		answer = Integer.MAX_VALUE;
		
		for(int r = 0; r < chicken_list.size(); r++) {
			for(int c = 0; c < home_list.size(); c++) {
				dist[r][c] = Math.abs(chicken_list.get(r).row - home_list.get(c).row) + Math.abs(chicken_list.get(r).col - home_list.get(c).col); 
			}
		}
		
		combination(visit, 0, chicken_list.size(), M);
		
		System.out.println(answer);
	}


	static void combination(boolean[] visit, int start, int n, int r) {
		if (r == 0) {
			int sum = 0;
			
			for (int i = 0; i < home_list.size(); i++) {
				int min = Integer.MAX_VALUE;
				
				for (int j = 0; j < chicken_list.size(); j++) {
					if (visit[j] == true) {
						min = Math.min(min, dist[j][i]);
					}
				}
				
				sum += min;
			}
			
			answer = Math.min(sum, answer);
			
			
			return;
		} 
		
		else {
			for (int i = start; i < n; i++) {
				visit[i] = true;
				combination(visit, i + 1, n, r - 1);
				visit[i] = false;
			}
		}
	}

	static class Pair {
		int row;
		int col;
		
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}

