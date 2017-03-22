import java.util.Stack;

/**
 * Created by Administrator on 2017/3/20.
 */
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class Main {
    static TreeNode root = null;
    //创建树
    public static void createTree(TreeNode treeNode,int data){
        if(root == null){
            root = new TreeNode(data);
        }else{
            if(data < treeNode.data){
                if(treeNode.left == null){
                    treeNode.left = new TreeNode(data);
                }else{
                    createTree(treeNode.left,data);
                }
            }else {
                if(treeNode.right == null){
                    treeNode.right = new TreeNode(data);
                }else {
                    createTree(treeNode.right,data);
                }
            }
        }
    }
    //递归前序遍历
    public static void preOrder(TreeNode treeNode){
        if(treeNode != null){
            System.out.print(treeNode.data + " ");
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
    }
    //非递归前序遍历
    public static void preOrderStack(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = treeNode;
        while (node != null || stack.size() > 0){
            if(node != null){
                System.out.print(node.data+" ");
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                node = node.right;
            }
        }
    }
    //递归中序遍历
    public static void inOrder(TreeNode treeNode){
        if(treeNode != null){
            inOrder(treeNode.left);
            System.out.print(treeNode.data + " ");
            inOrder(treeNode.right);
        }
    }
    //非递归中序遍历
    public static void inOrderStack(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = treeNode;
        while (node != null || stack.size() > 0){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                System.out.print(node.data+" ");
                node = node.right;
            }
        }
    }
    //递归后序遍历
    public static void postOrder(TreeNode treeNode){
        if(treeNode != null){
            postOrder(treeNode.left);
            postOrder(treeNode.right);
            System.out.print(treeNode.data + " ");
        }
    }
    //非递归后序遍历
    public static void postOrderStack(TreeNode treeNode){
        Stack<TreeNode> output = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = treeNode;
        while (node != null || stack.size() > 0){
            if(node != null){
                output.push(node);
                stack.push(node);
                node = node.right;
            }else {
                node = stack.pop();
                node = node.left;
            }
        }
        while (!output.isEmpty()){
            System.out.print(output.pop().data+" ");
        }
    }
    //查找两个节点的最近公共祖先
    public static TreeNode lowestCommonAncestor(TreeNode root, int m,int n) {
        if (root == null) return null;
        if (root.data == n || root.data == m) return root;

        TreeNode left_result = lowestCommonAncestor(root.left, m, n);
        TreeNode right_result = lowestCommonAncestor(root.right, m, n);

        if (left_result != null && right_result != null) return root;
        else if (left_result == null && right_result != null) return right_result;
        else return left_result;
    }
    public static void main(String[] args) {
        int [] a = new int[]{1,3,5,7,2,4,6,8};
        for (int i = 0; i < a.length; i++) {
            createTree(root,a[i]);
        }
        System.out.print("前序遍历是：");
        preOrder(root);
        System.out.print("|");
        preOrderStack(root);
        System.out.print("中序遍历是：");
        inOrder(root);
        System.out.print("|");
        inOrderStack(root);
        System.out.print("后序遍历是：");
        postOrder(root);
        System.out.print("|");
        postOrderStack(root);
        System.out.println("");
        System.out.println(lowestCommonAncestor(root,5,2).data);
    }
}
