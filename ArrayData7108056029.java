
public class ArrayData7108056029 extends ArrayData{

	public ArrayData7108056029(int[] A) {
		this.A = A;
	}

	public static void main(String[] args) {
		int[] A = { -4, -9, 9, 10, 2, 3};
		ArrayData7108056029 test = new ArrayData7108056029(A);

		long startTime = System.nanoTime();
		System.out.println(test.max());
		System.out.println(test.min());
		long stopTime = System.nanoTime();
		double elapsedTimeInSecond = (double) (stopTime - startTime) / 1_000_000_000;
		
        System.out.println(elapsedTimeInSecond + " seconds");
	}

	@Override
	public int max() {
		// TODO Auto-generated method stub
		// int r = A[0];
		// for (int i : A) {
		// 	r = (i > r) ? i : r;
		// }
		int r = Integer.MIN_VALUE;
        for (int i : A) {
            r = Math.max(r, i);
        }
		return r;
	}

	@Override
	public int min() {
		// TODO Auto-generated method stub
		int r = Integer.MAX_VALUE;
		for (int i : A) {
			r = Math.min(r, i);
		}
		return r;
	}

}
