
public class ThreeSum7108056029 extends ThreeSum 
{
	public static void main(String[] args) 
	{
		// int[] a = { 5, 1, -5, 2, 9, 0, 4, -4, 3, 6, -1, -2, -7, -9, -3, -6 }; //7
		int[] a = { -1, -2, 3, 2, 0}; //2 {-2 -1 0 2 3}
		// int[] a = { -1, 0, 1, 2, -4 };
		ThreeSum7108056029 test = new ThreeSum7108056029();
		System.out.println(test.T_sum(a));
	}
	
	@Override
	public int T_sum(int[] A) 
	{
		// mergeSort(A);
		quickSort(A);
		int N = A.length;
		int cnt = 0;
		int j, k, j_plus_k;

		for (int i = 0; i < N-2; i++) 
		{
			j = i + 1;
			k = N - 1;
			while (j < k) 
			{
				j_plus_k = A[j]+A[k];
				if ( j_plus_k == -A[i]) {
					cnt++;
					j++;
				} else if ( j_plus_k > -A[i]) {
					k--;
				} else {
					j++;
				}
			}
		}
		return cnt;
	}

	public static void mergeSort(int[] a)
	{
		int n = a.length;
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i-mid] = a[i];
		}

		mergeSort(l);
		mergeSort(r);

		merge(a, l, r, mid, n-mid);
	}

	public static void merge(int[] a, int[] l, int[] r, int left_len, int right_len) 
	{
		int i = 0, index_l = 0, index_r = 0;
		while (index_l < left_len && index_r < right_len) 
		{
			if (l[index_l] <= r[index_r]) {
				a[i++] = l[index_l++];
			} else {
				a[i++] = r[index_r++];
			}
		}
		while (index_l < left_len) {
			a[i++] = l[index_l++];
		}
		while (index_r < right_len) {
			a[i++] = r[index_r++];
		}
	}

	public static void quickSort(int[] a) {
		quick(a, 0, a.length - 1);
	}

	public static void quick(int[] a, int left_index, int right_index) {
		if (left_index >= right_index) {
			return;
		}

		int i = left_index;
		int j = right_index;
		int key = a[right_index]; // right_index as pivot
		while (i < j) 
		{
			if (a[i] < key) {
				i++;
			} else if (a[j] >= key) {
				j--;
			} else {  // if (a[i] >= key && a[j] < key)
				int t = a[j];
				a[i] = a[j];
				a[j] = t;
			}
		}
		// swap pivot and i
		a[right_index] = a[i];
		a[i] = key;

		quick(a, left_index, i - 1);
		quick(a, i + 1, right_index);
	}
}
