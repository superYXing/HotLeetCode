package heima;

public class insertArr {
    public static void main(String[] args){
        int[] a = {2,4,5,9,10,32,45};
        //已知插入点和数字，插入到此数组
        int insertIndex = 5;
        int insertNum = 20;
        //新建数组,长度是a数组长度+1
        int[] b =new int[a.length+1];
        //拷贝插入点之前的数据
        System.arraycopy(a, 0, b, 0 ,insertIndex);
        b[insertIndex] = insertNum;
        System.arraycopy(a, insertIndex, b, insertIndex+1, a.length-insertIndex);
        for(int i=0;i<b.length;i++)
        System.out.println(b[i]);
    }
}
