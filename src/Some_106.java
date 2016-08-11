/**
 * Created by yjin on 6/22/16.
 */
public class Some_106 {
    public TreeNode buildTree(int[] inorder,int[] postorder){
        if(inorder==null||postorder==null||postorder.length!=inorder.length||postorder.length==0)
            return null;
        return this.buildTreeNode(inorder,0,inorder.length-1,postorder,0,postorder.length-1);

    }

    public TreeNode buildTreeNode(int[] inorder,int istart,int iend,int[] postorder,int pstart,int pend){
        TreeNode node=null;
        if(istart>iend||pstart>pend)
            return null;
        if(pstart==pend){
            node=new TreeNode(postorder[pstart]);
            node.left=null;
            node.right=null;
            return node;
        }
        node=new TreeNode(postorder[pend]);
        int i=istart;
        for(;i<inorder.length;i++)
            if(inorder[i]==postorder[pend])
                break;
        node.left=this.buildTreeNode(inorder,istart,i-1,postorder,pstart,pstart+i-1-istart);
        node.right=this.buildTreeNode(inorder,i+1,iend,postorder,pend-iend+i,pend-1);
        return node;
    }
}
