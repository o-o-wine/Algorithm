import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			
			int T = sc.nextInt();
			
			for(int test_case = 1; test_case <= T; test_case++) {
				int[][] arr = new int[17][17];
				int answer = 0;
				int arr_size = sc.nextInt();
				int word_size = sc.nextInt();
				
				// 초기화
				for(int i = 0; i < 17; i++) {
					for (int j = 0; j < 17; j++) {
						arr[i][j] = 0;
					}
				}
				
				// 입력받기
				for(int i = 1; i <= arr_size; i++) {
					for (int j = 1; j <= arr_size; j++) {
						arr[i][j] = sc.nextInt();
					}
				}
				
				// 확인 
				for(int i = 1; i <= arr_size; i++) {
					for (int j = 1; j <= arr_size; j++) {
						if(arr[i][j] == 1) {
							//가로
                            if(j-1 >= 0 && j + word_size <= 16) {
								if(arr[i][j-1] == 0 && arr[i][j+word_size] == 0) {
									for(int r = j; r < j + word_size; r++) {
										if(arr[i][r] != 1)
											break;
									
										if (r == j + word_size - 1)
											answer++;
									}
								}
                            }
							// 세로
                            if(i-1 >= 0 && i + word_size <= 16) {
								if(arr[i-1][j] == 0 && arr[i+word_size][j] == 0) {
									for(int c = i; c < i + word_size; c++) {
										if(arr[c][j] != 1)
											break;
										
										if (c == i + word_size - 1)
											answer++;
									}
								}
							}
                    	}
					}
				}				
				
				System.out.println("#" + test_case + " " + answer);
			}
		}
}