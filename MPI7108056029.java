
public class MPI7108056029 extends MPI{
	public static void main(String[] args) {
		int[] test = {1,2,0,-1,-9,8,3,-5,-7};//4
		// int[] test = {200,100,101,110};//1
		// int[] test = {1,2,3,4,5,6};//7
		// int[] test = {1};//2
		// int[] test = {9};//1
		// int[] test = {-1};//1
		MPI7108056029 mpi = new MPI7108056029();
		int r = mpi.min(test);
		System.out.println(r);
	}

	@Override
	public int min(int[] array) {
		int result;
		int orig_size = array.length;
		int start = splite_postive(array, orig_size);
		int pos_size = orig_size - start;
		boolean[] marked_arr = new boolean[pos_size]; // init all false
		
		for (int i = start; i < orig_size; i++) {
			if (array[i] <= pos_size) {
				marked_arr[array[i]-1] = true;
			}
		}

		result = pos_size+1; // if marked_arr all "true"
		for (int i = 0; i < pos_size; i++) {
			if (!marked_arr[i]) {
				result = i+1;
				break;
			}
		}

		// for (int i = 0; i < pos_size; i++) {
		// 	System.out.print(marked_arr[i] + ", ");
		// }

		return result;
	}

	// return start index of positive number
	public int splite_postive(int[] a, int size) {
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (a[i] <= 0) {
				exch(a, i, j);
				j++;
			}
		}

		return j;
	}

	public void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
