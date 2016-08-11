/**
 * Created by yjin on 8/11/16.
 */
public class RegularExpressionMatching_10 {
    public boolean isMatch(String s, String p) {
        if(s==null||p==null) return false;
        if(s.length()==0&&p.length()==0) return true;
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int i=0;i<p.length();i++)
            if(p.charAt(i)=='*')
                dp[0][i+1]=dp[0][i-1];
        for(int i=1;i<=s.length();i++)
            for(int j=1;j<=p.length();j++){
                if(p.charAt(j-1)!='*')
                    dp[i][j]=(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.')&&dp[i-1][j-1];
                else
                    dp[i][j]=dp[i][j-2]||dp[i-1][j]&&((p.charAt(j-2)=='.')||p.charAt(j-2)==s.charAt(i-1));
            }
        return dp[s.length()][p.length()];
    }
}
