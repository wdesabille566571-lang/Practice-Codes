package desabille;

import javax.swing.*;

public class DESABILLE_2DHotelReservation {

	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "HOTEL RESERVATION SYSTEM", "WYZ HOTEL", JOptionPane.INFORMATION_MESSAGE);
		
		String menu = "==============================\n"
					+ "MENU:\n"
					+ "[1] View Rooms\n"
					+ "[2] Check In\n"
					+ "[3] Check Out\n"
					+ "[4] Exit\n"
					+ "==============================\n"
					+ "Select Option:";
		
		int hotel[][] = new int[7][5];
		
		boolean exit = false;
		while (!exit) {
			String option = JOptionPane.showInputDialog(null, menu, "WYZ HOTEL", JOptionPane.QUESTION_MESSAGE);
			
			if (option == null) {
				exit = true;
				break;
			}
			
			if (option.isBlank()) {
				
				JOptionPane.showMessageDialog(null, "Input cannot be empty. Please try again.", "WYZ HOTEL", JOptionPane.ERROR_MESSAGE);
				continue;
			}
			
			int num = 0;
			try {
				num = Integer.parseInt(option);
				
				String view = "";
				
				switch (num) {
				case 1:
					view = "==============================\n"
								+ "VIEW ROOMS\n"
								+ "0 = Available | | 1 = Occupied\n"
								+ "==============================\n";
					
					for (int i = hotel.length - 1; i >= 0; i--) {
						view += "Floor " + (i + 1) + ": ";
						
						for (int x = 0; x < hotel[i].length; x++) {
							view += "[" + hotel[i][x] + "] ";
						}
						
						if (i >= 0) {
							view += "\n==============================\n";
						}
					}
					
					JOptionPane.showMessageDialog(null, view, "WYZ HOTEL", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 2:
					int inFloor = 0;
					int inRoom = 0;
					
					while (true) {
						view = "==============================\n"
								+ "ROOM'S CHECK-IN\n"
								+ "0 = Available | | 1 = Occupied\n"
								+ "==============================\n";
						
						for (int i = hotel.length - 1; i >= 0; i--) {
							view += "Floor " + (i + 1) + ": ";
							
							for (int x = 0; x < hotel[i].length; x++) {
								view += "[" + hotel[i][x] + "] ";
							}
							
							if (i >= 0) {
								view += "\n==============================\n";
							}
						}
						
						String numFloor = JOptionPane.showInputDialog(null, view + "Enter floor number (1-7):", "WYZ HOTEL", JOptionPane.QUESTION_MESSAGE);
						if (numFloor == null) {
							JOptionPane.showMessageDialog(null, "Input cancelled.", "WYZ HOTEL", JOptionPane.WARNING_MESSAGE);
							break;
						}
						
						if (numFloor.isBlank()) {
							JOptionPane.showMessageDialog(null, "Input cannot be empty. Please try again.", "WYZ HOTEL", JOptionPane.ERROR_MESSAGE);
							continue;
						}
						
						String numRoom = JOptionPane.showInputDialog(null, view + "Enter room number (1-5):", "WYZ HOTEL", JOptionPane.QUESTION_MESSAGE);
						if (numRoom == null) {
							JOptionPane.showMessageDialog(null, "Input cancelled.", "WYZ HOTEL", JOptionPane.WARNING_MESSAGE);
							break;
						}
						
						if (numRoom.isBlank()) {
							JOptionPane.showMessageDialog(null, "Input cannot be empty. Please try again.", "WYZ HOTEL", JOptionPane.ERROR_MESSAGE);
							continue;
						}
						
						try {
							inFloor = Integer.parseInt(numFloor);
							inRoom = Integer.parseInt(numRoom);
							
							String inFloorRoom = "Floor: " + inFloor 
									+ "\nRoom: " + inRoom;
							
							inFloor -= 1;
							inRoom -= 1;
							
							if (inFloor < 0 || inFloor >= 7 || inRoom < 0 || inRoom >= 5) {
								JOptionPane.showMessageDialog(null, "Invalid input. Try again.", "WYZ HOTEL", JOptionPane.ERROR_MESSAGE);
								continue;
							}
							if (hotel[inFloor][inRoom] == 0) {
								hotel[inFloor][inRoom] = 1;
								
								JOptionPane.showMessageDialog(null, inFloorRoom + "\nCheck-in Successful!", "WYZ HOTEL", JOptionPane.INFORMATION_MESSAGE);
								break;
							} else {
								JOptionPane.showMessageDialog(null, inFloorRoom + "\nRoom already occupied. Try again.", "WYZ HOTEL", JOptionPane.WARNING_MESSAGE);
							}
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Invalid input. Try again.", "WYZ HOTEL", JOptionPane.ERROR_MESSAGE);
							continue;
						}	
					}
					break;
				case 3:
					int outFloor = 0;
					int outRoom = 0;
					
					while (true) {
						view = "==============================\n"
								+ "ROOM'S CHECK-OUT\n"
								+ "0 = Available | | 1 = Occupied\n"
								+ "==============================\n";
						
						for (int i = hotel.length - 1; i >= 0; i--) {
							view += "Floor " + (i + 1) + ": ";
							
							for (int x = 0; x < hotel[i].length; x++) {
								view += "[" + hotel[i][x] + "] ";
							}
							
							if (i >= 0) {
								view += "\n==============================\n";
							}
						}
						
						String numFloor = JOptionPane.showInputDialog(null, view + "Enter floor number (1-7):", "WYZ HOTEL", JOptionPane.QUESTION_MESSAGE);
						if (numFloor == null) {
							JOptionPane.showMessageDialog(null, "Input cancelled.", "WYZ HOTEL", JOptionPane.WARNING_MESSAGE);
							break;
						}
						
						if (numFloor.isBlank()) {
							JOptionPane.showMessageDialog(null, "Input cannot be empty. Please try again.", "WYZ HOTEL", JOptionPane.ERROR_MESSAGE);
							continue;
						}
						
						String numRoom = JOptionPane.showInputDialog(null, view + "Enter room number (1-5):", "WYZ HOTEL", JOptionPane.QUESTION_MESSAGE);
						if (numRoom == null) {
							JOptionPane.showMessageDialog(null, "Input cancelled.", "WYZ HOTEL", JOptionPane.WARNING_MESSAGE);
							break;
						}
						
						if (numRoom.isBlank()) {
							JOptionPane.showMessageDialog(null, "Input cannot be empty. Please try again.", "WYZ HOTEL", JOptionPane.ERROR_MESSAGE);
							continue;
						}
						
						try {
							outFloor = Integer.parseInt(numFloor);
							outRoom = Integer.parseInt(numRoom);
							
							String outFloorRoom = "Floor: " + outFloor 
									+ "\nRoom: " + outRoom;
							
							outFloor -= 1;
							outRoom -= 1;
							
							if (outFloor < 0 || outFloor >= 7 || outRoom < 0 || outRoom >= 5) {
								JOptionPane.showMessageDialog(null, "Invalid input. Try again.", "WYZ HOTEL", JOptionPane.ERROR_MESSAGE);
								continue;
							}
							if (hotel[outFloor][outRoom] == 1) {
								hotel[outFloor][outRoom] = 0;
								
								JOptionPane.showMessageDialog(null, outFloorRoom + "\nRoom is available.", "WYZ HOTEL", JOptionPane.INFORMATION_MESSAGE);
								break;
							} else {
								JOptionPane.showMessageDialog(null, outFloorRoom + "\nThe room is already empty.", "WYZ HOTEL", JOptionPane.WARNING_MESSAGE);
								break;
							}
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Invalid input. Try again.", "WYZ HOTEL", JOptionPane.ERROR_MESSAGE);
							continue;
						}
					}
					break;
				case 4:
					String thanksMessage = "==============================\n"
										+ "Thankyou for booking with us!\n"
										+ "ENJOY YOUR STAY!\n"
										+ "==============================";
					
					JOptionPane.showMessageDialog(null, thanksMessage, "WYZ HOTEL", JOptionPane.INFORMATION_MESSAGE);
					exit = true;
					break;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid input. Try again.", "WYZ HOTEL", JOptionPane.ERROR_MESSAGE);
				continue;
			}
			
			if (num < 1 || num > 4) {
				JOptionPane.showMessageDialog(null, "Number must between 1-4. Please try again.", "WYZ HOTEL", JOptionPane.ERROR_MESSAGE);
				continue;
			}	
		}

	}

}
