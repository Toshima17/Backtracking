public class BacktrakingPracticeQuestion {
    
    static int n; // size of the maze (n x n)

    public static void main(String[] args) {
        int[][] maze = {
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {0, 0, 0, 1},
            {1, 1, 0, 1}
        };  
        
        // int[][] maze= { {1,0,0,0},
        //     {0,0,0,0},
        //     {0,0,0,0},
        //     {0,0,0,0}
        // };

        n = maze.length;
        int[][] path = new int[n][n];          // to store current path
        boolean[][] visited = new boolean[n][n]; // to avoid revisiting same cell

        // solve(0, 0, maze, path, visited);

        int n=2;
        String str=" ";
        generateString(n, str);
    }

    // Recursive function to explore all paths
    public static void solve(int x, int y, int[][] maze, int[][] path, boolean[][] visited) {
        // 1. Base cases: boundary, block, already visited
        if (x < 0 || y < 0 || x >= n || y >= n) return;
        if (maze[x][y] == 0 || visited[x][y]) return;

        // 2. Mark cell as part of path
        path[x][y] = 1;
        visited[x][y] = true;

        // 3. Destination reached: print current path
        if (x == n - 1 && y == n - 1) {
            printPath(path);
            // backtrack before return
            path[x][y] = 0;
            visited[x][y] = false;
            return;
        }

        // 4. Explore all 4 directions
        solve(x + 1, y, maze, path, visited); // Down
        solve(x - 1, y, maze, path, visited); // Up
        solve(x, y + 1, maze, path, visited); // Right
        solve(x, y - 1, maze, path, visited); // Left

        // 5. Backtrack: unmark current cell
        path[x][y] = 0;
        visited[x][y] = false;
    }

    // Helper to print 2D path
    public static void printPath(int[][] path) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(); // separate different paths
    }



    //print all the binary number of size n problem
    public static void generateString(int n , String str){
        //base case
        if(n==0){
            System.out.println(str);
            return;
        }

        //recursion
        generateString(n-1, str + "0"); //adding 0
        generateString(n-1, str + "1"); //adding 1 
    }
}


