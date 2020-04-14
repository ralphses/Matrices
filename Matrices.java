package Matrices;

import java.util.Scanner;

public class Matrices {
static Scanner input = new Scanner(System.in);
static int subOption;

	public static void main(String[] args) {
		boolean count2 = true;
		boolean count = true;
		
		Operations operation = new Operations();
			System.out.println("\t***MATRICES MADE EASY***");
			System.out.println("Select any of the following");
			
			do {
				
			System.out.print("\n"
					+ "1 - Addition\n"
					+ "2 - Addition and subtraction\n3 - Subtraction\n4 - Multiplication\n5 - Find inverse\n"
					+ "6 - Determinant\n7 - Cofactor\n8 - Transpose\n9 - Scalar Multiplication\n");
			
			int option = input.nextInt();
			
			switch (option) {
			case 1:
				operation.matAdd();
				break;
			case 2:
				operation.matAddSub();
				break;
			case 3:
				operation.matSub();
				break;
			case 4:
				operation.twoMatMultiply();
				break;
			case 8:
				operation.matTranspose();
				break;
			case 9:
				operation.scalarMultiply();
				break;
			default:
				if (option == 5 || option == 6 || option == 7) {
					System.out.println("Not Yet Available\nCheck back later");
				}
				else {
					System.out.println("Invalid Option Selceted");
				}	
				
			}
			System.out.println();
			System.out.println("1 - Perform another operation\n2 - Exit");
			int deci = input.nextInt();
			
			if (deci == 1) {
				// Just continue the while loop...hahaha
			}
			
			else if (deci == 2) {
				System.out.println("Goodbye for now!");
				count = false;
			}
			else {
				System.out.println("Invalid Option");
			}
	
		}
		while (count);			


	}
	}


