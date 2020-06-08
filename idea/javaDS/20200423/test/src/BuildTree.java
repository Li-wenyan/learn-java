import java.util.Scanner;

public class BuildTree {
    //读入用户输入的先序遍历字符串，建立此二叉树，并以中序遍历结果输出
    static class TreeNode{
        public char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    //需要手动处理输入输出格式
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            //由于在线oj中输入数据可能存在多组，所以要使用循环
            String line = scanner.next();
            //读到先序结果后，就可以构建树了
            //TreeNode root = buildTree(line);
            index = 0;
            TreeNode root = createTreePreOrder(line);
            inOrder(root);//打印的每个结果之间都要用空格分隔开
            //每个输出结果占一行
            System.out.println();
        }
    }
    private static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    private static int index = 0;//代表当前递归到哪个字符了
   /* //入口
    private static TreeNode buildTree(String line) {
        //输入数据可能存在多组，每次处理一组新的数据都需要从0开始重新计数
        index = 0;
        return createTreePreOrder(line);
    }*/
    //辅助递归的方法
    //每递归一次，就处理一个节点（从字符串中取出一个指定字符）
    private static TreeNode createTreePreOrder(String line) {
        char ch = line.charAt(index);
        if(ch == '#') {
            //当前节点是空树
            return null;
        }
        //如果节点非空，就可以访问这个节点，创建
        TreeNode node = new TreeNode(ch);
        index++;//为了处理下一个节点
        node.left = createTreePreOrder(line);
        index++;
        node.right = createTreePreOrder(line);
        return node;
    }
}
