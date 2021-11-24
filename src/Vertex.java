public class Vertex implements Comparable<Vertex> {
    int cost;
    int index;
    Vertex path;
    boolean known;

    public Vertex(int cost, int index){
        this.cost = cost;
        this.index = index;
        known = false;
    }

    @Override
    public int compareTo(Vertex o) {
        /* Implement comparison between the cost of two edges */
        return Integer.compare(this.cost, o.cost);
    }

    public String toString(){
        StringBuilder o = new StringBuilder();
        String ln = System.getProperty("line.separator");
        o.append(cost + " to "+ path);
        return o.toString();
    }
}
