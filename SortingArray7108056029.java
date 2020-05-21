
public class SortingArray7108056029 extends SortingArray {
	
	public static void main(String[] args) {
		int[] test = {2, 1, 6, 7, 9, 1, 1, 1, 10, 3, 5, 4, -99989, 8, 2, -99999, 3, 0};
		SortingArray7108056029 sortingArray7108056029= new SortingArray7108056029();
		sortingArray7108056029.sorting(test);
		// sortingArray7108056029.insertionsort(test, 2, 10);
		for (int i=0; i< test.length; i++) {
			System.out.print(test[i] + ", ");
		}
	}

	public int[] sorting(int[] A)
	{
		int len = A.length;
		if (len < 10) {
			insertionsort(A, 0, len-1);
		} else {
			quicksort(A, 0, len-1);
		}
		return A;
	}

	public void quicksort(int[] a, int lo, int hi)
	{
		// too small do insertion
		if (hi-lo+1 <= 10) {
			insertionsort(a, lo, hi);
			return;
		}

		if (lo >= hi) {
			return;
		}
		int p = partition(a, lo, hi);
		quicksort(a, lo, p-1);
		quicksort(a, p+1, hi);
	}

	public int partition(int[] a, int lo, int hi)
	{
		int i = lo - 1; 
		for(int j = lo; j < hi; j++) { 
			if(a[j] <= a[hi]) { 
				i++; 
				exch(a, i, j); 
			} 
		} 
		exch(a, i+1, hi); 
		return i+1; 
	}

	public void exch(int[] a, int i, int j) 
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void insertionsort(int[] a, int lo, int hi) {
		// int n = hi-lo+1;
		int key, j;
		for (int i = lo+1; i < hi+1; ++i) { 
			key = a[i]; 
			j = i - 1; 

			while (j >= lo && a[j] > key) { 
				a[j + 1] = a[j]; 
				j = j - 1; 
			} 
			a[j + 1] = key; 
		} 
	}
}
