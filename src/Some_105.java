/**
 * Created by yjin on 6/22/16.
 */
public class Some_105 {
    public TreeNode buildTree(int[] preorder,int[] inorder){
        if(inorder==null||preorder==null||preorder.length!=inorder.length||preorder.length==0)
            return null;
        TreeNode tree= this.buildTreeNode(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
        return tree;
    }

    public TreeNode buildTreeNode(int[] inorder,int istart,int iend,int[] preorder,int pstart,int pend){
        TreeNode node=null;
        if(istart>iend||pstart>pend)
            return null;
        if(istart<0||iend>=inorder.length||pstart<0||pend>=preorder.length)
            return null;
        if(pstart==pend){
            node=new TreeNode(preorder[pstart]);
            node.left=null;
            node.right=null;
            return node;
        }
        node=new TreeNode(preorder[pstart]);
        int i=istart;
        for(;i<inorder.length;i++)
            if(inorder[i]==preorder[pstart])
                break;
        node.left=this.buildTreeNode(inorder,istart,i-1,preorder,pstart+1,i-istart+pstart);
        node.right=this.buildTreeNode(inorder,i+1,iend,preorder,(pend-iend+i+1),pend);
        return node;
    }

    public static void main(String[] args){
        int[] preorder={1,4,2,3};
        int[] inorder={1,2,3,4};
        Some_105 sol=new Some_105();
        sol.buildTree(preorder,inorder);
    }
}
