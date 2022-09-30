

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static List<Integer>[] arr;
	static int [] ans;
	
	static void bfs(int start) {
		int temp;
		int cnt = 1;
		Queue<Integer> q = new LinkedList<>();
		
		visited[start] = true;
		q.offer(start);
		ans[start]= cnt;
		while (!q.isEmpty()) {
			temp = q.poll();//원점 정점
			for (int i = 0; i < arr[temp].size(); i++) {
				if (visited[arr[temp].get(i)] == false) {
					visited[arr[temp].get(i)] = true;
					cnt++;
					q.offer(arr[temp].get(i));
					ans[arr[temp].get(i)]=cnt;
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken())-1;
		
		int temp1, temp2;
		visited = new boolean[n];
		arr= new ArrayList[n];
		ans = new int [n];
		
		for (int i = 0; i < arr.length; i++) {
			 arr[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			temp1 =Integer.parseInt(st.nextToken())-1;
			temp2 =Integer.parseInt(st.nextToken())-1;
			arr[temp1].add(temp2);
			arr[temp2].add(temp1);
		}
		
		for(int i = 0; i<n;i++) {
			Collections.sort(arr[i]);
		}
		
		bfs(start);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

}
