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
    public boolean isCompleteTree(TreeNode root) {
    
    boolean isNullSeen = false;
    LinkedList<TreeNode> Q = new LinkedList<>();
    Q.add(root);
        
    while(!Q.isEmpty()){
        
        TreeNode curr = Q.remove();
        
        if(curr == null){
            isNullSeen = true;
        }else{
        // This means we have receied not null node after a null
            if(isNullSeen) return false;
            Q.add(curr.left);
            Q.add(curr.right);
        }
 
    }
       
    // if no null seen then return true
    return true;
    
    }
}