import java.util.HashSet;

public class DirectedGraphWeighted {
    private HashSet<Vertex>[] neighbours;
    private int nodeCapacity;
    private int graphConnections;

    /* TODO Initialize de DirectedGraph */
    public void initialize(int numNodes) {
        //
    }

    /*TODO Create an edge between the vertices - Veuillez vous referez aux notes de cours */
    public void connect(int v1, int v2, Vertex vertex){
        //
    }

    /* TODO Print all the edges connecting vertices*/
    public String toString(){
        StringBuilder o = new StringBuilder();
        String ln = System.getProperty("line.separator");
        o.append(nodeCapacity).append(ln).append(graphConnections).append(ln);
        return o.toString();
    }

    /* TODO Return a HashMap of adjacent edges / vertices */
    public HashSet<Vertex> adj(int v) {
        return new HashSet<>();
    }

    public DirectedGraphWeighted(int numNodes){
        initialize(numNodes);
    }

    public int findLowestCost() {
        /* NE PAS MODIFIER CE CODE */
        int totalCost = 0;

        Heap vertices = new Heap(nodeCapacity + 1);
        /* TODO Add all of the vertices to the Heap start at Index 1. The default cost should be the largest possible value */
        /* NE PAS MODIFIER CE CODE */

        while(true){
            Vertex v = vertices.findSmallestUnknown();
            if(v == null) break;
            v.known = true;
            for(Vertex w: adj(v.index)){
                /* TODO Evaluate each edge to see if the total cost is less than the cost contained in nodes. */
                /* TODO Decrease the cost of the vertex in the Heap using decreaseKey if conditions are met */
            }
        }

        /*TODO Add up the total cost of the elements in the Heap */

        return totalCost;
    }
}
