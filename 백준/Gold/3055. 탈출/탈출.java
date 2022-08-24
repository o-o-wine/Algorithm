import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    
    public static Queue<int[]> q = new LinkedList<>();;
    public static Queue<int[]> water = new LinkedList<>();;
    
    public static int R, C;
    
    public static char[][] map;
    public static int[][] count;
    
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        count = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    q.add(new int[] {i, j, 0} );
                }
                else if(map[i][j] == '*'){
                    water.add(new int[] {i,j} );
                }
            }
        }
        
        bfs();
        
        if(answer == Integer.MAX_VALUE) {
        	System.out.println("KAKTUS");
        }
        else
        	System.out.println(answer);


    }

    public static void bfs() {

        while (!q.isEmpty()) {
        	
        	// 물
            int len = water.size();
            
            for(int i = 0; i < len; i++){
                int[] tmp = water.poll();
                int r = tmp[0];
                int c = tmp[1];
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (range_check(nr, nc) && map[nr][nc] == '.') {
                        map[nr][nc] = '*';
                        water.add(new int[] {nr, nc} );
                    }
                }
            }

            // 고슴 치
            len = q.size();
            
            for(int i = 0; i < len; i++){
                int[] tmp = q.poll();
                int r = tmp[0];
                int c = tmp[1];
                int time = tmp[2];
                
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (range_check(nr, nc)) {
                    	
                        if(map[nr][nc]=='D'){
                            answer = Math.min(answer,time+1);
                            return;
                        }
                        else if(map[nr][nc] == '.'){
                            map[nr][nc] = 'S';
                            q.add(new int[] {nr, nc, time+1});
                        }
                    }
                }
            }
        }
    }
    
    public static boolean range_check(int r, int c) {
    	if(r < 0 || R <= r || c < 0 || C <= c) {
    		return false;
       	}
    	return true;
    }
}
