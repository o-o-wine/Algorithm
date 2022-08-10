import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static int N, M, T;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			List<Integer> list = new ArrayList<>();
			List<Integer> listp = new ArrayList<>();
						
			N = sc.nextInt();
			M = sc.nextInt();

			for(int i = 1; i <= M; i++) {
				if(i > N)
					list.add(i);
			}
			
			for(int i = 1; i <= M - N; i++) {
				listp.add(i);
			}
			
			for(int i = 0;  i < list.size(); i++) {
				for(int j = 0; j < listp.size(); j++) {
					if(list.get(i) == listp.get(j)) {
						list.remove(i);
						listp.remove(j);
						i = 0;
						break;
					}
				}
			}
			
			long head = 1;
			for(int i : list) {
				head *= i;
			}
			long tail = 1;
			for(int i : listp) {
				tail *= i;
			}
			
			System.out.println(head/tail);

		}
	}
}
