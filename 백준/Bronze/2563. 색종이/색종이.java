import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum = 0;
		
		int N = Integer.parseInt(br.readLine());
		
		int max_row = 0; 
		int max_col = 0;
		
		int[][] arr = new int[100][100];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			max_row = Math.max(max_row, row);
			max_col = Math.max(max_col, col);
			
			for(int y = row; y < row + 10; y++) {
				for(int x = col; x < col + 10; x++) {
					arr[y][x] = 1;
				}
			}
		}
				
		for (int i = 0; i < max_row + 10; i++) {
			for (int j = 0; j < max_col + 10; j++) {
				if(arr[i][j] == 1)
					sum += arr[i][j];
			}
		}
		
		System.out.println(sum);
		
	}
}