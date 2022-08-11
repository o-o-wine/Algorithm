import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static int MAX_room = -1;
	public static int MAX_depth = -1;
	public static int N;
	public static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			arr = new int[N][N];
			MAX_room = -1;
			MAX_depth = -1;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					BFS(i, j);
				}
			}
			
			System.out.println("#" + tc + " " + MAX_room + " " + MAX_depth);
		}
	}

	public static void BFS(int row, int col) {
		Queue<Pair> q = new LinkedList<>();
		
		int depth = 1;
		
		q.add(new Pair(row, col));
		
		while(!q.isEmpty()) {
			int[] dr = {1, 0, -1, 0};
			int[] dc = {0, 1, 0, -1};
			
			int cr = q.peek().row;
			int cc = q.peek().col;
			
			q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
					continue;
				}
				
				if(arr[nr][nc] == arr[cr][cc] + 1) {
					q.add(new Pair(nr, nc));
					depth++;
				}
			}
		}
		
		if(MAX_depth < depth) {
			MAX_depth = depth;
			MAX_room = arr[row][col];
		}
		else if(MAX_depth == depth) {
			if(MAX_room > arr[row][col]) {
				MAX_depth = depth;
				MAX_room = arr[row][col];
			}
		}
		//System.out.println(MAX_room + " " + MAX_depth);
	}
}

class Pair {
	int row;
	int col;
	
	public Pair(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

