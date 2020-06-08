import java.util.ArrayList;
import java.util.List;

public class TreeInterview {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    //二叉树的遍历（返回值为一个List）
    //1.前序
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
         if(root == null) {
            return result;
         }
         result.add(root.val);
         result.addAll(preorderTraversal(root.left));
         result.addAll(preorderTraversal(root.right));
         return result;
    }
    //2.中序
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }
    //3. 后序
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    public static void main(String[] args) {

    }
}
