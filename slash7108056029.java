
public class slash7108056029 extends slash{

	public static void main(String[] args) {
		int[] array = {5,6,7,1,2,3,4};//3
		slash7108056029 slash_test = new slash7108056029();
		int r = slash_test.slash_min(array);

		System.out.println(r);
	}

	public int slash_min(int[] A) 
	{
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] > A[i+1]) {
				return A.length - i - 2; //A.length - 1 - (p + 1);
			}
		}
		return -1;
	}
}


