import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 1;
			
			int[][] arr = new int[9][9];
			
			// input
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//row, col check
			for(int i = 0; i < 9; i++) {
				
				int[] rcheck = {0, 0, 0, 0, 0, 0, 0, 0, 0};
				int[] ccheck = {0, 0, 0, 0, 0, 0, 0, 0, 0};
				int r = 0, c = 0;
				
				for(int j = 0; j < 9; j++) {
					rcheck[arr[i][j] - 1] = 1;
					ccheck[arr[j][i] - 1] = 1;
				}
				
				for(int k = 0; k < 9; k++) {
					r += rcheck[k];
					c += ccheck[k];
				}
				
				if (r != 9 || c != 9) {
					answer = 0;
					break;
				}
			}
			
			// 3*3 Divide and conquer
			for (int i = 0; i < 9; i += 3) {				
				for (int j = 0; j < 9; j += 3) {
					
					int[] bcheck = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
					int b = 0;
					
					for (int x = i; x < i+3; x++) {
						for (int y = j; y < j+3; y++) {
							bcheck[arr[x][y] - 1] = 1;
						}
					}
					
					for(int k = 0; k < 9; k++) {
						b += bcheck[k];
					}
					
					if (b != 9) {
						answer = 0;
						break;
					}
				}
			}
			
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
