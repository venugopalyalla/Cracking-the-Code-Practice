
public class SetRowOrColTo0 {

	static void setZeroesInMat(int[][] a) {
		int[] rows = new int[a.length];
		int[] cols = new int[a[0].length];
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < cols.length; j++) {
				if (a[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (rows[i] == 1 || cols[j] == 1) {
					a[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] m = new int[4][4];
		m[0][0] = 1;
		m[0][1] = 2;
		m[0][2] = 0;
		m[0][3] = 4;
		m[1][0] = 5;
		m[1][1] = 6;
		m[1][2] = 7;
		m[1][3] = 8;
		m[2][0] = 9;
		m[2][1] = 0;
		m[2][2] = 11;
		m[2][3] = 12;
		m[3][0] = 13;
		m[3][1] = 14;
		m[3][2] = 15;
		m[3][3] = 16;
		setZeroesInMat(m);
	}
}
