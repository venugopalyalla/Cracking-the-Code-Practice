
public class RotateMatrix90Deg {

	static void rotateClockWise90Degress(int[][] a, int n) {
		for(int i=0; i<n/2; i++) {
			int start = i;
			int end = n-1-i;
			for(int j=start; j<end;j++) {
				int diff = j-start;
				int top = a[start][j];
				a[start][j] = a[end-diff][start];
				a[end-diff][start] = a[end][end-diff];
				a[end][end-diff] = a[j][end];
				a[j][end] = top;
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void rotateAntiClockWise90Degress(int[][] a, int n) {
		for(int i=0; i<n/2; i++) {
			int start = i;
			int end = n-1-i;
			for(int j=start; j<end;j++) {
				int diff = j-start;
				int top = a[start][j];
				a[start][j] = a[j][end];
				a[j][end] = a[end][end-diff];
				a[end][end-diff] = a[end-diff][start];
				a[end-diff][start] = top;
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] m = new int[4][4];
		m[0][0] = 1;
		m[0][1] = 2;
		m[0][2] = 3;
		m[0][3] = 4;
		m[1][0] = 5;
		m[1][1] = 6;
		m[1][2] = 7;
		m[1][3] = 8;
		m[2][0] = 9;
		m[2][1] = 10;
		m[2][2] = 11;
		m[2][3] = 12;
		m[3][0] = 13;
		m[3][1] = 14;
		m[3][2] = 15;
		m[3][3] = 16;
		rotateAntiClockWise90Degress(m,4);
	}
}
