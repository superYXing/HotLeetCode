package heima;

import java.util.Scanner;

public class binarySearch {
    public static void main(String[] args){
        int[] arr = {2,5,8,12,15,23,29,32,55,72,81,85,106};
        // 二分查找
        int i = 0;
        int j = arr.length -1 ;
        int res = 15;
        boolean flag = false;
        while (i<=j){
           int m = (i+j) / 2;
            if(arr[m]>res){
                j = m-1;
            }
            else if(arr[m]<res){
                i = m+1;
            }
            else{
                flag = true;
                System.out.println("查找到结果，在第"+m+"个索引上");
                break;
            }
        }
        if(flag) System.out.println("Success");
        else System.out.println("Unsuccessful");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str);
        scanner.close(); // 关闭资源
    }
}
