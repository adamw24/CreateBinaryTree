import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Desired height of tree (enter a non-negative number): ");
		int height;
		try {
			height = in.nextInt();
		} catch (Exception e) {
			System.out.println();
			System.out.println("Oops, you didn't enter a number");
			Random ran = new Random();
			height = ran.nextInt(10);
			System.out.println("Here's a Demo Tree of height " + height);
		}

		for (int i = 0; i <= 2; i++) {
			System.out.println();
		}
		if (height < 3) {
			System.out.println("Small tree, try a larger number!");
			for (int i = 0; i <= 2; i++) {
				System.out.println();
			}
		}
		printTree(height, height, 1);
		in.close();
	}

	// Prints the tree recursively.
	private static void printTree(int startHeight, int currentHeight, int numSpace) {
		if (currentHeight <= 1) {
			printPadding(numSpace / 2 + 2, '_');
			if (currentHeight == 1) {
				System.out.print("|");
			}
			printPadding(numSpace / 2 + 2, '_');
		} else {
			int numGroups = (int) Math.pow(2, currentHeight - 2);
			printPadding((numSpace) / 2 + 2, ' ');
			for (int i = 0; i < numGroups; i++) {
				System.out.print("|");
				printPadding(numSpace, '_');
				System.out.print("|");
				printPadding(numSpace, ' ');
			}
			System.out.println();
			printTree(startHeight, currentHeight - 1, numSpace * 2 + 1);
		}
	}

	// Prints the input character a given number of times.
	private static void printPadding(int num, char s) {
		for (int i = 0; i < num; i++) {
			System.out.print(s);
		}
	}
}
