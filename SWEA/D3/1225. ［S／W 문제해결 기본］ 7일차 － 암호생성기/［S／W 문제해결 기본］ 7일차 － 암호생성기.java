import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		int test_case = 1;
		
		for(; test_case <= T; test_case++) {
			int cnt = 1;
			int case_num = Integer.parseInt(br.readLine());			
			String temp = br.readLine();
			StringTokenizer st = new StringTokenizer(temp);
			Queue<Integer> q = new LinkedList<>();
			
			
			for (int i = 0; i < 8; i++) {
				int n =Integer.parseInt(st.nextToken());
				q.add(n);
			}
		
			int tmp;
			while(true) {
				tmp = q.poll() - cnt;
				
				if(tmp <= 0) {
					tmp = 0;
					q.add(tmp);
					break;
				}
				
				q.add(tmp);
				
				if(cnt >= 5) {
					cnt = 1;
				}
				else
					cnt++;
			}

			
			System.out.print("#" + case_num + " ");
			for(int i = 0; i < 8; i++) {
				System.out.print(q.poll() + " ");
			}
            System.out.println();
		}
	}
}
