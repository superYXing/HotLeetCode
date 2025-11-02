package heima;

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


	static void toString(int[] arr){
		for(int i = 0 ; i<arr.length ; i++){
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		int[] arr = {7,8,3,6,9,4,2,5,1};
		arr = selectionSort(arr);
		toString(arr);
	}
}
