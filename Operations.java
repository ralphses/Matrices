package Matrices;

import java.util.*;
public class Operations {
	private static Scanner in = new Scanner (System.in);
	protected static int ro;
	private static int co;
	private static char deci;
	private static int [][]arr = {};
	
	
	private static int[][] addMatrix(int[][]arr, int[][]sum, int ro, int co) {
		for (int x = 0; x < ro; x++) {
			for (int y = 0; y < co; y++) {
				sum[x][y] = sum[x][y] + arr[x][y];
			}
		}
		return sum;
	}

	private int[][] multiply(int[][] first, int ro1, int co1, int[][] second, int ro2, int co2) {
		int[][]multiply = new int[ro1][co2];
		if (co1 != ro2) {
			System.out.println("These matrices cannot be multiplied!\nColumn of matrix 1 not equal to row \nof matrix 2");
			}
		else {
			for (int c = 0; c < ro1; c++) {
				for (int d = 0; d < co2; d++) {
					multiply[c][d] = 0;
					for (int k = 0; k < co1; k++) {
						multiply[c][d] = multiply[c][d] + first[c][k] * second[k][d];
					}
				}
			}
		
	}
		return multiply;
	}

	
	private static int[][] subtractMatrix(int[][]arr, int[][]sum, int ro, int co) {
		for (int x = 0; x < ro; x++) {
			for (int y = 0; y < co; y++) {
				sum[x][y] = sum[x][y] - arr[x][y];
			}
		}
		return sum;
	}
	
	private static void printMatrix(int[][]arr, int ro, int co) {
		System.out.println("\nThe Resulting Matrix is");
		//System.out.println("a\tb"); (Am not really sure what i want to do here
		for (int x = 0; x < ro; x++) {
			if (x > 0) {
				System.out.println();
			}
			for (int y = 0; y < co; y++) {
				System.out.print(arr[x][y] + "\t");
			}
		}
		System.out.println();

}
	
	private static int[][] collectMatrix(int ro, int co){
		int[][]arr = new int [ro][co];
		for(int x = 0; x < ro; x++) {
			for (int y = 0; y < co; y++) {
				System.out.println("Enter a" + (x+1) + (y+1));
				arr[x][y] = in.nextInt();
			}
		}
		return arr;
	}
	
	public void matAdd() {

		System.out.println("How many matrix do you want to add");
		int num = in.nextInt();
		System.out.println("Enter Dimension (row by coloumn)");
		int ro = in.nextInt();
		int co = in.nextInt();
		int [][] sum = new int[ro][co];
		
		for (int a = 1; a <= num; a++) {					
			System.out.println("Enter Matrix " + a);
			arr = collectMatrix(ro, co);
			sum = addMatrix(sum, arr, ro, co);	
			}
		printMatrix(sum, ro, co);
		}

	
public void matSub() {

	System.out.println("How many matrix do you want to subtract");
	int num = in.nextInt();
	System.out.println("Enter Dimension (row by coloumn)");
	int ro = in.nextInt();
	int co = in.nextInt();
	int [][] firstMatrix = new int[ro][co];
	System.out.println("Enter first matrix");
	firstMatrix = collectMatrix(ro, co);
	for (int a = 1; a < num; a++) {	
		System.out.println("Enter next matrix");
		arr = collectMatrix(ro, co);
		firstMatrix = subtractMatrix(arr, firstMatrix, ro, co);
				
		}
	printMatrix(firstMatrix, ro, co);
	}


public void matAddSub() {
	System.out.println("How many matrix do you want to add or subtract");
	int num = in.nextInt();
	System.out.println("Enter Dimension (row by coloumn)");
	int ro = in.nextInt();
	int co = in.nextInt();
	int [][] result = new int[ro][co];
	
	for (int a = 1; a <= num; a++) {					
		System.out.println("Enter Matrix " + a);
		arr = collectMatrix(ro, co);
		if (a < num) {
			System.out.println("+ or -"); 
			deci = in.next().charAt(0);
			}
		if (deci == '-') 
		{
			result = subtractMatrix(result, arr, ro, co);
		}
		else if (deci == '+')
		{
			result = addMatrix(result, arr, ro, co);
		}
		else 
		{
			System.out.println("Invalid operator entered\nTry again");
			break;
			}
		
		}
	printMatrix(result, ro, co);
	}

public void scalarMultiply() {
	
	System.out.println("Enter the scaler");
	int scalar = in.nextInt();
	System.out.println("Enter matrix dimension (row by column)");
	
	ro = in.nextInt();
	co = in.nextInt();
	
	int [][] result = new int[ro][co];
	int [][] arr = new int[ro][co];
	
	for (int x = 0; x < ro; x++) {
		for (int y = 0; y < co; y++) {
			System.out.println("Enter a" + (x+1) + (y+1));
			arr[x][y] = in.nextInt();
			result[x][y] = scalar * arr[x][y];
		}
	}
	printMatrix(result, ro, co);
}


public void matTranspose() {
	System.out.println("Enter matrix dimension (row by column)");
	ro = in.nextInt();
	co = in.nextInt();
	System.out.println("Enter the matrix");
	
	int [][] result = new int[ro][co];
	int [][] arr = new int[co][ro];
	
	for (int x = 0; x < ro; x++) {
		for (int y = 0; y < co; y++) {
			System.out.println("Enter a" + (x+1) + (y+1));
			result[x][y] = in.nextInt();
			arr[y][x] = result[x][y];
		}
	}
	if (ro == co) {
	printMatrix(arr, ro, co);
	}
	else {
		printMatrix(arr, co, ro);
		}
	}


public int[][] cofactor() {
	int[][]arr = new int [ro][co];
	
	return arr;
	
	}

public void twoMatMultiply() {
	
	int[][]first;
	int ro1;
	int co1; 
	int[][]second; 
	int ro2;
	int co2;
	
	// Particulars for the first first matrix
	System.out.println("Enter row and column of first matrix");
	ro1 = in.nextInt();
	co1 = in.nextInt();
	
	first = new int[ro1][co1];
	
	// Particulars for the first second matrix
	System.out.println("Enter row and column of second matrix");
	ro2 = in.nextInt();
	co2 = in.nextInt();
	
	// Tests whether the two matrices can be multiplied
	if (co1 != ro2) 
	{
		System.out.println("These matrices cannot be multiplied!\r\n" + 
				"Column of matrix 1 not equal to row \r\n" + 
				"of matrix 2");
	}
	else 
	{
	// Create new matrix (first)
	second = new int[ro2][co2];
	System.out.println("Enter elements of Matrix 1");
	first = collectMatrix(ro1, co1);
	// Create new matrix (Second)
	System.out.println("Enter elements of Matrix 2");
	second = collectMatrix(ro2, co2);
	
	// Third matrix where to store the answer
	int[][]multiply = new int[ro1][co2];
	
	// Calling the multiply method to multiply the two matrices
	multiply = multiply(first, ro1, co1, second, ro2, co2);
	
	if (co1 == ro2) {
		printMatrix(multiply, ro1, co2);
			}
		}
	}


public void multiMatMultiply() {
	System.out.println("How many matrices do you want to multiply?");
	int num = in.nextInt();
	
	int[][]first;
	int ro1;
	int co1; 
	int[][]second; 
	int ro2;
	int co2;
	int roT = 0;
	int coT = 0;
	
	System.out.println("Enter row and column of first matrix");
	ro1 = in.nextInt();
	co1 = in.nextInt();
	first = new int[ro1][co1];
	
	System.out.println("Enter row and column of second matrix");
	ro2 = in.nextInt();
	co2 = in.nextInt();
	second = new int[ro2][co2];
	
	first = collectMatrix(ro1, co1);
	second = collectMatrix(ro2, co2);
	
	int[][]multiply = new int[ro1][co2];
	
	multiply = multiply(first, ro1, co1, second, ro2, co2);
	printMatrix(multiply, ro1, co2);
	
	System.out.println("\n");
	
	int[][]temp = new int[roT][coT];
	for (int n = 0; n < num - 2; n++) {
		System.out.println("Enter the dimension of the next matrix (row by column)");
		roT = in.nextInt();
		coT = in.nextInt();
		temp = new int[roT][coT];
		temp = collectMatrix(roT, coT);
		temp = multiply(temp, roT, coT, multiply, ro1, co1);
		printMatrix(temp, roT, coT);
		
		}
	}


}