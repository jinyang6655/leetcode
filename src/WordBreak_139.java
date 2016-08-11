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
}
