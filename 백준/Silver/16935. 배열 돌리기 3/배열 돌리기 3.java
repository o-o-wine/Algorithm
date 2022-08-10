import java.util.Scanner;

public class Main {
	public static int N, M, R;
	public static int[][] arr;
	public static int[][] temp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		
		arr = new int[100][100];
		temp = new int[100][100];
		
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				arr[row][col] = sc.nextInt();
			}
		}
		
		for(int rt = 0; rt < R; rt++) {
			switch(sc.nextInt()) {
			case 1:
				rotate1();
				break;
			case 2:
				rotate2();
				break;
			case 3:
				rotate3();
				break;
			case 4:
				rotate4();
				break;
			case 5:
				rotate5();
				break;
			case 6:
				rotate6();
				break;
			}
			
		}
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}
	
//	public static void rotate() {
//		int Max = Math.min(N, M) / 2;
//		
//		for (int flag = 0; flag < Max; flag++) {
//			int rowmax = N - flag - 1;
//			int colmax = M - flag - 1;
//			
//			int temp = arr[flag][flag];
//
//			for (int i = flag; i < colmax; i++) {
//				arr[flag][i] = arr[flag][i + 1];
//			}
//			for (int i = flag; i < rowmax; i++) {
//				arr[i][colmax] = arr[i + 1][colmax];
//			}
//			for (int i = colmax; i > flag; i--) {
//				arr[rowmax][i] = arr[rowmax][i - 1];
//			}
//			for (int i = rowmax; i > flag; i--) {
//				arr[i][flag] = arr[i - 1][flag];
//			}
//			
//			arr[flag + 1][flag] = temp;
//		}
//	}
	
	public static void rotate1() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				temp[r][c] = arr[N - 1 - r][c];
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				arr[r][c] = temp[r][c];
			}
		}
	}
	
	public static void rotate2() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				temp[r][c] = arr[r][M - 1 - c];
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				arr[r][c] = temp[r][c];
			}
		}
	}
	
	public static void rotate3() {
		int tmp = N;
		N = M;
		M = tmp;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				temp[r][c] = arr[M - 1 - c][r];
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				arr[r][c] = temp[r][c];
			}
		}
	}
	
	public static void rotate4() {
		int tmp = N;
		N = M;
		M = tmp;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				temp[r][c] = arr[c][N - 1 - r];
			}		
		}	
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				arr[r][c] = temp[r][c];
			}
		}
	}
	
	public static void rotate5() {
		int colmax = M / 2;
		int rowmax = N / 2;
		
		for(int r = 0; r < rowmax; r++) {
			for(int c = 0; c < colmax; c++) {
				temp[r][c] = arr[r + rowmax][c];
			}
		}
		for(int r = 0; r < rowmax; r++) {
			for(int c = colmax; c < M; c++) {
				temp[r][c] = arr[r][c - colmax];
			}
		}
		for(int r = rowmax; r < N; r++) {
			for(int c = 0; c < colmax; c++) {
				temp[r][c] = arr[r][c + colmax];
			}
		}
		for(int r = rowmax; r < N; r++) {
			for(int c = colmax; c < M; c++) {
				temp[r][c] = arr[r - rowmax][c];
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				arr[r][c] = temp[r][c];
			}
		}
	}
	
	public static void rotate6() {
		int colmax = M / 2;
		int rowmax = N / 2;
		
		for(int r = 0; r < rowmax; r++) {
			for(int c = 0; c < colmax; c++) {
				temp[r][c] = arr[r][c + colmax];
			}
		}
		for(int r = 0; r < rowmax; r++) {
			for(int c = colmax; c < M; c++) {
				temp[r][c] = arr[r + rowmax][c];
			}
		}
		for(int r = rowmax; r < N; r++) {
			for(int c = 0; c < colmax; c++) {
				temp[r][c] = arr[r - rowmax][c];
			}
		}
		for(int r = rowmax; r < N; r++) {
			for(int c = colmax; c < M; c++) {
				temp[r][c] = arr[r][c - colmax];
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				arr[r][c] = temp[r][c];
			}
		}		
	}
}
