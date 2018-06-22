import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BfferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put('C', 'G'); put('P', 'C'); put('G', 'P'); 
        }};
        String str = br.readLine();
        Deque<Character> que = new ArrayDeque<>();

        for(char ch: str.toCharArray()) {
            if(que.size() > 0 && que.peek().equals(map.get(ch))) {
                que.pop();
            }else {
                que.push(ch);
            }
        }
        System.out.println(que.size());
    }
}