import java.util.Scanner;

class Generalized {
	public static void main(String args[]) {
		int n; // number of courses

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of courses: ");
		n = scanner.nextInt();

		int numBatches = 4; // number of batches for each courses
		int numStudents = 70;
		int batchSize, remainingStudents, numGroupsOfFour;
		int [] coursesGroupOfFourOnly = new int[4*n];
		int [] batchesGroupOfFourOnly = new int[4*n];
		int count = 0;

		int [][][] studentMentors  = new int[n][numBatches][numStudents];

		for(int i = 0; i < n; i++) { // for ith course
			System.out.println("Course " + i + ":" );
			for(int j = 0; j < numBatches; j++) { // for jth batch of ith course
				System.out.print("Enter number of slow learnings for batch " + j + ": ");
				batchSize = scanner.nextInt();

				numGroupsOfFour = batchSize/4;
				remainingStudents = batchSize - numGroupsOfFour * 4;
				// System.out.println("rem: " + remainingStudents);

				int k;
				for(k = 0; k < numGroupsOfFour; k++) // for kth group of four students
					studentMentors[i][j][k] = 4;

				if(remainingStudents != 0)
					studentMentors[i][j][k] = remainingStudents;
				else {
					coursesGroupOfFourOnly[count] = i;
					batchesGroupOfFourOnly[count++] = j;
				}
			}
		}

		int iterator = 0;
		if(batchesGroupOfFourOnly.length != 0) {
			System.out.println("Batches with all groups of exactly 4:");
			for(int course: coursesGroupOfFourOnly) {
				if(iterator == count)
					break;
				System.out.print("Course " + course + ": ");
				System.out.println("Batch " + batchesGroupOfFourOnly[iterator++]);
			}
		}
	}
}
