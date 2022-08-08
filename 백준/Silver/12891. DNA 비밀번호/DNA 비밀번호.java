import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    static int answer;
    static String str;
    static Map<Character, Integer> rq;

    public static void main(String[] args) throws IOException {

        answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int entire = Integer.parseInt(st.nextToken());
        int part = Integer.parseInt(st.nextToken());
        str = br.readLine();

        rq = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        rq.put('A', -Integer.parseInt(st.nextToken()));
        rq.put('C', -Integer.parseInt(st.nextToken()));
        rq.put('G', -Integer.parseInt(st.nextToken()));
        rq.put('T', -Integer.parseInt(st.nextToken()));

        addInRange(0, part);

        int left = 0;
        int right = part;
        while (true) {
            check();
            if (right >= entire) {
                break;
            }
            removeInRange(left, left + 1);
            addInRange(right, right + 1);
            left++;
            right++;
        }

        System.out.println(answer);
    }

    public static void check() {
        for (Integer value : rq.values()) {
            if (value < 0) {
                return;
            }
        }
        answer++;
    }

    public static void addInRange(int start, int end) {
        for (int i = start; i < end; i++) {
            rq.compute(str.charAt(i), (character, integer) -> integer + 1);
        }
    }

    public static void removeInRange(int start, int end) {
        for (int i = start; i < end; i++) {
            rq.compute(str.charAt(i), (character, integer) -> integer - 1);
        }
    }

}