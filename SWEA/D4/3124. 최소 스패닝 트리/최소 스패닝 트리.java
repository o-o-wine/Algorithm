import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int V, E;
	static long answer;
	static int[] parent;
	static int[][] graph;
		    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
	
			// 정점의 수
			V = Integer.parseInt(st.nextToken());
			// 간선의 수
			E = Integer.parseInt(st.nextToken());
			
			// 1번째 노드, 2번째 노드, 간선 가중치
			graph = new int[E][3];
			// 정점 배열
			parent = new int[V];
			// answer 초기화
			answer = 0;
			
			makeSet();
			
			// 입력 받기
			for(int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				// 노드 2개 받고 간선 가중치 저장
				graph[e][0] = Integer.parseInt(st.nextToken());
				graph[e][1] = Integer.parseInt(st.nextToken());
				graph[e][2] = Integer.parseInt(st.nextToken());
			}
			
			// 내림차순으로 정렬
			Arrays.sort(graph, (o1, o2) -> (Integer.compare(o1[2], o2[2])));
			
			for(int cnt = 0; cnt < E; cnt++) {
				// 두 노드의 부모가 같지 않다면
				if(find(graph[cnt][1] - 1) != find(graph[cnt][0] - 1)) {
					// 같은 세트로 묶이게 하고
					union(graph[cnt][0] - 1, graph[cnt][1] - 1);
					// 가중치를 최소 비용 변수에 추가하도록 한다
					answer += graph[cnt][2];
					// 그리고 continue;
					continue;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}

	static void makeSet() {
		for(int i = 0; i < V; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int num) {
		if(num == parent[num]) 
			return num;
		return parent[num] = find(parent[num]);
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
//		if(pa != pb) 
//			parents[pb] = pa;
		
		if(a < b) 
			parent[pb] = pa; 
		else 
			parent[pb] = pa;
		
	}
}

