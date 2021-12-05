import java.security.InvalidParameterException;
import java.util.HashSet;

public class DirectedGraphWeighted {
    public HashSet<Vertex>[] neighbours;
    public int vertexCapacity;
    public int edgeQuantity;

    /* TODO Initialize de DirectedGraph */
    @SuppressWarnings("unchecked")
    public void initialize(int numNodes) {
        if(numNodes < 0) throw new InvalidParameterException();
        vertexCapacity = numNodes;
        edgeQuantity = 0;
        neighbours = new HashSet[numNodes];
        for(int v = 0; v < numNodes; v++) neighbours[v] = new HashSet<>();
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
        for(int v = 0; v < edgeQuantity; v++){
            for (Vertex vertex : neighbours[v] )
                o.append(v).append(" is connected to ").append(vertex.index).append(" with a cost of ").append(vertex.cost).append(ln);
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

            /* TODO Evaluate each edge to see if the total cost is less than the cost contained in nodes. */
            /* Le nombre d'itération maximale serait de edgeQuantity dans le cas où tous les arcs sont connecté à un seul noeud,
             * et minimale de 0 lorsque le noeud n'a pas de voisin*/
            for(Vertex w: adj(v.index)){

                int i =0;
                for(; i<vertices.Heap.length; i++) if(vertices.Heap[i] !=null && vertices.Heap[i].index == w.index) break;
                if(i >= vertices.Heap.length) continue; //continue if w is not in the heap

                /* TODO Decrease the cost of the vertex in the Heap using decreaseKey if conditions are met */
                /* Dans le pire cas, le nombre de modification du coût pour un sommet est de edgeQuantity
                 * puisque ce serait le cas où chaque arc donne un nouveau coût minimale pour se rendre au sommet.*/
                if(v.cost + w.cost < vertices.Heap[i].cost){
                    vertices.decreaseKey(w,v.cost + w.cost>0?v.cost + w.cost:w.cost);
                    w.path = v;
                }
            }
        }

        /* TODO Add up the total cost of the elements in the Heap */
        /* Le nombre d'itérations pour la boucles dépends du nombres de sommets.
         * a. 10   sommets : 10   itérations
         * b. 100  sommets : 100  itérations
         * c. 1000 sommets : 1000 itérations*/
        while (!vertices.isEmpty)
            totalCost += vertices.poll().cost;

        return totalCost;
    }
}
