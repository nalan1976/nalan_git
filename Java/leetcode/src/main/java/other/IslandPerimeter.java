package other;
/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

 Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

 The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.


 Example:

 Input:
 [[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

 Output: 16

 Explanation: The perimeter is the 16 yellow stripes in the image below:

 * */
import static org.junit.Assert.*;
import org.junit.Test;
public class IslandPerimeter {
    static public int islandPerimeter(int[][] grid) {
        if (grid == null)
            return 0;

        int count = 0;
        int colNum = grid[0].length;
        int rowNum = grid.length;

        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < colNum; j++){
                if (1 == grid[i][j]){
                    count += 4;
                    if (j + 1 < colNum && grid[i][j + 1] == 1){
                        count -= 2;
                    }
                    if (i + 1 < rowNum && grid[i + 1][j] == 1){
                        count -= 2;
                    }
                }
            }
        }
        return count;
     }

    @Test
    public void testRun() {
        int LAND[][] = {{0, 1, 0, 0},
        {1, 1, 1, 0},
        {0, 1, 0, 0},
        {1, 1, 0, 0}};
        assertEquals(16, IslandPerimeter.islandPerimeter(LAND));
    }
}