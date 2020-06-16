
public class MPI7108056029 extends MPI{
	public static void main(String[] args) {
		int[] test = {1,2,0,-1,-9,8,3};//4
		// int[] test = {200,100,101,110};//1
		// int[] test = {1,2,3,4,5,6};//7
		// int[] test = {1};//2
		// int[] test = {9};//1
		// int[] test = {-1};//1
		MPI7108056029 mpi = new MPI7108056029();
		int r = mpi.min(test);
		System.out.println(r);
	}

	private int count = 1;

	@Override
	public int min(int[] array) {
		int N = array.length;
		int min_int = 1;
		int[] unsign_int = new int[N+1];
		for (int item : array) {
			if (item > 0) {
				unsign_int[count++] = item;
			}
		}
		count--;

		for (int k = count/2; k >= 1; k--) {
			sink(unsign_int, k, count);
		}

		while (count > 0) {
			if (delMin(unsign_int) == min_int) {
				min_int++;
			}
		}

		// for (int i = 0; i <= count; i++) {
		// 	System.out.print(unsign_int[i] + ", ");
		// }

		return min_int;
	}

	public void sink(int[] a, int k, int N) {
		while (2*k <= N)
		{
			int j = 2*k;
			if (j < N && a[j+1] < a[j]) {
				j++;
			}
			if (a[k] < a[j]) {
				break;
			}
			exch(a, k, j);
			k = j;
		}
	}

	public int delMin(int[] a) {
		int min = a[1];
		exch(a, 1, count);
		count--;
		sink(a, 1, count);

		return min;
	}

	public void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
