import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yjin on 7/12/16.
 */
public class FractiontoRecurringDecimal_166 {
    public String fractionToDecimal(long numerator, long denominator) {
        Long nl=(long) numerator;
        Long dl=(long) denominator;
        if(nl*dl==0) return "0";
        boolean positive=true;
        if(nl*dl<0) positive=false;
        nl=Math.abs(nl);
        dl=Math.abs(dl);
        String before=(nl/dl)+"";
        long res=nl%dl;
        if(res!=0)
            before+=this.decimal(res,dl);
        return positive?before:"-"+before;
    }

    public String decimal(long numerator, long denominator){
        List<Long> list=new ArrayList<Long>();
        HashMap<Long,Long> map=new HashMap<Long,Long>();
        numerator*=10;
        long res=0;
        long count=0;
        long index=0;
        do{
            long val=numerator/denominator;
            long tmp=numerator;
            res=(numerator%denominator)*10;
            numerator=res;
            if(map.containsKey(tmp)){
                index=map.get(tmp);
                break;
            }
            list.add(val);
            map.put(tmp,count);
            count++;
        }while(res!=0);
        StringBuffer buffer=new StringBuffer();
        if(res==0){
            for(long val:list)
                buffer.append(val);
        }else{
            for(int i=0;i<index;i++)
              buffer.append(list.get(i));
            buffer.append("(");
            for(int i=(int)index;i<list.size();i++)
                buffer.append(list.get(i));
            buffer.append(")");
        }
        return "."+buffer.toString();
    }

    public static void main(String[] args){
        FractiontoRecurringDecimal_166 sol=new FractiontoRecurringDecimal_166();
        int numerator=1;
        int denominator=7;
        System.out.println(sol.fractionToDecimal(numerator,denominator));
    }

}
