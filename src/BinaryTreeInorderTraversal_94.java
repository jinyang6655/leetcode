import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yjin on 7/12/16.
 */
public class BinaryTreeInorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode cur=root;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.add(cur);
                cur=cur.left;
            }
            TreeNode next=stack.pop();
            res.add(next.val);
            cur=next.right;
        }
        return res;
    }

}
