import java.util.Scanner;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('M', 1867);
            put('T', 1911);
            put('S', 1925);
            put('H', 1988);
            put('X', 2018);
        }};
        System.out.println(map.get(str.charAt(0)) + Integer.parseInt(str.substring(1)));
    }
}