public class PCL7108056029 extends PCL{

	// private int[] gaps;
	public static void main(String[] args) {
		// int[][] arr = {{0, 1}, {1, 2}, {4, 6}};  //false
		// int[][] arr = {{-5, 10}, {0, 10}, {100, 10}};  //true
		// int[][] arr = {{-15, -10}, {-5, 0}, {0, 5}};  //true
		// int[][] arr = {{-10, 10}, {-5, -5}, {5, -35}};  //true
		int[][] arr = {{-10, 10}, {-10, -5}, {-10, -35}};  //true
		// int[][] arr = {{-10, 10}, {-5, -6}, {5, -35}};  // false
		// int[][] arr = {{1, 2}, {3, 0}, {4, 0}, {5, 9}, {3, 7}, {-1, -1}, {-10, 999}};
		// int [] sor_arr = { 69, 81, 30, 38, 9, 2, 47, 61, 32, 79};
		PCL7108056029 pcl = new PCL7108056029();
		System.out.println(pcl.checkPCL(arr));

	}

	

	public boolean checkPCL(int[][] array)
	{
		int n = array.length;
		int r = 2;
		int comb = factorial(n) / (factorial(r) * factorial(n-r));
		double[] slope = new double[comb];
		int slope_i = 0;
		int count = 0;
		double temp;

		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				slope[slope_i++] = (double)(array[j][1] - array[i][1]) / (double)(array[j][0] - array[i][0]);
			}
		}

		mergeSort(slope);

		temp = slope[0];
		for (double d : slope) {
			if (d > temp) {
				count = 0;
			} else {
				count++;
			}

			if (count == 3) {
				return true;
			}
		}

		return false;
	}

	public void mergeSort(double[] a)
	{
		int n = a.length;
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		double[] l = new double[mid];
		double[] r = new double[n - mid];

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

	public void merge(double[] a, double[] l, double[] r, int left_len, int right_len) 
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

	public int factorial(int n) {
		int fact = 1;
		int i = 1;
		while(i <= n) {
		   fact *= i;
		   i++;
		}
		return fact;
	 }


}
