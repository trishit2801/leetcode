import java.util.*;
class CreateBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();
        for(int i=0; i<descriptions.length; i++){
            for(int j=0; j<descriptions[0].length; j++){
                if(!map.containsKey(descriptions[i][0]))
                    map.put(descriptions[i][0], new TreeNode(descriptions[i][0]));
                if(!map.containsKey(descriptions[i][1]))
                    map.put(descriptions[i][1], new TreeNode(descriptions[i][1]));
                int isLeft = descriptions[i][2];
                if(isLeft == 1){
                    map.get(descriptions[i][0]).left = map.get(descriptions[i][1]);
                }
                else{
                    map.get(descriptions[i][0]).right = map.get(descriptions[i][1]);
                }
                children.add(descriptions[i][1]);
            }
        }
        for(Map.Entry<Integer,TreeNode> entry : map.entrySet()){
            if(!children.contains(entry.getKey()))
                return entry.getValue();
        }
        return null;
    }
}
