import javax.tools.ForwardingJavaFileObject;

public class IslandCounting7108056029 extends IslandCounting 
{
	private String[] node_map;
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
		int map_len = 0;
		boolean find = false;
		node_map = new String[len*2];

		for (int i = 0; i < len; i++) 
		{
			for (int j = 0; j < map_len; j++) {
				if (A[i] == node_map[j]) {
					// old point
					A_int[i] = j;
					find = true;
				}
			}
			if (!find) {
				// add new point
				A_int[i] = map_len;
				node_map[map_len++] = A[i];
			}
			find = false;

			for (int j = 0; j < map_len; j++) {
				if (B[i] == node_map[j]) {
					B_int[i] = j;
					find = true;
				}
			}
			if (!find) {
				B_int[i] = map_len;
				node_map[map_len++] = B[i];
			}
			find = false;
		}

		nodes = new int[map_len];
		// init
		for (int i = 0; i < map_len; i++) {
			nodes[i] = i;
		}
		// do union
		for (int i = 0; i < len; i++) {
			union(A_int[i], B_int[i]);
		}
		
		return map_len - c;
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
