import java.util.HashMap;

/**
 * Created by yjin on 8/11/16.
 */
public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        //a good code can be found at
        //https://discuss.leetcode.com/topic/6592/three-o-n-concise-implemetation-according-to-leetcode-oj-discuss
        HashMap<Character, int[]> map = new HashMap<Character, int[]>();
        //int[] is a length 2 array, the first is required, next is we have now
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c))
                map.get(c)[0]++;
            else {
                int[] array = {1, 0};
                map.put(c, array);
            }
        }
        //find first qualify
        int required = map.size();
        int i = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int[] array = map.get(c);
                array[1]++;
                if (array[1] == array[0]) required--;
                if (required == 0) break;
            }
        }
        if (required != 0) return "";
        int j = 0;
        for (; j < i; j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                int[] array = map.get(c);
                if (array[1] - 1 >= array[0])
                    array[1]--;
                else
                    break;
            }
        }
        String min = s.substring(j, i+1);
        for (i++; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) continue;
            int[] array = map.get(c);
            array[1]++;
            while (j < i) {
                char cj = s.charAt(j);
                if (!map.containsKey(cj)) {
                    j++;
                    continue;
                }
                int[] carray = map.get(cj);
                if (carray[1] - 1 >= carray[0]) {
                    j++;
                    carray[1]--;
                } else
                    break;
            }
            String tmp = s.substring(j, i + 1);
            min = min.length() < tmp.length() ? min : tmp;
        }
        return min;
    }

    public static void main(String[] args){
        String s="ab";
        String t="a";
        MinimumWindowSubstring_76 sol=new MinimumWindowSubstring_76();
        System.out.println(sol.minWindow(s,t));
    }
}
