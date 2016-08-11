/**
 * Created by yjin on 6/15/16.
 */
public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        if(nums==null||nums.length==0) return -1;
        int missing=0;
        for(int i=1;i<nums.length+1;i++)
            missing^=i;
        for(int i=0;i<nums.length;i++)
            missing^=nums[i];
        return missing;
    }
}
