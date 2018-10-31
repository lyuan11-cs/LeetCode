/*
Given an n-ary tree, return the postorder traversal of its nodes' values.

For example, given a 3-ary tree:
             1
           / | \
          3  2  4
         / \
        5   6 
Return its postorder traversal as: [5,6,3,2,4,1].

*/

Recursion: 
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null)
            return list;
        
        
        for(Node node: root.children)
            postorder(node);
        
        list.add(root.val);
        return list;
    }
}


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    

   public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for(Node node: root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;
    }
}
