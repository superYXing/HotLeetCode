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

	static int[] mergeSort(int[] arr){
		split(arr,0,arr.length-1);
		return arr;
	}

	static void split(int[] arr,int left, int right){
		if(left==right) return;

		//分
		int mid = (left+right) >>> 1;
		split(arr,left,mid);
		split(arr, mid+1, right);

		//合
		merge(arr,left,mid,right);
	}

	static void merge(int[] arr, int left, int mid, int right){
		int i=left,j=mid+1,num=0;
		int temp[] = new int[right-left+1];
		while(i<=mid&&j<=right){
			temp[num++] = arr[i]<=arr[j]?arr[i++]:arr[j++];
		}
		if(i<=mid){
			System.arraycopy(arr, i, temp, num, mid-i+1);
		}else if(j<=right){
			System.arraycopy(arr, j, temp, num, right-j+1);
		}
		//把temp赋值给nums1
		System.arraycopy(temp,0,arr,left,right-left+1);
	}

	static int[] mergeBottomUp(int[] arr){
		int n = arr.length;

		for(int width=1;width<n;width*=2){
			for(int left=0;left<n;left+=2*width){
 				int right = Math.min(left+2*width-1, n-1);
				System.out.printf("width: %d,[%d,%d]%n", width, left, right);
				int mid = Math.min(left+width-1,n-1);
				merge(arr, left, mid, right);
			}
		}
		return arr;
	}
static class QuickSort{


	static int[] quickSort_LOMUTO(int[] arr){
		quick_LOMUTO(arr,0,arr.length-1);
		return arr;
	}

	public int[] quickSort_doubleside(int[] arr){
		quick_doubleside(arr,0,arr.length-1);
		return arr;
	}
	static void quick_LOMUTO(int[] arr, int left, int right){
				// System.out.printf("[%d,%d]%n",left, right);
		if(left>=right) return;
		int p = partition_LOMUTO(arr,left,right);

		// toString(arr);
		quick_LOMUTO(arr, left, p-1);
		quick_LOMUTO(arr, p+1, right);
	}
	static int partition_LOMUTO(int[] arr, int left, int right){
		int i = left;
		int j = left;
		int base = arr[right];
		while(j<right){
			if(arr[j]<base){
				if(i!=j){
				swap(arr,j,i);
				}
			i++;    //j永远在i的前面，j先到达right
			}
			j++;
		}

		swap(arr,i,right);
		return i;
	}
	public void quick_doubleside(int[] arr, int left, int right){
				// System.out.printf("[%d,%d]%n",left, right);
		if(left>=right) return;
		int p = partition_doubleside(arr,left,right);

		// toString(arr);
		quick_doubleside(arr, left, p-1);
		quick_doubleside(arr, p+1, right);
	}
	public int partition_doubleside(int[] arr, int left, int right){
		int i=left;
		int j = right;

		// 随机选择基准点,并与最左侧元素交换
		int randomIndex = left + (int) (Math.random() * (right - left + 1));
		swap(arr, left, randomIndex);

		int base = arr[left];
		while(i!=j){
			if(arr[j]<base&&arr[i]>base){
				swap(arr, i, j);
			}else if(arr[j]>=base){
				j--;
			}else if(arr[i]<=base){
				i++;
			}
		}
		swap(arr, i, left);
		return i;
	}
	static void swap(int[] arr,int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
	static int[] countSort(int[] arr){
		int max = arr[0];
		//改进：支持负数的情况:将最小值映射到索引0
		int min = arr[0];
		for(int i=0;i<arr.length;i++){
			max = arr[i]>max?arr[i]:max;
			min = arr[i]<min?arr[i]:min;
		}
		//使用偏移量来记录tmp数组
		int[] tmp = new int[max+1-min];  //min为负数
		for(int i=0;i<arr.length;i++){
			tmp[arr[i]-min]++;   //根据偏移量，找到对应索引
		}
		int idx = 0;
		for(int i=0;i<tmp.length;i++){
			int count = tmp[i];
			while(count-->0){
				arr[idx++] =  i+min; //偏移量为min
			}
		}
		return arr;
	}
	 static int[] bucketSort(int[] arr){

		//改进：基于计数的桶排序，根据数组最大最小元素之差来建桶
		//使用计数排序的找到最小和最大值的方法

		int max = arr[0];
		int min = arr[0];
		for(int i=0;i<arr.length;i++){
			max = arr[i]>max?arr[i]:max;
			min = arr[i]<min?arr[i]:min;
		}
		int count = max-min+1;
		//改进：让每个桶有range个元素，从而减少数组的创建操作
		int range = 3;
		ArrayList<Integer>[] buckets = new ArrayList[(count-1)/range+1]; //桶的大小基于数组元素设立
		for(int i=0;i<buckets.length;i++){
			buckets[i] = new ArrayList<Integer>();
		}
		for(int num:arr){
			buckets[(num-min)/range].addLast(num); //基于偏移量，在正确的桶位置添加
		}
		int k=0;
    // 对每个桶进行排序
    for(int i=0;i<buckets.length;i++){
				//输出每个桶
				System.out.println(buckets[i].toString());
				
		
        int[] temp = buckets[i].stream().mapToInt(Integer::intValue).toArray();

        insertionSort(temp);
        
        // 将排序后的结果写回 ArrayList
        buckets[i].clear();
        for(int num : temp){
            buckets[i].add(num);
        }
			//复原到原数组
		for(int v:buckets[i]){
			arr[k++] =v;
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
		int[] arr = {4,3,2,1,5,8,7,9,12,4,-2,-3};
		arr = bucketSort(arr);
		toString(arr);
		// QuickSort quicksort = new QuickSort();
		// arr = quicksort.quickSort_doubleside(arr);
		// toString(arr);
	}
}
