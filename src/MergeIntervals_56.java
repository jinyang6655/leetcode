import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yjin on 8/11/16.
 */
public class MergeIntervals_56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res=new ArrayList<Interval>();
        if(intervals==null||intervals.size()==0) return res;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start==o2.start)
                    return Integer.compare(o1.end,o2.end);
                else return Integer.compare(o1.start,o2.start);
            }
        });

        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(Interval inter:intervals){
            if(inter.start<=end){
                end=inter.end>end?inter.end:end;
            }else{
                res.add(new Interval(start,end));
                start=inter.start;
                end=inter.end;
            }
        }
        res.add(new Interval(start,end));
        return res;
    }
}
