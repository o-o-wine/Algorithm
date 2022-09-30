
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static long N;
	static long []dis;
	static long []citygas;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(bf.readLine());
		dis = new long[(int) (N-1)];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N-1; i++) {
			dis[i] = Long.parseLong(st.nextToken());
		}
		citygas = new long [(int) N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			citygas[i] = Long.parseLong(st.nextToken());
		}

		Queue<Long[]> pq= new PriorityQueue<>((ob1,ob2)-> {
			return (int) (ob1[1]-ob2[1]);
		} );
		
		for (long i = 0; i < N-1; i++) {
			pq.add(new Long[] {i,citygas[(int) i]});
		}
		
		Long[] temp = new Long [2];
		long tempdis = 0;
		long ans = 0;
		long check = N-1;

		while(true) {
			temp = pq.poll();
			while(check<temp[0]) {
				temp = pq.poll();
			}
			for (long i = temp[0]; i < check; i++) {
				tempdis += dis[(int) i];
			}
			ans += tempdis*temp[1];
			tempdis = 0;
			check = temp[0];
			if (check == 0) {
				break;
			}
		}
		
		System.out.println(ans);
	}

}
