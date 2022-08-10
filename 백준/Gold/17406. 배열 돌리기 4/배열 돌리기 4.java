import java.io.IOException;
import java.util.Scanner;

public class Main {
	// direction control
	public static int[] dr = { 1, 0, -1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };
	
	// input val
	public static int N;
	public static int M;
	public static int R;
	
	//answer
	public static int answer = Integer.MAX_VALUE;

    // min value check
	public static int calc(int[][] arr) {
		int min = Integer.MAX_VALUE;

		for (int r = 0; r < N; r++) {
			int sum = 0;
			for (int c = 0; c < M; c++) {
				sum += arr[r][c];
			}
			min = Math.min(min, sum);
		}
		return min;
	}
    
    // copy array
	public static void copy(int[][] from, int[][] to) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				to[i][j] = from[i][j];
	}

    // rotate
	public static int[][] rotation(int[][] arr, int[][] command, int[] order) {
		int[][] arrp = new int[N][M];
		
		copy(arr, arrp);
		
		for (int i = 0; i < R; i++) {
			int r = command[order[i] - 1][0];
			int c = command[order[i] - 1][1];
			int s = command[order[i] - 1][2];

			for (int k = 1; k <= s; k++) {
				int dir = 0;
				int cr = r - k;
				int cc = c - k;

				int temp = arrp[cr][cc];
				for (int cnt = 1; cnt <= k * 8; ++cnt) {
					arrp[cr][cc] = arrp[cr + dr[dir]][cc + dc[dir]];

					cr += dr[dir];
					cc += dc[dir];

					if (cnt % (2 * k) == 0)
						dir = (++dir) % 4;
				}
				arrp[cr][cc + 1] = temp;
			}
		}
		return arrp;
	}

    // DFS combination
	public static void DFS(int[][] arr, int[][] command, int[] order, int cnt) {
		if (cnt == R + 1) {
			answer = Math.min(answer, calc(rotation(arr, command, order)));
			return;
		}

		for (int i = 0; i < R; i++) {
			if (order[i] == 0) {
				order[i] = cnt;
				DFS(arr, command, order, cnt + 1);
				order[i] = 0;
			}
		}

	}

    // main emthod
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        int[][] command = new int[R][];
        int[][] arr = new int[N][M];
        int[] order = new int[R];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                arr[i][j] = sc.nextInt();
        }
       
        for (int i = 0; i < R; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();

            command[i] = new int[] { r - 1, c - 1, s };
        }

        DFS(arr, command, order, 1);
        
        System.out.println(answer);
	}

}