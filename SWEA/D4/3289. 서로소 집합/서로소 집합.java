import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
 
public class Solution {
     
    static int n;
    static int[] parents;
     
    static void makeSet() {
        for(int i = 0; i <= n; i++) {
            parents[i] = i;
        }
    }
     
    static int find(int num) {
        if(num == parents[num]) return num;
        return parents[num] = find(parents[num]);
    }
     
    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
         
        if(pa != pb) 
            parents[pb] = pa;
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= T; tc++) {
            answer.append("#").append(tc).append(" ");
             
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
             
            parents = new int[n + 1];
             
            makeSet();
             
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int com = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                 
                if(com == 0) {  // union 연산
                    union(a, b);
                }
                else {  //같은 집합이면 1 아니면 0
                    if( find(a) == find(b)) 
                        answer.append("1");
                    else
                        answer.append("0");
                }
            }
             
            answer.append("\n");
        }
         
        System.out.println(answer.toString());
        br.close();
    }
 
}