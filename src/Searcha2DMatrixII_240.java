/**
 * Created by yjin on 8/6/16.
 */
public class Searcha2DMatrixII_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
        for(int i=0;i<matrix.length;i++){
            if(this.binarySearch(matrix[i],target))
                return true;
        }
        return false;
    }

    public boolean binarySearch(int[] matrix,int target){
        int left=0;
        int right=matrix.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(matrix[mid]==target) return true;
            else if(matrix[mid]<target) left=mid+1;
            else right=mid-1;
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int row=0;
        int col=matrix[0].length-1;
        while(row<matrix.length&&col>=0) {
            int val = matrix[row][col];
            if (val == target) return true;
            else if (val > target) row++;
            else col--;
        }
        return false;
    }

    public static void main(String[] args){
        int[][] m=new int[1][2];
    }
}
