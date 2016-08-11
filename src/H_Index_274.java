/**
 * Created by yjin on 7/12/16.
 */
public class H_Index_274 {
    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0) return 0;
        int[] res=new int[citations.length+1];
        int max=citations.length;
        for(int i=0;i<citations.length;i++){
            if(citations[i]>max) res[max]++;
            else res[citations[i]]++;
        }
        int pre=0;
        for(int i=max;i>=0;i--){
            if(res[i]+pre>=i)
                return i;
            pre+=res[i];
        }
        return 0;
    }
}
