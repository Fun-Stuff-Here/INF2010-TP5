import java.util.HashSet;

public class DirectedGraphWeighted {
    public HashSet<Vertex>[] neighbours;
    public int vertexCapacity;
    public int edgeQuantity;

    /* TODO Initialize de DirectedGraph */
    public void initialize(int numNodes) {
        vertexCapacity = numNodes;
        edgeQuantity = 0;
        neighbours = new HashSet[numNodes];
        for(int i = 0; i < numNodes; i++) neighbours[i] = new HashSet();
    }

    /*TODO Create an edge between the vertices - Veuillez vous referez aux notes de cours */
    public void connect(int v1, Vertex vertex){
        if(v1<0 || v1> vertexCapacity) return; //check that v1 is a valid node in the graph, we can only connect edges to existing node
        if(vertex.index <0 || vertex.index> vertexCapacity) return; //check that vertex is a valid node in the graph, we can only connect edges to existing node
        if(neighbours[v1].contains(vertex)) return;// check if edge is already in the graph, we don't allow duplicate edges

        neighbours[v1].add(vertex);
        edgeQuantity++;
    }

    /* TODO Print all the edges connecting vertices*/
    public String toString(){
        StringBuilder o = new StringBuilder();
        String ln = System.getProperty("line.separator");
        o.append(vertexCapacity).append(ln).append(edgeQuantity).append(ln);
        for(int v=0; v<vertexCapacity; v++){
            for (Vertex w:neighbours[v])
                o.append(v + " connected with " + w.cost + " to " + w.index).append(ln);
        }
        return o.toString();
    }

    /* TODO Return a HashMap of adjacent edges / vertices */
    public HashSet<Vertex> adj(int v) {
        return (v<0 || v>vertexCapacity)?new HashSet<>():neighbours[v];
    }

    public DirectedGraphWeighted(int numNodes){
        initialize(numNodes);
    }

    public int findLowestCost() {
        /* NE PAS MODIFIER CE CODE */
        int totalCost = 0;

        Heap vertices = new Heap(vertexCapacity + 1);
        /* NE PAS MODIFIER CE CODE */

        /* TODO Add all of the vertices to the Heap start at Index 1. The default cost should be the largest possible value for an integer */
        for(int v=1; v<vertexCapacity;v++) vertices.add(new Vertex(Integer.MAX_VALUE,v));

        while(true){
            Vertex v = vertices.findSmallestUnknown();
            if(v == null) break;
            v.known = true;
            for(Vertex w: adj(v.index)){
                /* TODO Evaluate each edge to see if the total cost is less than the cost contained in nodes. */
                /* TODO Decrease the cost of the vertex in the Heap using decreaseKey if conditions are met */
                int i =0;
                for(; i<vertices.Heap.length; i++) if(vertices.Heap[i] !=null && vertices.Heap[i].index == w.index) break;
                if(i >= vertices.Heap.length) continue; //continue if w is not in the heap

                if(v.cost + w.cost < vertices.Heap[i].cost){
                    vertices.decreaseKey(w,v.cost + w.cost>0?v.cost + w.cost:w.cost);
                    w.path = v;

                }

            }
        }

        /*TODO Add up the total cost of the elements in the Heap */
        while (!vertices.isEmpty)
            totalCost += vertices.poll().cost;


        return totalCost;
    }
}
