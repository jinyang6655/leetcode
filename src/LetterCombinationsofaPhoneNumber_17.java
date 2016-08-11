import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yjin on 8/11/16.
 */
public class LetterCombinationsofaPhoneNumber_17 {
    public List<String> letterCombinations(String digits) {
        Queue<String> queue=new LinkedList<String>();
        if(digits==null||digits.length()==0) return new LinkedList<String>(queue);
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        queue.add("");
        for(int i=0;i<digits.length();i++){
            int size=queue.size();
            char[] array=mapping[digits.charAt(i)-'0'].toCharArray();
            while(size>0){
                String str=queue.poll();
                for(char c:array)
                    queue.add(str+c);
                size--;
            }
        }
        return new LinkedList<String>(queue);
    }

    public static void main(String[] args){
        String digits="23";
        LetterCombinationsofaPhoneNumber_17 sol=new LetterCombinationsofaPhoneNumber_17();
        for(String str:sol.letterCombinations(digits))
            System.out.println(str);
    }

}
