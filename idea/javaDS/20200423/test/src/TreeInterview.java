import java.util.*;

public class TreeInterview {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //是不是完全二叉树
    public boolean isComplete(TreeNode root) {
        if(root == null) {
            return true;
        }
        //这个变量为true表示当前为第一阶段，false表示在第二阶段
        boolean isFirstStep = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(isFirstStep) {
                //第一阶段要求任意节点必须具备两个子树
                if(cur.left != null && cur.right != null) {
                    //当前节点有两个子树，直接把子树入队列，继续往后遍历
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left == null && cur.right != null) {
                    //一定不是完全二叉树
                    return false;
                }else if(cur.left != null && cur.right == null) {
                    //进入第二阶段
                    queue.offer(cur.left);
                    isFirstStep = false;
                }else {
                    //当前节点左右子树都为空，进入第二阶段
                    isFirstStep = false;
                }
            }else {
                //第二阶段，要求任意节点必须没有子树
                if(cur .left != null || cur.right != null) {
                    //找到了反例
                    return false;
                }
            }
        }
        //树遍历完了，也没有找到反例，那就是完全二叉树
        return true;
    }
    //二叉树的分层遍历
    //把结果作为一个成员变量来使用，递归过程中每层递归方法都可以很方便的操作同一个结果
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> leverOrder(TreeNode root) {
        if(root == null) {
            return result;
        }
        //对树进行先序遍历，递归时需要加上一个层数作为参数（层数从0开始，方便和List下标对应）
        result.clear();//最好加上clear，防止多组数据的时候，上次操作result中的残留值，对本次操作造成影响
        levelOrderHelper(root,0);
        return result;
    }

    private void levelOrderHelper(TreeNode root, int level) {
        if(level == result.size()) {
            //当前level在result中没有对应的行，加入一行
            //防止下边的get操作出现下标越界异常
            result.add(new ArrayList<>());
        }
        List<Integer> curRow = result.get(level);
        curRow.add(root.val);//先序遍历的“访问”操作
        if(root.left != null) {
            levelOrderHelper(root.left,level+1);
        }
        if(root.right != null) {
            levelOrderHelper(root.right,level+1);
        }

    }
    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> tree = new Stack<>();
        tree.push(root);
        while(!tree.isEmpty()) {
            TreeNode ret = tree.pop();
            System.out.print(ret.val + " ");
            if(root.right != null ) {
                tree.push(root.right);
            }
            if(root.left != null ) {
                tree.push(root.left);
            }
        }
    }
}
