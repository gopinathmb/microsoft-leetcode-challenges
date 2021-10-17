package binarytree.medium;

import binarytree.util.TreeNode;

/**
 * Created by gopinath_mb on Oct 17, 2021
 */

/**
 * @author gopinath_mb
 */
public class CountGoodNodesInBinaryTree_1448_DFS {

  public int goodNodes(TreeNode root) {
    return processEachNode(root, Integer.MIN_VALUE);
  }

  private int processEachNode(TreeNode root, int max) {
    if (root == null)
      return 0;
    // If this node satisfies then add one to it and also change the max value
    if (root.val >= max) {
      return 1 + processEachNode(root.left, root.val) + processEachNode(root.right, root.val);
    }

    // Max remains as is
    return processEachNode(root.left, max) + processEachNode(root.right, max);
  }
}
