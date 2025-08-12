package heima;

import java.lang.invoke.StringConcatException;
import java.util.Arrays;

public class Recursion {

    public static int factorial(int index){

        if(index==0) return 1;
        return index*factorial(index-1);
    }

    public static void reverse(String str) throws StringConcatException{
        if(str.length()==0) throw new StringConcatException("fyucktyoiu");
         if(1 == str.length())  return;
         reverse(str.substring(1));
        System.out.println(str.charAt(0));
    }

    public static int binaryRecursionSearch(int[] a,int target,int i,int j){
        if (i > j)  return -1;      
        int m = (i+j)/2;
        if(a[m]==target) return m;
        if(a[m]<target)  return binaryRecursionSearch(a,target,m+1,j);
        if(a[m]>target)  return binaryRecursionSearch(a,target,i,m-1);
        return -1;
    }
    public static void bubbleRecursion(int[] arr){

        if(arr.length==1) return;
        for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    //交换位置
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        int[] prefix = Arrays.copyOf(arr, arr.length - 1);
        bubbleRecursion(prefix);

    }

    public static void SelectionRecursion(int[] arr){
        if(arr.length==1) return;
        //一次插入
        int max=arr[0];
        int j=0;
        for(j=1;j<arr.length;j++){
            if(arr[j]>max) max=arr[j];
        }
        //交换位置
        if(max!=arr[0]){
        int temp = arr[j];
        arr[j]=arr[arr.length-1];
        arr[arr.length-1]=temp;
        }
        int[] prefix = Arrays.copyOf(arr, arr.length - 1);
        SelectionRecursion(prefix);
    }
    public static void insertionRecursion(int[] a,int low){
        if(low==a.length) return;
        int t = a[low];
        int i = low-1;
        while(i>0&&a[i]>t){
            a[i+1]=a[i];
            i--;
        }
        a[i+1]=t;
        insertionRecursion(a, low+1);
    }
    private static final int[] cache = new int[20]; // Define static cache array outside method
    public static int Fibonacci(int n){
        Arrays.fill(cache, -1);
        cache[0]=0;
        cache[1]=1;
        if(cache[n]!=-1){
            return cache[n];
        }
            int res = Fibonacci(n-1)+Fibonacci(n-2);
            cache[n]=res;
        return cache[n];
    } 
    public static void main(String[] args) { 
        System.out.println(Fibonacci(0));
    }
}
