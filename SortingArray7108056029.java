
public class SortingArray7108056029 extends SortingArray {
	
	private static int[] test = {2, 1, 6, 7, 9, 10, 3, 5, 4, 8, 2, -99999, 3, 0};
	
	public static void main(String[] args) {
		SortingArray7108056029 sortingArray7108056029= new SortingArray7108056029();
		sortingArray7108056029.sorting(test);
		for (int i=0; i< test.length; i++) {
			System.out.print(test[i] + ", ");
		}
	}

	public int[] sorting(int[] A)
	{
		quicksort(A, 0, A.length-1);
		return A;
	}

	public void quicksort(int[] a, int lo, int hi)
	{
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
}
