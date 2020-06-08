import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树中的面试题
public class TreeInterview {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //后序遍历（返回List）
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }
    //判定两个树是否相等
    public Boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return (p.val == q.val) && (isSameTree(p.left, q.left))
                && (isSameTree(p.right, q.right));
    }
    //判定s树中是否包含子树t
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        }
        return isSameTree(s, t) || isSubtree(s.left, t)
                || isSubtree(s.right, t);
    }
    //找二叉树的深度/高度/层数
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth,rightDepth);
    }
    //判断二叉树是否平衡（每个节点的左右两个子树的高度差的绝对值不超过1）
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return ((leftDepth - rightDepth <= 1) && (leftDepth - rightDepth >= -1)) &&
                isBalanced(root.left) && isBalanced(root.right);
    }
    //判定是否为镜像对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirror(root.left, root.right);

    }
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }
    //层序遍历
    public void levelOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        //1.创建一个队列，初识下把根节点加入到队列中
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        //2.进入循环，结束条件为队列为空
        while(!queue.isEmpty()) {
            //a) 取出队首元素
            TreeNode cur = queue.poll();
            //b) 访问当前元素
            System.out.print(cur.val + " ");
            //c) 把当前节点的左右子树分别入队列
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }

        }

    }
    public static TreeNode build() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        A.left = B;
        A.right = C;
        B .left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return  A;
    }

    public static void main(String[] args) {
        TreeNode root = build();
        TreeInterview interview = new TreeInterview();
        interview.levelOrder(root);
    }
}
