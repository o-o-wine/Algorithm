import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			
			int T = sc.nextInt();
			
			for(int test_case = 1; test_case <= T; test_case++) {
				int[] arr1 = new int[20];
				int[] arr2 = new int[20];
				int max = 0;
				
				int fir = sc.nextInt();
				int sec = sc.nextInt();
				
				for(int i = 0; i < fir; i++) {
					arr1[i] = sc.nextInt();
				}
				
				for(int i = 0; i < sec; i++) {
					arr2[i] = sc.nextInt();
				}
				
				if (fir < sec) {
					for(int i = 0; i <= sec-fir; i++) {
						int sum = 0;
						for(int j = i; j < i + fir; j++) {
							sum += arr1[j-i] * arr2[j];							
						}
						
						if(sum > max) {
							max = sum;
						}
					}
				}
				else if (sec < fir) {
					for(int i = 0; i <= fir-sec; i++) {
						int sum = 0;
						for(int j = i; j < i + sec; j++) {
							sum += arr1[j] * arr2[j-i];
						}
						if(sum > max) {
							max = sum;
						}
					}
				}
				
				System.out.println("#" + test_case + " " + max);
			}
		}
}