
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[];
	static int four[] = new int[4];
	static int FF[] = new int [4];
	static int temp[];
	static int ans;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static void per(int cnt) {
		if(cnt == N-1) {
			for(int i = 0; i<N-1;i++) {
				if(temp[i] == 0) {
					ans += arr[i+1];
				}
				if(temp[i] == 1) {
					ans -= arr[i+1];
				}
				if(temp[i] == 2) {
					ans *= arr[i+1];
				}
				if(temp[i] == 3) {
					ans /= arr[i+1];
				}
			}
			//System.out.println(Arrays.toString(temp));
			max = max < ans ? ans : max;
			min = min > ans ? ans : min;
			ans=arr[0];
			return;
		}
		
		for(int i = 0; i<4; i++) {
			if(four[i] == FF[i]) {
				continue;
			}
			FF[i] = FF[i]+1;
			temp[cnt] = i;
			per(cnt+1);
			FF[i] = FF[i]-1;
		}
	}
	public static void main(String[] args) throws  IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 
		N = Integer.parseInt(bf.readLine());
		arr = new int [N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		ans = arr[0];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < 4; i++) {
			four[i] =Integer.parseInt(st.nextToken());
		}
		
		temp = new int [N-1];
		
		
		per(0);
		
		System.out.println(max);
		System.out.println(min);
	}

}
