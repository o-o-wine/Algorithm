import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			
			int[][] arr = new int[15][15];
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i <= N - M; i++) {
				for(int j = 0; j <= N - M; j++) {
					int sum = 0;
					for(int x = i; x < M + i; x++) {
						for(int y = j; y < M + j; y++) {
							sum += arr[x][y];
						}
					}
					if (sum > max) {
						max = sum;
					}
				}
			}
			answer = max;
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}