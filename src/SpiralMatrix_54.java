import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjin on 6/28/16.
 */
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        //the idea get from here
        //https://leetcode.com/discuss/12228/super-simple-and-easy-to-understand-solution
        List<Integer> result=new ArrayList<>();
        if(matrix==null||matrix.length==0)
            return result;
        int rowend=matrix.length-1;
        int colend=matrix[0].length-1;
        int rowstart=0;
        int colstart=0;
        while(rowstart<=rowend&&colstart<=colend){
            for(int j=colstart;j<=colend;j++)
                result.add(matrix[rowstart][j]);
            rowstart++;
            for(int j=rowstart;j<=rowend;j++)
                result.add(matrix[j][colend]);
            colend--;
            if(rowstart<=rowend){
                for(int j=colend;j>=colstart;j--)
                    result.add(matrix[rowend][j]);
                rowend--;
            }

            if(colstart<=colend){
                for(int j=rowend;j>=rowstart;j--)
                    result.add(matrix[j][colstart]);
                colstart++;
            }

        }
        return result;
    }

    public static void main(String[] args){
        int[] r0={0};
        int[] r1={1};
        int[] r2={2};
        int[] r3={3};
        int[] r4={4};
        int[] r5={5};
        int[] r6={6};
        int[] r7={7};
        int[][] matrix=new int[8][];
        matrix[0]=r0;
        matrix[1]=r1;
        matrix[2]=r2;
        matrix[3]=r3;
        matrix[4]=r4;
        matrix[5]=r5;
        matrix[6]=r6;
        matrix[7]=r7;
        SpiralMatrix_54 sol=new SpiralMatrix_54();
        List<Integer> result=sol.spiralOrder(matrix);
        for(Integer i:result){
            System.out.print(i+" ");
        }
    }



}
