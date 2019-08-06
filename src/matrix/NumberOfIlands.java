package matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的
 */
public class NumberOfIlands {

    public static void main(String[] args) {
        NumberOfIlands noi = new NumberOfIlands();
        char[][] grid= {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(noi.numIslands(grid));

    }

    private static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};

    //深度优先遍历  DFS
    //找到一个陆地点，由这一点展开进行深度优先搜索（要使用递归）
    /*public int numIslands(char[][] grid) {
        int res = 0;
        if(grid.length<=0){
            return 0;
        }

        boolean[][] flag = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'&& !flag[i][j]){
                    res++;
                    dfs(i,j,grid,flag);
                }

            }
        }
        return res;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] flag) {
        flag[i][j] = true;

        for(int k=0;k<4;k++){
            int tempx = i+directions[k][0];
            int tempy = j+directions[k][1];

            if(isArea(tempx,tempy,grid.length,grid[0].length) && grid[tempx][tempy]=='1' && !flag[tempx][tempy]){
                dfs(tempx,tempy,grid,flag);
            }

        }

    }

    private boolean isArea(int tempx, int tempy, int lengthx, int lengthy) {
        return tempx>=0 && tempx<lengthx && tempy>=0 && tempy<lengthy;
    }*/



    //使用广度优先遍历   BFS
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid.length <= 0) {
            return 0;
        }

        boolean[][] flag = new boolean[grid.length][grid[0].length];
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !flag[i][j]){
                    res++;
                    queue.offer(i*grid[0].length+j+1);
                    while(!queue.isEmpty()){
                        int head = queue.poll();
                        int tempx = (head-1)/grid[0].length;
                        int tempy = (head-1)%grid[0].length;
                        flag[tempx][tempy] = true;
                        for(int k=0;k<4;k++){
                            int indexx = tempx+directions[k][0];
                            int indexy = tempy+directions[k][1];
                            if(isArea(indexx,indexy,grid.length,grid[0].length) && grid[indexx][indexy]=='1' && !flag[indexx][indexy]){
                                queue.offer(indexx*grid[0].length+indexy+1);
                                //为防止元素重复进入队列，第一次进入队列即标记，避免超时
                                flag[indexx][indexy] = true;
                            }
                        }

                    }
                }

            }
        }

        return res;
    }
    //越界检测
    private boolean isArea(int tempx, int tempy, int lengthx, int lengthy) {
        return tempx>=0 && tempx<lengthx && tempy>=0 && tempy<lengthy;
    }
}
