package heima;

public class pascalTriangle {
    public static int element(int i,int j,int[][] cache){
        
        if(cache[i][j]>0) return cache[i][j];
        if(j==0||j==i){
            cache[i][j]=1;
            return 1;       
        } 
        cache[i][j]= element(i-1,j-1,cache)+element(i-1, j,cache);
        return cache[i][j];
    }
    public static void main(String[] args) {
        int[][] cache = new int[10][];
        for(int i=0;i<10;i++){
            cache[i] = new int[i+1];
            for(int j=0;j<i+1;j++){
                System.out.printf("%4d",element(i, j, cache));
                
            }
            System.out.println("\n");
        }
    }
}
