import java.util.Scanner;

public class Solution
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			
			int[][] arr = new int[7][7];
			int N = sc.nextInt();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			System.out.println("#" + test_case);
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(arr[N-j-1][i]);
				}
				System.out.print(" ");
				for(int j = 0; j < N; j++) {
					System.out.print(arr[N-i-1][N-j-1]);
				}
				System.out.print(" ");
				for(int j = 0; j < N; j++) {
					System.out.print(arr[j][N-i-1]);
				}
				System.out.println();
			}
		}
	}
}