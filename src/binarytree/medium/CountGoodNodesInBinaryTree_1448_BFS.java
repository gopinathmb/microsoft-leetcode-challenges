package binarytree.medium;

import java.util.LinkedList;
import java.util.Queue;

import binarytree.util.TreeNode;

/**
 * Created by gopinath_mb on Oct 17, 2021
 */

/**
 * @author gopinath_mb
 */
public class CountGoodNodesInBinaryTree_1448_BFS {

  public int goodNodes(TreeNode root) {

    int res = 0;
    if (root == null) {
      return res;
    }

    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(root, root.val));

    while (!q.isEmpty()) {
      int size = q.size();

      for(int i = 0; i < size; i++) {
        Pair pair = q.remove();
        TreeNode cur = pair.node;
        int max = pair.max;
        if (max <= cur.val) {
          res++;
        }

        if (cur.left != null) {
          q.add(new Pair(cur.left, Math.max(max, cur.val)));
        }

        if (cur.right != null) {
          q.add(new Pair(cur.right, Math.max(max, cur.val)));
        }
      }
    }

    return res;
  }

  class Pair {

    TreeNode node;
    int max;

    public Pair(TreeNode node, int max) {
      this.node = node;
      this.max = max;
    }
  }
}
