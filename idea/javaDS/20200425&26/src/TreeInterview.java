import java.util.Stack;

public class TreeInterview {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //1.求两子树的最近公共祖先
    //借助这个成员变量保存最近公共祖先
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,TreeNode q) {
        if(root == null) {
            return null;
        }
        findNode(root,p,q);
        return lca;
    }
    //【约定】如果在root中能够找到p或者q，就返回true，否则返回false
    public boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }
        //采取后序遍历的方式进行查找
        int left = findNode(root.left,p,q) ? 1 : 0;
        int right = findNode(root.right,p,q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if(left + right + mid == 2) {
            lca = root;
        }
        if((left == 1 && right == 1 && mid == 0) ||
                (left == 1 && right == 0 && mid == 1) ||
                (left == 0 && right == 1 && mid == 1)) {
            lca = root;
        }
        return (left + right + mid) > 0;
    }
    //2.二叉搜索树转换为有序的双向链表
    //返回值的含义表示链表的头结点
    public TreeNode Convert(TreeNode root) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null) {
            return root;
        }
        //中序遍历
        //先递归处理左子树，这个方法一执行,就相当于把左子树已完整的转换成双向链表
        TreeNode left = Convert(root.left);
        //处理根节点，需要把根节点追加到左子树链表的尾部
        //这就相当于链表尾插，需要先找到前面链表的最后一个节点
        TreeNode leftTail = left;
        while(leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        //当上述循环结束之后，leftTail 就是left这个链表的最后一个节点
        //把当前根节点尾插过去
        if(leftTail != null) {
            leftTail.right = root;
            root.left = leftTail;
        }

        //最后递归处理右子树
        TreeNode right = Convert(root.right);
        if(right != null) {
            //把根节点和右子树连接在一起
            right.left = root;
            root.right = right;
        }
        return (left != null) ? left : root;
    }
    //3.根据一棵树的前序遍历与中序遍历构造二叉树
    //preorder 这个数组的长度一定和inorder是相同的
    //为了辅助遍历，通过index记录当前preorder访问到哪个元素了
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        //借助buildTreeHelper方法进行递归,为了更好的描述子树，
        // 在方法中加入一对参数表示当前子树对应的中序遍历结果的区间
        return buildTreeHelper(preorder,inorder,0,inorder.length);
    }
    //[inorderLeft,inorderRight]表示当前这个子树的中序遍历区间
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inorderLeft, int inorderRight) {
        if(inorderLeft >= inorderRight) {
            //中序区间为空区间，当前子树为空树
            return null;
        }
        if(index >= preorder.length) {
            //先序中的所有元素都访问完毕了
            return null;
        }
        //根据index取出当前根节点的值，并构造根节点
        TreeNode newNode = new TreeNode(preorder[index]);
        //知道了根节点之后，还需要根据根节点在中序结果中找出左子树和右子树的范围
        //找出当前节点在中序结果中的位置位置确定了，左右子树的中序结果也就确定了
        //左子树对应的中序区间：[inorderLeft, pos)
        //右子树对应的中序区间：[pos+1, inorderRight)
        int pos = find(inorder,inorderLeft,inorderRight,newNode.val);
        index++;//只自增一次
        newNode.left = buildTreeHelper(preorder,inorder,inorderLeft,pos);
        newNode.right = buildTreeHelper(preorder,inorder,pos+1,inorderRight);
        return newNode;
    }

    private int find(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for (int i = inorderLeft; i < inorderRight; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
    //先序遍历，输出（带括号）的字符串
    //sb表示最终的结果
    //递归过程中需要把访问的字符依次追加到结果中
    //String是不可变对象，要想修改String，只能创建新对象

    private StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode t) {
        if(t == null) {
            return  "";
        }
        helper(t);
        //删除最外层的左右括号
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    private void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        //先访问当前节点，此时的访问操作就是把元素加到stringBuilder中
        stringBuilder.append("(");
        stringBuilder.append(root.val);
        helper(root.left);
        if(root.left == null && root.right != null) {
            stringBuilder.append("()");
        }
        helper(root.right);
        stringBuilder.append(")");
    }
    private static TreeNode build () {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        A.left = B;
        A.right = C;
        B.right = E;
        B.left = D;
        E.left = G;
        C.right = F;
        return A;
    }


    //前序遍历（非递归)
    public  void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            if(top.right != null) {
                stack.push(top.right);
            }
            if(top.left != null) {
                stack.push(top.left) ;
            }
        }
    }
    //中序遍历（非递归）
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            //1，cur一直往左找，循环入栈，直到cur为空
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //2，取栈顶元素并访问，如果遇到空栈，说明访问完毕了
            if(stack.empty()) {
                break;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            //3，cur从top的右子树出发，循环1,2
            cur = top.right;
        }
    }
    //后序遍历（非递归）
    public void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //prev被用来记录上一个被访问过的节点,初始情况下没有任何节点被访问过
        TreeNode prev = null;
        while (true) {
            //1，cur循环往左找，遇到的非空节点都入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //2，取栈顶元素，看看能不能访问这个元素
            //满足以下两个条件，才能够访问当前栈顶元素
            //a)右子树为空
            //b)右子树被访问过

            if(stack.empty()) {
                //遍历结束
                break;
            }
            TreeNode top = stack.peek();//只是取元素判断一下，并没有真的出栈，
            // 只有这个节点被访问过了，才能出栈
            if( top.right == null|| prev == top.right) {
                System.out.print(top.val + " ");
                stack.pop();
                prev = top;
            }else{
                //3,让cur从top。right出发继续循环1,2
                cur = top.right;
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = build();
        TreeInterview interview = new TreeInterview();
        /*String ret = interview.tree2str(root);
        System.out.println(ret);*/
        //interview.preOrder(root);
        //interview.inOrder(root);
        interview.postOrder(root);
    }
}
