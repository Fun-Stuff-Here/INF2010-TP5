import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Interview {
    private static final int[][] DIRECTIONS = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int minCost(int[][] grid) {
        /* Ne pas modifier ce code */
        int m = grid.length, n = grid[0].length;
        int maxPosX = m - 1,maxPosY = n - 1 ;

        Cell[][] costs = new Cell[m][n];
        for (Cell[] cells : costs){
            for(Cell c: cells ){
                c.cost = Integer.MAX_VALUE;
            }
        }
        costs[0][0].cost = 0;

        PriorityQueue<Cell> heap = new PriorityQueue<>();
        heap.add(new Cell(0,0,0)); // Index 0: x , Index 1: y, Index 2 : cout
        /* Ne pas modifier ce code */


        while (!heap.isEmpty()) {
            Cell curr = heap.poll();

            if (false /*TODO Condition si on arrive à la fin de la matrice */) return curr.cost;


            for (int i = 0; i < DIRECTIONS.length; i++) {
                int[] dir = DIRECTIONS[i];
                int newX = curr.xPos + dir[0], newY = curr.yPos + dir[1];
                if (false/*TODO Condition qui assure qu'on est toujours dans les bornes de la matrice */) continue;

                int newCost = -1 /*TODO Calculer le nouveau cout selon le deplacement*/;

                if (costs[newX][newY].cost > newCost) {
                    /*TODO Mettre le nouveau cout au bonne emplacement dans la matrice & l'ajouter au heap.*/
                }
            }
        }

        return -1;
    }
}
