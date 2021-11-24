public class Main {

    public static void main(String[] args){
        UndirectedGraph graph = new UndirectedGraph(3);
        graph.connect(1,2);
        graph.connect(3,4);
        graph.connect(2,3);
        graph.connect(4,5);
        DirectedGraphWeighted graph2 = new DirectedGraphWeighted(7);
        graph2.connect(1,2,new Vertex(3,2));
        graph2.connect(2,1,new Vertex(4,1));
        graph2.connect(0,1,new Vertex(1,1));
        graph2.connect(0,2,new Vertex(1,2));
        graph2.connect(0,3,new Vertex(1,3));
        graph2.connect(0,4,new Vertex(1,4));
        graph2.connect(0,5,new Vertex(1,5));
        graph2.connect(0,6,new Vertex(1,6));


        System.out.println(graph.toString());
        System.out.println(graph2.toString());
        System.out.println(graph2.findLowestCost());
    }

}
