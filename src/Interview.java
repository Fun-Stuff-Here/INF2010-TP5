import java.util.PriorityQueue;

public class Interview {
    private static final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int minCost(Cell[][] grid) {
        /* Ne pas modifier ce code */

        int m = grid.length, n = grid[0].length;
        int maxPosX = m - 1,maxPosY = n - 1 ;

        Cell[][] costs = new Cell[m][n];
        for(int i=0; i<costs.length;++i)
            for(int j=0; j<costs[0].length;++j)
                costs[i][j]=new Cell(0,0, Integer.MAX_VALUE);

        costs[0][0].cost = 0;

        PriorityQueue<Cell> heap = new PriorityQueue<>();
        heap.offer(new Cell(0,0,0)); // Index 0: x , Index 1: y, Index 2 : cout
        /* Ne pas modifier ce code */

        while (!heap.isEmpty()) {

            Cell curr = heap.poll();
            int x = curr.xPos, y = curr.yPos;

            if (heap.isEmpty()&& x ==maxPosX && y == maxPosY
                    /*TODO Condition si on arrive à la fin de la matrice */)
                return costs[maxPosX][maxPosY].cost;

            for (int i = 0; i < DIRECTIONS.length; i++) {
                int[] dir = DIRECTIONS[i];
                int newX = x+ dir[0], newY = y + dir[1];
                if (newX<0 || newX>maxPosX || newY<0 || newY>maxPosY
                    /*TODO Condition qui assure qu'on est toujours dans les bornes de la matrice */) continue;

                int newCost = grid[x][y].cost == (i+1) ? costs[x][y].cost: costs[x][y].cost+1; /*TODO Calculer le nouveau cout selon le deplacement*/

                if (costs[newX][newY].cost > newCost) {
                    /*TODO Mettre le nouveau cout au bonne emplacement dans la matrice & l'ajouter au heap.*/
                    costs[newX][newY].cost= newCost;
                    heap.add(grid[newX][newY]);
                }
            }
        }

        return costs[maxPosX][maxPosY].cost;
    }

}
