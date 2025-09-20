class nQueenProblem{
    public static boolean isSafe(char board[][], int row, int col){
        //check for straight up
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        
        //check for diagonal left
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        
        //check for diagonal right
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueens(char board[][], int row){
        //goal is to place n queens into n rows (1 at 1 row) Or 1 queen at 1 column.
        //base case
        if(row==board.length){
            printBoard(board);
            return;
        }
        //har ek row me har 1 col pr baithake dekhna hai
        
        for(int j=0; j<board.length;j++){
            if(isSafe(board,row,j)){
            //if yes then place queen at that position
                board[row][j]='Q';
                nQueens(board,row+1);
                //Backtrack step
                //remove that queen from that position to place another queen on that place
                board[row][j]='X';
                
            }
        }
       
    }
    public static void printBoard(char board[][]){
        
        System.out.println("----board-----");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j] +" ");
                
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
       int n=5;
       char board[][]=new char [n][n];
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               board[i][j]='X';
           }
       }
       nQueens(board,0);
    }
}