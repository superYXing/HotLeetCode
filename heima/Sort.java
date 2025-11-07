package heima;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Sort {
	static int[] bubbleSort(int[] arr){
		boolean swaped = false;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swaped = true;
				}	
			}
			if(!swaped) break;
		}
		return arr;
	}
	static int[] selectionSort(int[] arr){
		for(int i=arr.length-1;i>0;i--){
			int max = i;
		for(int j=0;j<i;j++){
			if(arr[max]<arr[j]) max=j;
		}
		int t = arr[max];
		arr[max] = arr[i];
		arr[i] = t;
		}
		return arr;
	}

	static int[] heapSort(int[] arr){


		heapify(arr);
		for(int right = arr.length-1;right>0;right--){
			int temp = arr[right];
			arr[right] = arr[0];
			arr[0] = temp;
			arr = down(0, arr, right);
		}	
		  return arr;
    }
  
	

	static int[] down(int i,int[] arr,int size){

		while(true){
			int leftChild = 2*i+1;
			int rightChild = 2*i+2;
			int max = i;
			if(leftChild<size&&arr[max]<arr[leftChild]){
				max = leftChild;
			}
			if(rightChild<size&&arr[max]<arr[rightChild]){
				max = rightChild;
			}
			if(max == i) break;
			int temp = arr[max];
			arr[max] = arr[i];
			arr[i] = temp;
			i = max;
		}
		return arr;
	}

	static int[] heapify(int[] arr){
		int size = arr.length;
		for(int i = size /2 -1 ; i>=0;i--){
			arr = down(i, arr,size);
		}
		return arr;
	}

	static int[] insertionSort(int[] arr){
		for(int i=1;i<arr.length;i++){
			if(arr[i]<arr[i-1]){  //从小到大排序，如果后值比前值小，才交换
				int temp=arr[i];
				int j;
				for(j=i-1;j>=0&&arr[j]>temp;j--){
					arr[j+1] = arr[j];
				}
				arr[j+1] = temp;
			}
		}
		return arr;
	}

	static int[] shellSort(int[] arr){
		//间隔设成数组长度的一半
		for(int gap=arr.length>>1;gap>=1;gap=gap>>1){
		//insertionSort
		for(int i=gap;i<arr.length;i++){
			int temp = arr[i];
			int j;
			for(j=i-gap;j>=0&&arr[j]>temp;j=j-gap){
				arr[j+gap] = arr[j];
			}
			arr[j+gap] = temp;
		}
	}
		return arr;
	}

	static void toString(int[] arr){
		for(int i = 0 ; i<arr.length ; i++){
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		int[] arr = {50,40,30,20,10,45,35,25,15,5,48,38,28,18,8};
		arr = shellSort(arr);
		toString(arr);
	}
}
