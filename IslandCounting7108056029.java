
public class IslandCounting7108056029 extends IslandCounting 
{

	private int c = 0;
	private boolean[] marked_A, marked_B;
	public static void main(String[] args) 
	{
		// String[] A = {"A", "B", "B", "C", "B", "D", "F", "G"};
		String[] A = {"A", "B", "E", "C", "E", "B", "D", "F", "G", "L", "E"};
		// String[] B = {"E", "E", "C", "D", "D", "E", "H", "H"};
		String[] B = {"E", "C", "C", "D", "A", "D", "E", "H", "H", "O", "O"};
		IslandCounting7108056029 islandCounting7108056029 = new IslandCounting7108056029();
		int r = islandCounting7108056029.count(A, B);
		System.out.println(r);
	}

	@Override
	public int count(String[] A, String[] B) 
	{
		int len = A.length;
		marked_A = new boolean[len];
		marked_B = new boolean[len];

		for (int i = 0; i < len; i++) {
			if (!marked_A[i]) {
				find(A, B, B[i], i);
				c++;
			}
		}

		return c;
	}

	public void find(String[] A, String[] B, String node, int start_i) 
	{
		for (int i = start_i+1; i < A.length; i++) {
			if (A[i] == node && !marked_A[i]) {
				marked_A[i] = true;
				marked_B[i] = true;
				find(A, B, B[i], start_i);
			}
			if (B[i] == node && !marked_B[i]) {
				marked_A[i] = true;
				marked_B[i] = true;
				find(A, B, A[i], start_i);
			}
		}
	}
}
