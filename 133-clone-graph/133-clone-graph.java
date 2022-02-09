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
        if(node == null)
            return null;
        HashMap<Node, Node> hashMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        hashMap.put(node,new Node(node.val));
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            Node cloneNode = hashMap.get(temp);
            if(temp!= null && temp.neighbors!= null){
                List<Node> tempNeighbors = temp.neighbors;
                for(Node neighbor : tempNeighbors){
                    Node cloneNeighbor =  hashMap.get(neighbor);
                    if(cloneNeighbor == null){
                        queue.add(neighbor);
                        cloneNeighbor = new Node(neighbor.val);
                        hashMap.put(neighbor,cloneNeighbor);
                    }
                    cloneNode.neighbors.add(cloneNeighbor);
                }
            }
        }
        return hashMap.get(node);
    }
}