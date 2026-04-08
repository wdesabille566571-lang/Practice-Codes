package group5;

import java.util.Scanner;

public class Group5_gradeSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double grades[][] = new double[3][3];

		System.out.println("========== INPUT GRADES ===========");

		for (int x = 0; x < grades.length; x++) {
			System.out.println("Enter grades of student " + (x + 1) + ":");

			System.out.print("Math: ");
			grades[x][0] = sc.nextDouble();

			System.out.print("Science: ");
			grades[x][1] = sc.nextDouble();

			System.out.print("English: ");
			grades[x][2] = sc.nextDouble();

			if ((x + 1) < grades.length) {
				System.out.println();
			}
		}
		System.out.println("===================================\n");

		System.out.println("============== GRADES REPORT ==============");
		System.out.printf("%-12S%-12S%-12S%-12S%n", "STUDENT", "MATH", "SCIENCE", "ENGLISH");

		for (int x = 0; x < grades.length; x++) {
			String str = "Student " + (x + 1);
			System.out.printf("%-12s", str);

			for (int y = 0; y < grades[x].length; y++) {
				System.out.printf("%-12.2f", grades[x][y]);
			}
			System.out.println();
		}
		System.out.println("===========================================");

		double avg;
		double sum;

		System.out.println("\n==== AVERAGE PER STUDENT (ROW) ====");
		for (int x = 0; x < grades.length; x++) {
			avg = 0;
			sum = 0;

			for (int y = 0; y < grades[x].length; y++) {
				sum += grades[x][y];
				avg = sum / grades[x].length;
			}

			String strAvg = String.format("%.2f", avg);
			System.out.println("Student " + (x + 1) + " Average: " + strAvg);
		}
		System.out.println("===================================");

		System.out.println("\n=== AVERAGE PER SUBJECT(COLUMN) ===");
		for (int x = 0; x < grades.length; x++) {
			avg = 0;
			sum = 0;

			for (int y = 0; y < grades[x].length; y++) {
				sum += grades[y][x];
				avg = sum / grades.length;
			}

			String strAvg = String.format("%.2f", avg);

			if (x == 0) {
				System.out.println("Math\t Average: " + strAvg);
			} else if (x == 1) {
				System.out.println("Science\t Average: " + strAvg);
			} else if (x == 2) {
				System.out.println("English\t Average: " + strAvg);
			}
		}
		System.out.println("===================================");
		
		sc.close();
	}

}
