import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ThreeSum7108056029 extends ThreeSum 
{
	public static void main(String[] args) 
	{
		// int[] a = { 5, 1, -5, 2, 9, 0, 4, -4, 3, 6, -1, -2, -7, -9, -3, -6 }; //7
		int[] a = { -1, -2, 3, 2, 0}; //2 {-2 -1 0 2 3}
		ThreeSum7108056029 test = new ThreeSum7108056029();
		System.out.println(test.T_sum(a));
	}
	
	@Override
	public int T_sum(int[] A) 
	{
		HashMap<Integer, ArrayList<Integer>> index = new HashMap<Integer, ArrayList<Integer>>();
		Arrays.sort(A);
		int N = A.length;
		int cnt = 0;

		for (int i = 0; i < A.length; i++) 
		{
			int num = A[i];
			if (index.get(num) == null)
			{
				index.put(num, new ArrayList<Integer>());
				index.get(num).add(i);
			}
		}
		
		int negative_First2_Sum;
		for (int i = 0; i < N; i++)
		{
			for (int j = i+1; j < N; j++)
			{
				negative_First2_Sum = -A[i]-A[j];
				if (index.get(negative_First2_Sum) != null && negative_First2_Sum > i)
				{
					cnt += index.get(negative_First2_Sum).size();
				}
			}
		}
		return cnt;

	}

}
