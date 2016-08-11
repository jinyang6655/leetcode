/**
 * Created by yjin on 6/29/16.
 */
public class TrappingRainWater_42 {
    public int trap(int[] height) {
        //a better way to use the o(1) memory
        int[] left=new int[height.length];
        int[] right=new int[height.length];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<height.length;i++){
            max=max>height[i]?max:height[i];
            left[i]=max;
        }
        max=Integer.MIN_VALUE;
        for(int i=height.length-1;i>=0;i--){
            max=max>height[i]?max:height[i];
            right[i]=max;
        }
        int area=0;
        for(int i=0;i<height.length;i++){
            int tmp=left[i]<right[i]?left[i]:right[i];
            if(tmp<height[i])
                continue;
            area+=tmp-height[i];
        }
        return area;
    }

    public static void main(String[] args){
        TrappingRainWater_42 sol=new TrappingRainWater_42();
        int[] arry={11,11};
        int area=sol.trap(arry);
        System.out.println(area);
    }
}
