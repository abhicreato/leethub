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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList();
        
        solve(root, ans);
        
        return ans;
        
    }
    
    public void solve(TreeNode node, List<Integer> op){
        
        if(node == null){
             return;
        }
        
        solve(node.left,op);
        solve(node.right,op);
        
        op.add(node.val);
        
        
    }
}