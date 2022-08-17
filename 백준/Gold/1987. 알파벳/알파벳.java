import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int R, C, answer = 0;
	public static char[][] map;
	public static boolean[] alpha = new boolean[26];
	
	public static int dr[] = {0, 1, 0, -1};
	public static int dc[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];

		for(int row = 0; row < R; row++) {
			String str = br.readLine();
			for(int col = 0; col < C; col++) {
				 map[row][col] = str.charAt(col);
			}
		}
		
		DFS(0, 0, 0);
		
		System.out.println(answer + 1);
	}
	
	public static void DFS(int row, int col, int dist) {
		alpha[map[row][col] - 65] = true;		
		
		answer = Math.max(answer, dist);
		
		for(int i = 0; i < 4; i++) {
			int nrow = row + dr[i];
			int ncol = col + dc[i];
						
			if(!range_check(nrow, ncol)) {
				continue;
			}
			
			int tmp = map[nrow][ncol] - 65;
			
			if(alpha[tmp] == true) {
				continue;
			}
						
			alpha[tmp] = true;
			DFS(nrow, ncol, dist + 1);
			alpha[tmp] = false;
		}
	}
	
	public static boolean range_check(int r, int c) {
		if(r < 0 || R <= r || c < 0 || C <= c) {
			return false;
		}
		return true;
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

