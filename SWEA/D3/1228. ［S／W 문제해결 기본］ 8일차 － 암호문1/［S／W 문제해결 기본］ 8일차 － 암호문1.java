import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt();
			
			LinkedList<Integer> arr = new LinkedList<>();			
			for(int i = 0; i < n; i++) {
				int num = sc.nextInt();
				arr.add(num);
			}

			int order = sc.nextInt();
			for(int i = 0; i < order; i++) {
				String l = sc.next();
				int idx = sc.nextInt();
				int num = sc.nextInt();
				
				for(int j = 0; j < num; j++) {
					arr.add(idx++, sc.nextInt());
				}
			}
			
			System.out.println("#" + test_case + " ");
			for(int i = 0; i < 10; i++) {
				System.out.print(arr.get(i) + " ");
			}
            System.out.println();
		}
	}
}
