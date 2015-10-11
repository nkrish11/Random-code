package MergeSort;


public class mergeSort {
	static int[] arr = {52,2,12,23,4,5,1,99};
//	static int[] temp = new int[arr.length];
	
	
	public static void main(String args[]){
//		int[] arr = {2,52,12,23,4,5,1,99};
		MS(0,arr.length-1);
		
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
	}
	
	public static void MS(int start, int end){
		
		if (start<end){
			int mid = (start+end)/2;
			MS(start,mid);
			MS(mid+1,end);
			merge(start,mid,end);
		}
	}
	
	public static void merge(int start,int mid, int end){
		int[] temp = new int[arr.length];
		for(int a=start;a<=end;a++){
			temp[a] = arr[a];
		}
		
		int i = start;
		int j = mid+1;
		int k = start;
		
		while (i<=mid && j<=end){
			if(temp[i]<=temp[j]){
				arr[k]=temp[i];
				i++;
				k++;
				
			}else if(temp[j]<temp[i]){
				arr[k]=temp[j];
				j++;
				k++;
			}
		}
		
		if(i<=mid){
			while(i<=mid){
				arr[k] = temp[i];
				i++;
				k++;
			}
		}else if(j<=end){
			while(j<=end){
				arr[k] = temp[j];
				j++;
				k++;
				
			}
		}
	}

}
