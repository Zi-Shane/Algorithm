public class PCL7108056029 extends PCL{

	private boolean duplicate = false;
	public static void main(String[] args) {
		// int[][] arr = {{0, 1}, {1, 2}, {4, 6}};  //false
		// int[][] arr = {{-5, 10}, {0, 10}, {100, 10}};  //true 
		// int[][] arr = {{-15, -10}, {-5, 0}, {0, 5}};  //true
		// int[][] arr = {{-10, 10}, {-5, -5}, {5, -35}};  //true
		// int[][] arr = {{-10, 10}, {-10, -5}, {-11, -35}, {-10, -36}};  //true
		// int[][] arr = {{-10, 10}, {-5, -6}, {5, -35}};  // false
		int[][] arr = {{1, 2}, {3, 0}, {4, 0}, {5, 9}, {3, 7}, {-1, -1}, {-10, 999}};
		// int [] sor_arr = { 69, 81, 30, 38, 9, 2, 47, 61, 32, 79};
		PCL7108056029 pcl = new PCL7108056029();
		System.out.println(pcl.checkPCL(arr));
	}

	

	public boolean checkPCL(int[][] array)
	{
		// int comb = factorial(n) / (factorial(r) * factorial(n-r));
		int vertical;

		for (int i = 0; i < array.length; i++) {
			vertical = 0;
			Node root = null;
			for (int j = i+1; j < array.length; j++) {
				if (array[i][0] == array[j][0]) {
					vertical++;
					if (vertical == 2) {
						return true;
					}
				} else {
					root = insert(root, (double)(array[i][1] -array[j][1]) / (double)(array[i][0] -array[j][0])); 
					if (duplicate) {
						return true;
					}
				}
			}
		}

		return false;
	}

	// Node declaration  
	class Node  
	{  
		double data;  
		public Node left;  
		public Node right; 
		Node(double data) 
		{ 
			this.data = data; 
			left = right = null; 
		} 
	} 
	
	// Function to insert data in BST  
	public Node insert(Node root, double data) 
	{  
		if (root == null) 
			return new Node(data); 
		if (data == root.data)  
			duplicate = true; 
		if (data < root.data)  
			root.left = insert(root.left, data);  
		if (data > root.data) 
			root.right = insert(root.right, data);  
		return root;  
	}  

	// InOrder function to display value of array  
	// in sorted order  
	public static void inOrder(Node root) 
	{  
		if (root == null)  
			return;  
		inOrder(root.left);  
		System.out.print(root.data+" "); 
		inOrder(root.right);  
	} 

	public void mergeSort(double[] a)
	{
		int n = a.length;
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		double[] l = new double[mid];
		double[] r = new double[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i-mid] = a[i];
		}

		mergeSort(l);
		mergeSort(r);

		merge(a, l, r, mid, n-mid);
	}

	public void merge(double[] a, double[] l, double[] r, int left_len, int right_len) 
	{
		int i = 0, index_l = 0, index_r = 0;
		while (index_l < left_len && index_r < right_len) 
		{
			if (l[index_l] <= r[index_r]) {
				a[i++] = l[index_l++];
			} else {
				a[i++] = r[index_r++];
			}
		}
		while (index_l < left_len) {
			a[i++] = l[index_l++];
		}
		while (index_r < right_len) {
			a[i++] = r[index_r++];
		}
	}

	public int factorial(int n) {
		int fact = 1;
		int i = 1;
		while(i <= n) {
		   fact *= i;
		   i++;
		}
		return fact;
	}
	public boolean collinear(int x1, int y1, int x2,  
	int y2, int x3, int y3) 
	{ 
		int a = x1 * (y2 - y3) +  
		x2 * (y3 - y1) +  
		x3 * (y1 - y2); 

		if (a == 0) 
			return true; 
		else
			return false;
	}  

}
