import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by yjin on 8/11/16.
 */
public class WordBreak_139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        //bruth force
        boolean[][][] record=new boolean[s.length()][s.length()][2];
        this.wordBreak(s,wordDict,0,s.length()-1,record);
        return record[0][s.length()-1][1];
    }

    public boolean wordBreak(String s, Set<String> wordDict,int left,int right,boolean[][][] record) {
        if(right<left) return false;
        if(record[left][right][0]) return record[left][right][1];
        if(wordDict.contains(s.substring(left,right+1))){
            record[left][right][0]=true;
            record[left][right][1]=true;
            return true;
        }
        for(int i=left;i<right;i++){
            boolean b1=this.wordBreak(s,wordDict,left,i,record);
            boolean b2=this.wordBreak(s,wordDict,i+1,right,record);
            if(b1&&b2){
                record[left][right][0]=true;
                record[left][right][1]=true;
                return true;
            }
        }
        record[left][right][0]=true;
        record[left][right][1]=false;
        return false;
    }

    public boolean wordBreak1(String s, Set<String> wordDict) {
        if(s==null||wordDict==null||wordDict.size()==0) return false;
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;//in order to get the dp right, basecase
        for(int i=0;i<s.length();i++)
            for(int j=0;j<=i;j++){
                if(dp[j]&&wordDict.contains(s.substring(j,i+1))){
                    dp[i+1]=true;
                }
            }
        return dp[s.length()];
    }

    public boolean wordBreak2(String s, Set<String> wordDict) {
        if(s==null||wordDict==null||wordDict.size()==0) return false;
        Queue<Integer> queue=new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        queue.add(0);visited.add(0);
        while(!queue.isEmpty()){
            int current=queue.poll();
            for(int i=current+1;i<=s.length();i++){
                if(visited.contains(i)) continue;
                if(wordDict.contains(s.substring(current,i))){
                    queue.add(i);
                    if(i==s.length()) return true;
                    visited.add(current);
                }

            }
        }
        return false;

    }
}
