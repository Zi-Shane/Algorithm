
public class SortingArray7108056029 extends SortingArray {
	
	public static void main(String[] args) {
		int[] test = {-10-7, 1,2 ,-9,-81,2,3,4,5,6,7,8,9,10,9,-6,-5, -1, 11,-4,-3, 2, -2,-1,0};

		SortingArray7108056029 sortingArray7108056029= new SortingArray7108056029();
		int[] r = sortingArray7108056029.sorting(test);
		for (int i=0; i< r.length; i++) {
			System.out.print(r[i] + ", ");
		}
	}

	public int[] sorting(int[] A)
	{
		int len = A.length;
		shellsort(A, 0, len-1);
		
		return A;
	}

	public void shellsort(int[] a, int lo, int hi)
	{
		int h = 1;
		int len = (hi-lo)+1;
		while (h < len/3) {
			h = h * 3 + 1;
		}

		while (h > 0)
		{
			for (int i = h; i < len; i++)
			{
				for (int j = i; j >= h && a[j] < a[j-h]; j-=h) {
					exch(a, j, j-h);
				}
			}

			h = h / 3;
		}
		
	}

	public void exch(int[] a, int i, int j) 
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
