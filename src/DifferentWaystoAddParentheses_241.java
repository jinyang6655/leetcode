import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yjin on 8/6/16.
 */
public class DifferentWaystoAddParentheses_241 {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res=new LinkedList<Integer>();
        if(input==null||input.length()==0) return res;
        ArrayList<String> expression=this.items(input);
        ArrayList<Integer> set=this.getValueFromExpression(expression,0,expression.size()-1);
        return set;
    }

    public ArrayList<Integer> getValueFromExpression(ArrayList<String> list,int start,int end){
        if(start>end) return null;
        ArrayList<Integer> set=new ArrayList<Integer>();
        if(start==end) {
            set.add(Integer.parseInt(list.get(start)));
        }else{
            for(int i=0;i<=end-start-2;i=i+2){
                ArrayList<Integer> first=this.getValueFromExpression(list,start,start+i);
                ArrayList<Integer> second=this.getValueFromExpression(list,start+i+2,end);
                if(first==null||second==null){
                    System.out.println("error");
                    return null;
                }

                for(int v1:first)
                    for(int v2:second){
                        String op=list.get(start+i+1);
                        if(op.equals("+"))
                            set.add(v1+v2);
                        else if(op.equals("-"))
                            set.add(v1-v2);
                        else if(op.equals("*"))
                            set.add(v1*v2);
                        else{
                            System.out.println("error op "+ op);
                        }

                    }
            }
        }
        return set;
    }

    public ArrayList<String> items(String str){
        str=str.trim();
        ArrayList<String> res=new ArrayList<>();
        int index=0;
        int val=0;
        while(index<str.length()){
            char c=str.charAt(index);
            if(this.isDigit(c))
                val=val*10+c-'0';
            else if(this.isOperate(c)){
                res.add(val+"");
                res.add(c+"");
                val=0;
            }
            index++;
        }
        res.add(val+"");
        return res;
    }

    public boolean isOperate(char c){
        return c=='+'||c=='-'||c=='*';
    }

    public boolean isDigit(char c){
        return c>='0'&&c<='9';
    }

    public static void main(String[] args){
        String expression="2-1-1";
        DifferentWaystoAddParentheses_241 sol=new DifferentWaystoAddParentheses_241();
        for(Integer val:sol.diffWaysToCompute(expression))
            System.out.println(val);
    }
}
