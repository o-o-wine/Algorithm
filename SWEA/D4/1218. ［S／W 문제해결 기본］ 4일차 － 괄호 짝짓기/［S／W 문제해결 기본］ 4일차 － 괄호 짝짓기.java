import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		int test_case = 1;
		
		for(; test_case <= T; test_case++) {
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			String temp = br.readLine();
			
			Stack<Character> s = new Stack<>();
			
			for (int i = 0; i < N; i++) {
				if(temp.charAt(i) == ')' && s.peek() == '(') 
					s.pop();
				else if(temp.charAt(i) == ']' && s.peek() == '[') 
					s.pop();
				else if(temp.charAt(i) == '}' && s.peek() == '{') 
					s.pop();
				else if(temp.charAt(i) == '>' && s.peek() == '<') 
					s.pop();
				else {
					s.push(temp.charAt(i));
				}
			}

			if(s.isEmpty())
				answer = 1;
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
