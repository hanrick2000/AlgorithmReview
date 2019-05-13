package alg.laioffer.review19.recursionII;

import alg.laioffer.class4.bintree.TreeNode;

public class LCA {
  public TreeNode lowestComonAncestor(TreeNode root, TreeNode one, TreeNode two) {
    // base case
    if(root == null || one == root || two == root) return root;

    TreeNode left = lowestComonAncestor(root.left, one, two);
    TreeNode right = lowestComonAncestor(root.right, one, two);

    if(left != null && right != null) {
      return root;
    }
    if(left != null) return left;
    if(right != null) return right;
    return null;
  }
}