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
        if (node == null)
            return node;
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()) {
            Node cur = q.poll();
            Node newNode = map.get(cur);
            map.put(cur, newNode);
            List<Node> neighbors = new ArrayList<>();
            visited.add(cur);
            for(Node tmp : cur.neighbors) {
                if (!map.containsKey(tmp)) {
                    map.put(tmp, new Node(tmp.val));
                }
                neighbors.add(map.get(tmp));
                
                if(!visited.contains(tmp)) {
                    q.offer(tmp);
                }
            }
            newNode.neighbors = neighbors;
        }
        return map.get(node);
    }
}