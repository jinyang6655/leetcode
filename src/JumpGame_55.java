/**
 * Created by yjin on 6/29/16.
 */
public class JumpGame_55 {

    public boolean canJump(int[] nums) {
        //a simple version can be found at
        //https://leetcode.com/discuss/15567/linear-and-simple-solution-in-c
        if(nums==null||nums.length<0) return false;
        int maxReach=0;
        for(int i=0;i<nums.length;i++){
            maxReach=maxReach>i+nums[i]?maxReach:i+nums[i];
            if(maxReach<=i)
                return false;
            if(maxReach>=nums.length-1)
                return true;
        }
        return true;
    }
}
