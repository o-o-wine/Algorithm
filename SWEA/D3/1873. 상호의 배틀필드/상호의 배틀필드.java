import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	// 맵 크기
	public static int row = 0;
	public static int col = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp;
		
		// 테스트 케이스 받기
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int action_num = 0;
			String action;
			// 전차 방향
			int dir = 0;
			int r = 0;
			int c = 0;
			
			// 행 열 받기
			tmp = br.readLine();
			StringTokenizer st = new StringTokenizer(tmp);
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());

			char[][] map = new char[row][col];
			
			// 맵 받기
			for(int i = 0; i < row; i++) {
				tmp = br.readLine();
				for(int j = 0; j < col; j++) {
					map[i][j] = tmp.charAt(j);
					// 탱크 좌표 찾기
					if(tmp.charAt(j) == '^' || tmp.charAt(j) == 'v' || tmp.charAt(j) == '<' || tmp.charAt(j) == '>') {
						if(tmp.charAt(j) == '^') {
							dir = 0;
						}
						else if(tmp.charAt(j) == 'v') {
							dir = 1;
						}
						else if(tmp.charAt(j) == '<') {
							dir = 2;
						}
						else if(tmp.charAt(j) == '>') {
							dir = 3;
						}
						
						r = i; c = j;
					}						
				}
			}
			
			// 전차 움직임 입력받기
			action_num = Integer.parseInt(br.readLine());
			
			action = br.readLine();
			
			for(int move = 0; move < action_num; move++) {
				switch (action.charAt(move)) {
				// 위로
				case 'U' :
					dir = 0;
					if (range_check(r - 1, c) && map[r - 1][c] == '.') {
						map[r][c] = '.';
						map[r - 1][c] = '^';
						r -= 1;
					}
					else {
						map[r][c] = '^';
					}
					break;
				
				// 아래로
				case 'D' :
					dir = 1;
					if (range_check(r + 1, c) && map[r + 1][c] == '.') {
						map[r][c] = '.';
						map[r + 1][c] = 'v';
						r += 1;
					}
					else {
						map[r][c] = 'v';
					}
					break;
				
				// 좌로
				case 'L' :
					dir = 2;
					if (range_check(r, c - 1) && map[r][c - 1] == '.') {
						map[r][c] = '.';
						map[r][c - 1] = '<';
						c -= 1;
;	
					}
					else {
						map[r][c] = '<';
					}
					break;
				
				// 우로
				case 'R' :
					dir = 3;
					if (range_check(r, c + 1) && map[r][c + 1] == '.') {
						map[r][c] = '.';
						map[r][c + 1] = '>';
						c += 1;
					}
					else {
						map[r][c] = '>';
					}
					break;
				
				// 발사
				case 'S' :
					switch(dir) {
					case 0 :
						for(int i = r - 1; i >= 0; i--) {
							if(map[i][c] == '*') {
								map[i][c] = '.';
								break;
							}
							if(map[i][c] == '#') {
								break;
							}
						}
						break;
					case 1 :
						for(int i = r + 1; i < row; i++) {
							if(map[i][c] == '*') {
								map[i][c] = '.';
								break;
							}
							if(map[i][c] == '#') {
								break;
							}
						}
						break;
					case 2 :
						for(int i = c - 1; i >= 0; i--) {
							if(map[r][i] == '*') {
								map[r][i] = '.';
								break;
							}
							if(map[r][i] == '#') {
								break;
							}
						}
						break;
					case 3 :
						for(int i = c + 1; i < col; i++) {
							if(map[r][i] == '*') {
								map[r][i] = '.';
								break;
							}
							if(map[r][i] == '#') {
								break;
							}
						}
						break;
					}
					break;
				}
			}
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < row; i++) {
				System.out.println(map[i]);
			}
		}
	}
	
	public static boolean range_check(int r, int c) {
		if(r >= 0 && r < row && c < col && c >= 0)
			return true;
		return false;
	}
}
