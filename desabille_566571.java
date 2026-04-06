package desabille;

import java.util.Scanner;

public class desabille_566571 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		int arr[][] = new int[3][3];
//		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println("Numbers of row " + (i + 1) + ": ");	
//			
//			for (int x = 0; x < arr[i].length; x++) {
//				System.out.print("Enter number of column " + (x + 1) + ": ");
//				arr[i][x] = sc.nextInt();
//			}
//			
//			System.out.println();
//		}
//		
//		System.out.println();
//		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println("Numbers of row " + (i + 1) + ": ");	
//			System.out.print("Column: ");
//			
//			for (int x = 0; x < arr[i].length; x++) {
//				System.out.print(arr[i][x]);
//				
//				if ((x + 1) < arr[i].length) {
//					System.out.print(", ");
//				}
//			}
//			
//			System.out.println();
//		}
//		
//		
//		
//		for (int[] num : arr) {
//			for (int nums : num) {
//				System.out.print(nums + " ");
//			}
//			
//			System.out.println();
//		}
		
		int arr[][] = {{120,250,789,7},{58,79,31,87},{8,1,2,3},{99,98,97,96}};
		
		for (int i = 0; i < arr.length; i++) {	
			
			for (int x = 0; x < arr[i].length; x++) {
				System.out.printf("%5d", arr[i][x]);
			}
		
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {	
			for (int x = 0; x < arr[i].length; x++) {
				if (arr[i][x] == 1) {
					System.out.println("Number 1 is found at indices " + i + " and " + x);
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {	
			for (int x = 0; x < arr[i].length; x++) {
				if (arr[i][x] == 1) {
					arr[i][x] = 50;
				}
			}
		}
		
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {	
			
			for (int x = 0; x < arr[i].length; x++) {
				System.out.printf("%5d", arr[i][x]);
			}
		
			System.out.println();
		}
		
		
		
		for (int i = 0; i < arr.length; i++) {	
			for (int x = 0; x < arr[i].length; x++) {
				arr[1][x] = 0;
			}
		}
		
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {	
			
			for (int x = 0; x < arr[i].length; x++) {
				System.out.printf("%5d", arr[i][x]);
			}
		
			System.out.println();
		}

	}

}
