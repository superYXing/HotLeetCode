/*
 * @lc app=leetcode id=1122 lang=java
 *
 * [1122] Relative Sort Array
 */
import java.util.*;
// @lc code=start
class Solution {

 		//************************使用计数排序优化************************
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
	int[] count = new int[1001];
	int[] res = new int[arr1.length];
	int k=0;
	for(int n:arr1){
		count[n]++;
	}
	for(int n:arr2){
		while(count[n] > 0){
			res[k++] = n;
            count[n]--;
		}
	}
	for(int i=0;i<1001;i++){
		while(count[i] > 0){
			res[k++] = i;
            count[i]--;
		}
	}	
	return res;
	}
	//*************非优化，时间复杂度是 O(n*logn)**************
	/* 
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] res = new int[arr1.length];
		int[] temp = new int[arr1.length];
		int k=0;
		int t=0;
        for(int num:arr2){
			for(int i=0;i<arr1.length;i++){
				if(arr1[i]==num){

                res[k++] = num;
				arr1[i] = -1;  // 标记已使用
				}
			}
            
		}
		        // 收集arr1中剩余的元素
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=-1){
                temp[t++] = arr1[i];
            }
        }
		//给temp排序
		Arrays.sort(temp,0,t);
		//加入到res的后面
		for(int i=0;i<t;i++) res[k++] = temp[i];
		return res;
    }
		*/
}
// @lc code=end

