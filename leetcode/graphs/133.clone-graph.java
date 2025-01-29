package graphs;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Map<Node, Node> oldNodeToNewNodeMap = new HashMap<>();
        return dfs(oldNodeToNewNodeMap, node);
    }

    private Node dfs(Map<Node, Node> oldNodeToNewNodeMap, Node oldNode) {

        if (oldNodeToNewNodeMap.containsKey(oldNode)) {
            return oldNodeToNewNodeMap.get(oldNode);
        }

        /// Add the visited Node to the map.
        Node duplicateNode = new Node(oldNode.val);
        oldNodeToNewNodeMap.put(oldNode, duplicateNode);

        /// For all the neighbours of oldNode, add them via dfs.
        for (Node neighborNode : oldNode.neighbors) {
            duplicateNode.neighbors.add(dfs(oldNodeToNewNodeMap, neighborNode));
        }

        return duplicateNode;
    }
}
// @lc code=end
