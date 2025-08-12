package heima;

public class DynamicArr {
    public static void main(String[] args){
        //初始化长度为8的数组
        int size = 8;
        int[] arr = new int[size];
        // 插入元素
        for(int i=0;i<size;i++) arr[i] = i;
        //删除第pos个元素
        int pos = 5;
        for(int i=pos;i<size-1;i++){
            arr[i] = arr[i+1];
        }
        size--;
         for(int i=0;i<size;i++)
        System.out.println(arr[i]);
        //增加一个元素8
        size++;
        int[] newarr = new int[size];
        for(int i =0;i<size-1;i++){
            newarr[i] = arr[i];
        }
        newarr[size-1] = 8;
        for(int i=0;i<size;i++)
        System.out.println(newarr[i]);
    }
}
