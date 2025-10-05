import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static List<String> res = new ArrayList<>();
    public static List<String> binaryTreePaths(TreeNode root) {
        if(root == null)    return res;
        preOrder("", root);
        return res;
    }

    public static void preOrder(String currPath, TreeNode root){
        if(root == null)    return;

        if(currPath.isEmpty()){
            currPath = "" + root.val;
        }else{
            currPath += "->" + root.val;
        }

        if(root.left == null && root.right == null){
            res.add(currPath);
            return;
        }

        preOrder(currPath, root.left);
        preOrder(currPath, root.right);
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, null, node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node2, node3);

        System.out.println(binaryTreePaths(root));
    }
}
