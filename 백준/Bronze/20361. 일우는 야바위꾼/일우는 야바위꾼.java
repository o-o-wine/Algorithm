import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 이분 탐색을 쓰라는 문제인지 궁금함.
		// 해당 문제 경우의 이분탐색은 오히려 느림.
		// 단순 구현이 빠름
		

	
			// N, X, K 값을 받음
			StringTokenizer st = new StringTokenizer(br.readLine());
			// N입력 - 종이컵의 개수
			int N = Integer.parseInt(st.nextToken());
			// X입력 - 처음 종이컵 위치
			int X = Integer.parseInt(st.nextToken());
			// K입력 - 종이컵 바꾸는 횟수
			int K = Integer.parseInt(st.nextToken());
			
			// 종이컵이 바뀌는 횟수를 체크하기 위함
			for(int change = 0; change < K; change++) {
				// 바꾸는 위치 받기
				st = new StringTokenizer(br.readLine());
				// 바꿀 대상1
				int now = Integer.parseInt(st.nextToken());
				// 바꿀 대상2
				int next = Integer.parseInt(st.nextToken());
				
				// 바꿀 대상1이 정답 종이컵이랑 같은 경우
				if(now == X) {
					// 바꿀 대상1을 정답 종이컵으로 교환
					X = next;
				}
				// 바꿀 대상2이 정답 종이컵이랑 같은 경우
				else if(next == X) {
					// 바꿀 대상2를 정답 종이컵으로 교환
					X = now;
				}
			}
			
			System.out.println(X);
		
	}
}