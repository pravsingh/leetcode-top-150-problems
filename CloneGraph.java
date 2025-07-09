
import java.util.*;

/**
 * 133. Clone Graph
 *
 * Given a reference of a node in a connected undirected graph.
 *
 * Example 1:
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 *
 * Example 2:
 * Input: adjList = [[]]
 * Output: [[]]

 *
 * SOLUTION APPROACH:
 * - Use appropriate graph traversal (DFS/BFS)
 * - Consider topological sort, shortest path, or cycle detection
 * - Handle disconnected components and edge cases
 * - Use appropriate data structures (adjacency list/matrix)
 *
 * TIME COMPLEXITY: Varies based on approach - typically O(V + E)
 * SPACE COMPLEXITY: Varies based on approach - typically O(V) to O(V + E)
 *
 * ALTERNATIVE APPROACHES:
 * 1. DFS: O(V + E) time, O(V) space - Depth-first search
 * 2. BFS: O(V + E) time, O(V) space - Breadth-first search
 * 3. Union-Find: O(V + E) time, O(V) space - For connectivity problems
 *
 * KEY INSIGHTS:
 * - Choose traversal based on problem requirements
 * - Consider directed vs undirected graphs
 * - Handle cycles and disconnected components
 */
public class CloneGraph {
    public class Node {
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
    
    private Map<Node, Node> visited = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode);
        
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return cloneNode;
    }
} 