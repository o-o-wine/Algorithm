import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, row, col, answer = 0;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		N = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		search(0, 0, (int)Math.pow(2, N));
	}
	
	public static void search(int r, int c, int size) {
		if(r == row && c == col) {
			System.out.println(answer);
			System.exit(0);
		}
		else if(row < r + size && r <= row && col < c + size && c <= col) {
			search(r, c, size / 2);
			search(r, c + size / 2, size / 2);
			search(r + size / 2, c, size / 2);
			search(r + size / 2, c + size / 2, size / 2);
		}
		else {
			answer += size * size;
		}
	}
}