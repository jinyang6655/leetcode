/**
 * Created by yjin on 6/15/16.
 */
public class MaximumProductSubarray_152 {
    //idea the same from https://leetcode.com/discuss/11923/sharing-my-solution-o-1-space-o-n-running-time

    public int maxProduct(int[] nums) {

        if(nums==null||nums.length==0)
            return 0;
        int maxsofar=nums[0];
        int minsofar=nums[0];
        int max=maxsofar;
        for(int i=1;i<nums.length;i++){
            int tmp;
            if(maxsofar==0){
                tmp=nums[i];
            }else{
                tmp=nums[i]*maxsofar>nums[i]*minsofar?nums[i]*maxsofar:nums[i]*minsofar;
            }

            if(minsofar==0){
                minsofar=nums[i];
            }else{
                minsofar=nums[i]*maxsofar>nums[i]*minsofar?nums[i]*minsofar:nums[i]*maxsofar;
            }
            maxsofar=tmp>nums[i]?tmp:nums[i];
            minsofar=minsofar<nums[i]?minsofar:nums[i];
            max=max>maxsofar?max:maxsofar;
        }
        return max>maxsofar?max:maxsofar;

    }
}
