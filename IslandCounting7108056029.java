
public class IslandCounting7108056029 extends IslandCounting 
{
	private int[] A_int;
	private int[] B_int;
	private int[] nodes;
	private int c = 0;
	public static void main(String[] args) 
	{
		String[] A = {"A", "B", "B", "C", "B", "D", "F", "G"};
		String[] B = {"E", "E", "C", "D", "D", "E", "H", "H"};
		IslandCounting7108056029 islandCounting7108056029 = new IslandCounting7108056029();
		int r = islandCounting7108056029.count(A, B);
		System.out.println(r);
	}

	@Override
	public int count(String[] A, String[] B) 
	{
		int len = A.length;
		A_int = new int[len];
		B_int = new int[len];
		int index_count = 1;

		for (int i = 0; i < len; i++) 
		{
			if (A_int[i] == 0) {
				for (int j = 0; j < len; j++) 
				{
					if (A[j] == A[i]) {
						A_int[j] = index_count;
					}
					if (B[j] == A[i]) {
						B_int[j] = index_count;
					}
				}
				index_count++;
			}
			if (B_int[i] == 0) {
				for (int j = 0; j < len; j++) 
				{
					if (A[j] == B[i]) {
						A_int[j] = index_count;
					}
					if (B[j] == B[i]) {
						B_int[j] = index_count;
					}
				}
				index_count++;
			}
		}

		nodes = new int[index_count];
		for (int i = 1; i < index_count; i++) {
			nodes[i] = i;
		}

		// do union
		for (int i = 0; i < len; i++) {
			union(A_int[i], B_int[i]);
		}

		for (int i = 1; i < index_count; i++) {
			System.out.println(i+ ":"+ nodes[i]);
			
		}

		return (index_count - 1) - c;
	}

	public int find(int i) {
		while (i != nodes[i]) {
			i = nodes[i];
		}
		return i;
	}
	
	public void union(int p, int q) {
		int proot = find(p);
		int qroot = find(q);
		nodes[proot] = qroot;
		if (proot != qroot) {
			c = c + 1;
		}
	}
}
