import java.util.Arrays;

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
		Arrays.sort(A);
		int N = A.length;
		int cnt = 0;
		int j, k, j_plus_k;

		for (int i = 0; i < N-2; i++) {
			j = i + 1;
			k = N - 1;

			while (j < k) {
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

	public static void sort() {
		
	}

}
