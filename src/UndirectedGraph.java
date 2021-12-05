import java.security.InvalidParameterException;
import java.util.HashSet;


public class UndirectedGraph implements Graph {
    public HashSet<Integer>[] neighbours;
    public int nodeQuantity;
    public int graphEdges;

    @Override
    @SuppressWarnings("unchecked")
    public void initialize(int numNodes) {
        if(numNodes < 0) throw new InvalidParameterException();
        this.nodeQuantity = numNodes;
        graphEdges = 0;
        neighbours = new HashSet[numNodes];
        for(int i = 0; i < numNodes; i++) neighbours[i] = new HashSet<>();
    }

    @Override
    public void connect(int v1, int v2){
        /*TODO Implement necessary conditions for connect and justify each condition */

        /* Les deux premières conditions permettent de vérifier que
         les vertex qu'on essaie de connecter font parties du graphe
         en vérifiant que leur index est positif et inférieur
         au nombre de vertex dans le graphe
         sinon ces vertex ne font pas parties du graphe et on ne doit pas
         pouvoir les connecter.*/
        if(v1<0 || v1>=nodeQuantity) return; //check that v1 is a valid node in the graph, we can only connect edges to existing node
        if(v2<0 || v2>=nodeQuantity) return; //check that v2 is a valid node in the graph, we can only connect edges to existing node

        /* Cette condition vérifie que v2 ne se trouve pas
         * déjà dans les voisins de v1
         * si v1 et v2 sont déjà voisins, ils sont donc déjà connectés.*/
        if(neighbours[v1].contains(v2)) return; // check if edge is already in the graph, we don't allow duplicate edges

        neighbours[v1].add(v2);
        neighbours[v2].add(v1);
        graphEdges++;
    }

    public String toString(){
        StringBuilder o = new StringBuilder();
        String ln = System.getProperty("line.separator");
        o.append(nodeQuantity).append(ln).append(graphEdges).append(ln);
        for(int v = 0; v< nodeQuantity; v++)
            for(Object w : neighbours[v])
                o.append(v).append("-").append(w).append(ln);
        return o.toString();
    }

    @Override
    public HashSet<Integer> adj(int v) {
        return v < 0 || v >= nodeQuantity ? null : neighbours[v];
    }

    public UndirectedGraph(int numNodes){
        initialize(numNodes);
    }
}
