import java.util.Scanner;

public class Main {
	public static int N, M, R;
	public static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		
		arr = new int[N][M];
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				arr[row][col] = sc.nextInt();
			}
		}
		
		for(int rt = 0; rt < R; rt++) {
			rotate();
		}
		
		// 출력
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	public static void rotate() {
		int Max = Math.min(N, M) / 2;
		
		for (int flag = 0; flag < Max; flag++) {
			int rowmax = N - flag - 1;
			int colmax = M - flag - 1;
			
			int temp = arr[flag][flag];

			for (int i = flag; i < colmax; i++) {
				arr[flag][i] = arr[flag][i + 1];
			}
			for (int i = flag; i < rowmax; i++) {
				arr[i][colmax] = arr[i + 1][colmax];
			}
			for (int i = colmax; i > flag; i--) {
				arr[rowmax][i] = arr[rowmax][i - 1];
			}
			for (int i = rowmax; i > flag; i--) {
				arr[i][flag] = arr[i - 1][flag];
			}
			
			arr[flag + 1][flag] = temp;
		}
	}
}
