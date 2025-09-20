public class sudokuSolver {
    public static boolean isSafe(int row, int col, int sudoku[][], int digit){
        //check for veritcal
        for(int i=0;i<=8;i++){
            //col->same and if col me already wo digit present hai then return false;
            if(sudoku[i][col]==digit){
                return false;
            }
        }

        //check for Horizontal(same row)
        for(int j=0;j<=8;j++){
            //row->same and if row me already wo digit present hai then return false;
            if(sudoku[row][j]==digit){
                return false;
            }
        }

        //check for grid (in which we place digit in the cell)
           //find the starting row/ starting col of that grid in which that cell is present 
           // in which want to place the digit
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        //check if digit is prisent is already present in that grid (till before reaching to next grid)
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==digit){
                   return false;
                }
            }
        }
        //if inme se kahi me digit present nhi hai to place kr skte hai i.e return true.
       return true;
    }
    public static boolean PutDigitsInSudoku(int row, int col, int sudoku[][]){
        //base case
        if(row==9 && col==0){
            return true;
        }


        //recursion-kaam
          //default
        int nextcol=col+1;
        int nextrow=row;
        if(col+1==9){
           nextrow=row+1;
           nextcol=0;
        }

        if(sudoku[row][col]!=0){
            return PutDigitsInSudoku(nextrow, nextcol, sudoku);
        }
        for(int digit=1;digit<=9;digit++){
            //place digit at fisrt cell
            if(isSafe(row,col, sudoku, digit)){
                sudoku[row][col]=digit;
                //recursion for remaining
                if(PutDigitsInSudoku(nextrow, nextcol, sudoku)){ //solution exits
                   return true; // If the rest of the board is solvable, it stop and return success!

                }

                    //if path not exist // If it failed, undo (backtrack)
                sudoku[row][col]=0; 
                  //Backtracking -> This resets the cell to 0 and tries the next possibility. It keeps going back until it finds a previous placement that can be changed to make progress.


            }

        }
        // Suppose no digit fits → All recursive calls fail → return false.
        return false; 
    }
    public static void printSudoku(int sudoku[][]){
        for(int i=0;i<=8;i++){
            for(int j=0;j<=8;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String []args){
        int sudoku[][] = {
        {0, 0, 0, 0, 0 ,0, 0, 5, 0},
        {2, 0, 7, 0, 0, 9, 0, 0, 0},
        {6, 0, 0, 3, 5, 1, 0, 0, 0},
        {5, 0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 3, 0, 0, 0, 0, 0, 8},
        {0, 0, 0, 8, 2, 0 ,5, 3, 0},
        {0, 0, 0, 0, 7, 0, 8, 0, 4},
        {0, 0, 6, 2, 0, 0, 0, 0, 0},
        {0, 8, 0, 0, 0, 0, 7, 0, 0}
        };

        if(PutDigitsInSudoku(0,0, sudoku)){
            System.out.println("Solution exist");
            printSudoku(sudoku);
        }
        else{
             System.out.println("Solution Does not exist");
        }
        
    }
}
