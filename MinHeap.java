package sorting;



/**
 * A Heap implementation class
 * 
 * @param heap the array that holds the heap data
 * @param size the number of elements currently stored in the heap
 */
public class MinHeap {
	
	CompareInt[] heap;
	int size;

	/**
	 * Constructs a new heap with maximum capacity n
	 * Remember to index your heap at 1 instead of 0!
	 * @param n the maximum number of elements allowed in the heap
	 */
	public MinHeap(int n) {
		heap = new CompareInt[n+1];
		size = 0;
	}
	
	/**
	 * Adds an element to the heap
	 * 
	 * @param val the value to be added to the heap
	 */
	public void add(CompareInt val) {
		heap[++size] = val;
		swim(heap, size);
	}
	
	public void swim(CompareInt[] heap, int k) {
		while(k > 1 && heap[k/2].compareTo(heap[k]) > 0) { 
			swap(heap, k, k/2);
			k = k/2;
		}
	}
	
	/**
	 * Extracts the smallest element from the heap
	 */
	public CompareInt extractMin() {
		CompareInt min = heap[1];
		heap[1] = heap[size--];
		sink(heap, 1);
		
		return min;
	}
	
	public void swap(CompareInt[] heap, int k, int smallest) {
		CompareInt temp = heap[k];
		heap[k] = heap[smallest];
		heap[smallest] = temp;
	}
	
	public void sink(CompareInt[] heap, int k) {
		while(2 * k <= size) {
			int smallest = 2 * k;
			if(heap[2 * k].compareTo(heap[2 * k + 1]) > 0) {
				smallest = 2 * k + 1;
			}
			if(heap[k].compareTo(heap[smallest]) < 0 || smallest > size) {
				break;
			}
			swap(heap, k, smallest);
			k = smallest;
		}
	}
	
}
