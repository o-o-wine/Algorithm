import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int cnt = 1;
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> qp = new LinkedList<>();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		while(!q.isEmpty()) {
			if(cnt == K) {
				sb.append(q.poll() + ", ");
				cnt = 1;
			}
			else {
				cnt++;
				q.add(q.poll());
			}
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		
		System.out.println(sb);
	}
}
