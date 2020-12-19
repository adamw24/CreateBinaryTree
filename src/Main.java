import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		printTree(6,6,1);
	}
	private static void printTree(int startRow, int currentRow, int numSpace) {
		if (currentRow <= 1) {
			int max;
			if(startRow <= 5) {
				max = 4;
				for (int i = 0; i<6; i++) {
					System.out.println();
				}
			}else {
				max = 4*(startRow-1) + 1;
			}
			printFloor(max/2);
			if(currentRow ==1) {
				System.out.print("|");
			}
			printFloor(max/2);
		}else {
			int numGroups = (int) Math.pow(2, currentRow-2);
			for(int i = 0; i<numGroups; i++) {
				System.out.print("|");
				printFloor(numSpace);
				System.out.print("|");
			}
			System.out.println();
			printTree(startRow, currentRow-1, numSpace*2 +1);
		}
	}
	
	private static void printFloor(int num) {
		for(int i = 0; i<num; i++) {
			System.out.print("_");
		}
	}

}
