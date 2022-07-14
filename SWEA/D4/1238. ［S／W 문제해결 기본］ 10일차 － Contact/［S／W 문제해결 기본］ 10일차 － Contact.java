import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++) {
			arr = new int[101][101];
			
			int N = sc.nextInt();
			int start = sc.nextInt();
			
			for(int i = 0; i < N / 2; i++) {
				arr[sc.nextInt()][sc.nextInt()] = 1;
			}
			
			System.out.println("#"+ test_case + " " + BFS(start));
		}
	}
	
	public static int BFS(int start) {
		int cnt = 0;
		int result = 0;
		int[] visited = new int[101];
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		visited[start] = 1;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for(int i = 1; i < 101; i++) {
				if(arr[current][i] == 1 && visited[i] == 0) {
					q.offer(i);
					visited[i] = visited[current] + 1;
				}				
			}
			cnt = visited[current];
		}
		
		for(int i = 1; i < 101; i++) {
			if (visited[i] == cnt)
				result = i;
		}
		
		return result;
	}
}
