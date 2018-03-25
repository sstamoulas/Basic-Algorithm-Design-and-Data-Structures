package sorting;


public class Sorting {
	
	/**
	 * Implement the mergesort function, which should sort the array of
	 * integers in place
	 * 
	 * You will probably want to use helper functions here, as described in the lecture recordings
	 * (ex. merge(), a helper mergesort function)
	 * @param arr
	 */
	public static void mergeSort(CompareInt[] arr) {
		//TODO
		mergeSort(arr, 0, arr.length - 1);
	}
	
	public static void mergeSort(CompareInt[] arr, int low, int high) {
		if(high - low < 1) return ;
		int mid = (low + high)/2;
		
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		
		CompareInt[] arrayA = copyArray(arr, low, mid);
		CompareInt[] arrayB = copyArray(arr, mid + 1, high);
		CompareInt[] arrayC = merge(arrayA, arrayB);
		
		int startCounter = 0;
		for(int i = low; i <= mid; i++) { 
			arr[i] = arrayC[startCounter++];
		}
		
		for(int i = mid + 1; i < high + 1; i++) { 
			arr[i] = arrayC[startCounter++];
		}
	}
	
	public static CompareInt[] copyArray(CompareInt[] arr, int start, int end) {
		CompareInt[] copiedArray = new CompareInt[end - start + 1];
		int index = 0;
		
		for(int i = start; i <= end; i++) {
			copiedArray[index++] = arr[i];
		}
		
		return copiedArray;
	}
	
	public static CompareInt[] merge(CompareInt[] a, CompareInt[] b) {
		CompareInt[] arrayC = new CompareInt[a.length + b.length];
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < a.length && j < b.length) {
			if(a[i].compareTo(b[j]) < 0){
				arrayC[k++] = a[i++];
			}
			else {
				arrayC[k++] = b[j++];
			}
		}
		
		while(i < a.length) {
			arrayC[k++] = a[i++];
		}
		
		while(j < b.length) {
			arrayC[k++] = b[j++];
		}
		
		return arrayC;
	}
	
	/**
	 * Implement the quickSelect
	 * 
	 * Again, you will probably want to use helper functions here
	 * (ex. partition(), a helper quickselect function)
	 */
	public static CompareInt quickSelect(int k, CompareInt[] arr) {
		//TODO
		return quickSelect(arr, 0, arr.length - 1, --k);
	}
	
	public static CompareInt quickSelect(CompareInt[] arr, int low, int high, int k) {
		if(high == low) return arr[low];

		int pivotLocation = partition(arr, low, high);
		if(pivotLocation == k) {
			return arr[k];
		}
		else if(pivotLocation > k) {
			return quickSelect(arr, low, pivotLocation - 1, k);
		}
		else {
			return quickSelect(arr, pivotLocation + 1, high, k);
		}
	}
	
	public static int partition(CompareInt[] arr, int low, int high) { 
		int pivot = high;
		int j = low;
		
		for(int i = low; i < high; i++) {
			if(arr[pivot].compareTo(arr[i]) > 0) {
				swap(arr, i, j);
				j++;
			}
		}
		
		swap(arr, j, pivot);
		
		return j;
	}
	
	public static void swap(CompareInt[] arr, int i, int j) { 
		CompareInt temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
