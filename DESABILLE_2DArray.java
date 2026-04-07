package desabille;

import java.util.Scanner;

public class DESABILLE_2DArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==============================");
		System.out.println("   HOTEL RESERVATION SYSTEM");

		int hotel[][] = new int[7][5];

		boolean exit = false;
		while (!exit) {
			String menu = "==============================\n"
						+ "             MENU\n"
						+ "[1] View Rooms\n"
						+ "[2] Check In\n"
						+ "[3] Check Out\n"
						+ "[4] Exit\n"
						+ "------------------------------\n"
						+ "Select Option: ";

			System.out.print(menu);
			int option = sc.nextInt(); sc.nextLine();
			System.out.println("==============================");
			
			switch (option) {
			case 1:
				System.out.println("\n==============================\n"
								 + "            VIEW ROOMS\n"
								 + "0 = Available | | 1 = Occupied\n"
								 + "------------------------------");

				for (int i = hotel.length-1; i >= 0; i--) {
					System.out.print("Floor " + (i + 1) + ": ");

					for (int x = 0; x < hotel[i].length; x++) {
						System.out.print("[" + hotel[i][x] + "]");
					}
					
					if (i > 0) {
						System.out.println("\n");
					} else {
						System.out.println();
					}
				}
				
				System.out.println("==============================\n");
				
				break;
			case 2:
				int inFloor = 0;
				int inRoom = 0;
				
				while (true) {
					System.out.println("\n==============================");
					System.out.println("           CHECK-IN");
					
					System.out.print("Enter floor number (1-7): ");
					inFloor = sc.nextInt();
					System.out.println("------------------------------");

					System.out.print("Enter room number (1-5): ");
					inRoom = sc.nextInt();
					System.out.println("------------------------------");

					inFloor -= 1;
					inRoom -= 1;

					if (inFloor < 0 || inFloor >= 7 || inRoom < 0 || inRoom >= 5) {
						System.out.println("(Invalid input. Try again.)\n");
						continue;
					}

					if (hotel[inFloor][inRoom] == 0) {
						hotel[inFloor][inRoom] = 1;
						
						System.out.println("Check-in successful!");
						
						break;
					} else {
						System.out.println("Room already occupied. Try again.\n");
					}
				}
				
				System.out.println("==============================\n");

				break;
			case 3:
				int outFloor = 0;
				int outRoom = 0;

				while (true) {
					System.out.println("\n==============================");
					System.out.println("          CHECK-OUT");
					
					System.out.print("Enter floor number (1-7): ");
					outFloor = sc.nextInt();
					System.out.println("------------------------------");

					System.out.print("Enter room number (1-5): ");
					outRoom = sc.nextInt();
					System.out.println("------------------------------");

					outFloor -= 1;
					outRoom -= 1;

					if (outFloor < 0 || outFloor >= 7 || outRoom < 0 || outRoom >= 5) {
						System.out.println("Invalid input. Try again.\n");
						continue;
					}

					if (hotel[outFloor][outRoom] == 1) {
						hotel[outFloor][outRoom] = 0;

						System.out.println("Room is available.");

						break;
					} else {
						System.out.println("The room is already empty.");

						break;
					}
				}
				
				System.out.println("==============================\n");
				
				break;
			case 4:
				System.out.println("Thankyou for booking with us!");
				System.out.println("       ENJOY YOUR STAY!");
				System.out.println("==============================");
				
				exit = true;
				break;
			}

		}
		
		sc.close();
	}

}