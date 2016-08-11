/**
 * Created by yjin on 6/29/16.
 */
public class ProductofArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        //the idea is that in the first pass get the product of all numbers at the left
        //the second pass is get the product of all numbers at the right
        //if you times them, you will get the result
        int[] res=new int[nums.length];
        if(nums==null||nums.length==0) return res;
        res[0]=1;
        for(int i=1;i<nums.length;i++)
            res[i]=nums[i-1]*res[i-1];
        int tmp=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i]*=tmp;
            tmp*=nums[i];
        }
        return res;

    }
}
