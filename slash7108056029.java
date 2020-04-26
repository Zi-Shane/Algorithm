
public class slash7108056029 extends slash{

	public static void main(String[] args) {
		// int[] array = {6,7,1,2,3,4,5};//4
		// int[] array = {5,6,7,1,2,3,4};//3
		//             0 1 2 3 4  5  6  7  8  9
		// int[] array = {6,7,8,9,10,11,12,13,14,1};//0
		//             0  1 2 3 4 5 6 7 8 9  10 11 12 13
		int[] array = {15,2,3,4,5,6,7,8,9,10,11,12,13,14};//12
		slash7108056029 slash_test = new slash7108056029();
		int r = slash_test.slash_min(array);

		System.out.println(r);
	}

	public int slash_min(int[] A) 
	{
		int len = A.length;

		return len - 1 - slash(A, 1, len-2, A[len-1]);
	}

	public int slash(int[] A, int lo, int hi, int last) {
		int mid = (hi + lo) / 2;

		if (A[mid] < A[mid+1] && A[mid] < A[mid-1]) {
			return mid;
		} else if (A[mid] > A[mid+1]) {
			return mid+1;
		} else {
			if (last < A[mid]) {
				return slash(A, mid+1, hi, last);
			} else {
				return slash(A, lo, mid-1, last);
			}
		}
	}
}


