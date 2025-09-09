/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode current = root;
        List<Integer> list = new ArrayList<>();

        while (current != null) {
            if (current.left == null) {
                list.add(current.val);
                current = current.right;
            } else {
               
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                   
                    predecessor.right = current;
                    current = current.left;
                } else {
                   
                    predecessor.right = null;
                    list.add(current.val);
                    current = current.right;
                }
            }
        }
        return list;
    }
}