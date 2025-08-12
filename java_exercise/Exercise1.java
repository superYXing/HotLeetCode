package java_exercise;

public class Exercise1 {
    public  static int larger(int x,int y){
        if(x > y){
            return x;
        }else{
 return y;
        }
           
        
    }
    public static void main(String[] args){
        for(int i=0;i<=10;i++){
            System.out.println("i is :"+ i);

        }

        System.out.println(larger(5,6));
    }
}
