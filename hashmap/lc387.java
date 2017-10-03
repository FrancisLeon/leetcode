import java.util.Map;
import java.util.HashMap;
public class lc387 {
    public static int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }

        int res = -1;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character c : chars) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                res = i;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int res = firstUniqChar("leetcode");
        System.out.println(res);
    }
}