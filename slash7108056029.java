
public class slash7108056029 extends slash{

	private int last;

	public int slash_min(int[] A) 
	{
		// int len = A.length;
		last = A[A.length-1];

		return A.length - 1 - slash(A, 1, A.length-2);
	}

	public int slash(int[] A, int lo, int hi) {
		int mid = (hi + lo) / 2;

		if (A[mid] < A[mid-1]) {
			return mid;
		} else if (A[mid] > A[mid+1]) {
			return mid+1;
		} else {
			if (last < A[mid]) {
				return slash(A, mid+1, hi);
			} else {
				return slash(A, lo, mid-1);
			}
		}
	}
}


