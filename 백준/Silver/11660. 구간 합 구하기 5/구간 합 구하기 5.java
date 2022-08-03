import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		StringTokenizer st = new StringTokenizer(tmp);
		int N = Integer.parseInt(st.nextToken());
		int op = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];
		int[][] dp = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			tmp = br.readLine();
			st = new StringTokenizer(tmp);
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]+ arr[i][j];
			}
		}

		for (int i = 0; i < op; i++) {
			tmp = br.readLine();
			st = new StringTokenizer(tmp);
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			System.out.println((dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]));
		}
	}

}