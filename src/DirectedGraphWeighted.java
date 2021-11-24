import java.util.HashSet;

public class DirectedGraphWeighted {
    private HashSet<Vertex>[] neighbours;
    private int nodeCapacity;
    private int graphConnections;

    /* TODO Initialize de DirectedGraph */
    public void initialize(int numNodes) {
        nodeCapacity = numNodes;
        graphConnections = 0;
        neighbours = new HashSet[numNodes];
        for(int i = 0; i < numNodes; i++) neighbours[i] = new HashSet();
    }

    /*TODO Create an edge between the vertices - Veuillez vous referez aux notes de cours */
    public void connect(int v1, int v2, Vertex vertex){
        if(v1<0 || v1>=nodeCapacity) return; //check that v1 is a valid node in the graph, we can only connect edges to existing node
        if(v2<0 || v2>=nodeCapacity) return; //check that v2 is a valid node in the graph, we can only connect edges to existing node
        if(neighbours[v1].contains(v2)) return; // check if edge is already in the graph, we don't allow duplicate edges

        neighbours[v1].add(vertex);
        graphConnections++;

    }

    /* TODO Print all the edges connecting vertices*/
    public String toString(){
        StringBuilder o = new StringBuilder();
        String ln = System.getProperty("line.separator");
        o.append(nodeCapacity).append(ln).append(graphConnections).append(ln);
        for(int v=0; v<nodeCapacity; v++){
            for (Vertex w:neighbours[v])
                o.append(v + " connected with " + w.toString()).append(ln);
        }
        return o.toString();
    }

    /* TODO Return a HashMap of adjacent edges / vertices */
    public HashSet<Vertex> adj(int v) {
        return (v<0 || v>nodeCapacity)?new HashSet<>():neighbours[v];
    }

    public DirectedGraphWeighted(int numNodes){
        initialize(numNodes);
    }

    public int findLowestCost() {
        /* NE PAS MODIFIER CE CODE */
        int totalCost = 0;

        Heap vertices = new Heap(nodeCapacity + 1);
        /* TODO Add all of the vertices to the Heap start at Index 1. The default cost should be the largest possible value */
        for(int v=0; v<nodeCapacity; v++){
            vertices.add(new Vertex(Integer.MAX_VALUE,v));
        }

        /* NE PAS MODIFIER CE CODE */
        while(true){
            Vertex v = vertices.findSmallestUnknown();
            if(v == null) break;
            v.known = true;
            for(Vertex w: adj(v.index)){
                /* TODO Evaluate each edge to see if the total cost is less than the cost contained in nodes. */
                /* TODO Decrease the cost of the vertex in the Heap using decreaseKey if conditions are met */
                if(!w.known){
                    int stuff =1; /*TODO comment on get le poid entre v et w ?!?!*/
                    if(v.cost + stuff <w.cost){
                        vertices.decreaseKey(w,v.cost + stuff);
                        w.path = v;
                    }
                }

            }
        }

        /*TODO Add up the total cost of the elements in the Heap */
        while (!vertices.isEmpty){
            Vertex v = vertices.poll();
            totalCost += v.cost;
            v= v.path;
        }

        return totalCost;
    }
}
