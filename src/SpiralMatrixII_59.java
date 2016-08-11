/**
 * Created by yjin on 6/29/16.
 */
public class SpiralMatrixII_59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int rowend=matrix.length-1;
        int colend=matrix[0].length-1;
        int rowstart=0;
        int colstart=0;
        int count=0;
        while(rowstart<=rowend&&colstart<=colend){
            for(int j=colstart;j<=colend;j++)
                    matrix[rowstart][j]=count++;
            rowstart++;
            for(int j=rowstart;j<=rowend;j++)
                    matrix[j][colend]=count++;
            colend--;
            if(rowstart<=rowend){
                for(int j=colend;j>=colstart;j--)
                        matrix[rowend][j]=count++;
                rowend--;
            }

            if(colstart<=colend){
                for(int j=rowend;j>=rowstart;j--)
                    matrix[j][colstart]=count++;
                colstart++;
            }

        }
        return matrix;

    }
}
