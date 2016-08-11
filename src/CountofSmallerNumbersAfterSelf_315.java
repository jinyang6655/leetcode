import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yjin on 8/7/16.
 */
public class CountofSmallerNumbersAfterSelf_315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list=new ArrayList<Integer>();
        if(nums==null||nums.length==0) return list;
        int[] res=new int[nums.length];
        for(int i=nums.length-2;i>=0;i--){
            int index=i+1;
            int target=nums[i];
            int num=0;
            while(index<nums.length){
                int val=nums[index];
                if(val<target){
                    num++;
                }else if(val>=target){
                    if(res[index]==0){
                        break;
                    }
                }
                index++;
            }
            res[i]=num;
        }
        for(int val:res){
            list.add(val);
        }
        return list;
    }

    public static void main(String[] args){
        CountofSmallerNumbersAfterSelf_315 sol=new CountofSmallerNumbersAfterSelf_315();
        int[] input={2,0,1};
        for(int val:sol.countSmaller(input))
            System.out.print(val+"  ");
    }
}
