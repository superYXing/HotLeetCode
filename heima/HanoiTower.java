package heima;

import java.util.LinkedList;

public class HanoiTower {

    
    public HanoiTower() {
       
    }
 /**
     * 递归移动n个圆盘从源柱子到目标柱子
     * @param n 要移动的圆盘数量
     * @param A 源柱子（圆盘的起始位置）
     * @param B 辅助柱子（临时存放圆盘）
     * @param C 目标柱子（圆盘的最终位置）
     */
    public void move(int n,LinkedList<Integer> A,LinkedList<Integer> B,LinkedList<Integer> C){
        if(n==0) return;
        //输出每个步骤的进度

        //把A上的n-1个圆盘，借助C移动到B
        move(n-1,A,C,B);
        //把A上的最后1个圆盘，移动到C
        C.addLast(A.removeLast());
                        System.out.println("当前圆盘位置："+A+B+C);
        //把B上的n-1个圆盘，借助A移动到C
        move(n-1,B,A,C);


    }

    public void print(LinkedList<Integer> A,LinkedList<Integer> B,LinkedList<Integer> C){
        System.out.println("A:"+A);
        System.out.println("B:"+B);
        System.out.println("C:"+C);

    }

    public static void main(String[] args) {
    LinkedList<Integer> A = new LinkedList<Integer>();
    LinkedList<Integer> B = new LinkedList<Integer>();
    LinkedList<Integer> C = new LinkedList<Integer>();
        HanoiTower h = new HanoiTower();
         A.addLast(3);
        A.addLast(2);
        A.addLast(1);
        h.move(3,A,B,C);
        // h.print(A,B,C);
    }
}
