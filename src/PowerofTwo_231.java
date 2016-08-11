/**
 * Created by yjin on 7/15/16.
 */
public class PowerofTwo_231 {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        if(n==1) return true;
        if(n%2==1) return false;
        return isPowerOfTwo(n/2);
    }

    public boolean isPowerOfTwo1(int n) {
        //this idea came from here
        //https://discuss.leetcode.com/category/239/power-of-two
        if(n<=0) return false;
        return (n&(n-1))==0;

    }
}
