import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int dr[] = {-1, 0, 1};
	public static int dc[] = {1, 1, 1};
	
	public static int R, C, answer = 0;
	public static boolean arrival;
	public static char[][] map;
	public static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for(int row = 0; row < R; row++) {
			String str = br.readLine();
			for(int col = 0; col < C; col++) {
				map[row][col] = str.charAt(col);
			}
		}
		
		for(int check = 0; check < R; check++) {
			arrival = false;
			DFS(check, 0);
		}
		
		System.out.println(answer);
	}	
	
	public static void DFS(int row, int col) {
		visit[row][col] = true;
		
		if(col == C - 1) {
			answer++;
			arrival = true;
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			int nrow = row + dr[i];
			int ncol = col + dc[i];
			
			if(!range_check(nrow, ncol) || visit[nrow][ncol] || map[nrow][ncol] == 'x') {
				continue;
			}
			
			DFS(nrow, ncol);
			if(arrival) return;
		}
	}
	
	public static boolean range_check(int row, int col) {
		if(row < 0 || R <= row || col < 0 || C <= col) {
			return false;
		}
		return true;
	}
}

