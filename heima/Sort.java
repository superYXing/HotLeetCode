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


	static void toString(int[] arr){
		for(int i = 0 ; i<arr.length ; i++){
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		int[] arr = {7,8,3,6,9,4,2,5,1};
		arr = heapSort(arr);
		toString(arr);
	}
}
