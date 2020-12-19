import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numRows = 7;
		for(int i = 0; i <=2; i++) {
			System.out.println();
		}
		if(numRows <3) {
			System.out.println("Small Tree!");
			for(int i = 0; i <=2; i++) {
				System.out.println();
			}
		}
		printTree(numRows, numRows,1);
	}
	private static void printTree(int startRow, int currentRow, int numSpace) {
		if (currentRow <= 1) {
			int max;
			if(startRow <= 5) {
				max = 4;
			}else {
				max = 4*(startRow-1) + 1;
			}
			printPadding(numSpace/2 +2 , "_");
			if(currentRow ==1) {
				System.out.print("|");
			}
			printPadding(numSpace/2 + 2, "_");
		}else {
			int numGroups = (int) Math.pow(2, currentRow-2);
			printPadding((numSpace)/2+2, " ");
			for(int i = 0; i<numGroups; i++) {
				System.out.print("|");
				printPadding(numSpace, "_");
				System.out.print("|");
				printPadding(numSpace, " ");
			}
			System.out.println();
			printTree(startRow, currentRow-1, numSpace*2 +1);
		}
	}
	
	private static void printPadding(int num, String s) {
		for(int i = 0; i<num; i++) {
			System.out.print(s);
		}
	}
	

}
