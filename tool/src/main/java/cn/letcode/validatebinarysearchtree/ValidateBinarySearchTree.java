package cn.letcode.validatebinarysearchtree;

public class ValidateBinarySearchTree {
    private Integer preVal;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean left = isValidBST(root.left);
        if(preVal!=null && preVal>=root.val){
            return false;
        }
        preVal=root.val;
        boolean right = isValidBST(root.right);
        return left && right;
    }


    public static void main(String[] args) {
        ValidateBinarySearchTree tree = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(0);
        tree.isValidBST(root);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

