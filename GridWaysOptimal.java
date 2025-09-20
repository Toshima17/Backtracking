public class GridWaysOptimal {
    public static int factorial(int n){
        if(n==0 ||n<0){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int countGridWays(int n , int m){
        int ways= (factorial(n+m-2))/((factorial(n-1))*(factorial(m-1)));
        return ways;
    }
    public static void main(String[] args){
        int n=5;
        int m=5;
       System.out.println("Total no of ways for going source(0,0) to destination("+n+"*"+m+") is- "+countGridWays(n, m));
    }
}
