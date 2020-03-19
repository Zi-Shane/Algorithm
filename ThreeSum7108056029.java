import java.util.Arrays;

public class ThreeSum7108056029 extends ThreeSum 
{
	public static void main(String[] args) 
	{
		// int[] a = { 5, 1, -5, 2, 9, 0, 4, -4, 3, 6, -1, -2, -7, -9, -3, -6 }; //7
		int[] a = { -1, -2, 3, 2, 0 }; //2
		ThreeSum7108056029 test = new ThreeSum7108056029();
		System.out.println(test.T_sum(a));
	}
	
	@Override
	public int T_sum(int[] A) 
	{
		Arrays.sort(A);
		int N = A.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) 
			for (int j = i+1; j < N; j++)
				if (rank(A, -A[i]-A[j]) > j) 
					cnt++;
		return cnt;
	}

	public static int rank(int[] a, int key) 
	{
		int lo = 0, hi = a.length-1;
		while (lo <= hi) 
		{
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) 
				hi = mid - 1;
			else if (key > a[mid]) 
				lo = mid + 1;
			else return mid;
		}
		return -1;
	}
}
