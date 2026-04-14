package desabille;

import javax.swing.*;
import java.io.*;

public class DESABILLE_2DStudentFeedback {
	public static void main(String[] args) {
		int totalFeedbacks = 0;
		double totalRating = 0;
		int excellentCount = 0;
		int goodCount = 0;
		int averageCount = 0;
		int poorCount = 0;
		int veryPoorCount = 0;

		try {
			FileWriter fw = new FileWriter("feedback.txt", true);
			BufferedWriter br = new BufferedWriter(fw);
			br.write("==== Student Feedback Records ====\n");
			JOptionPane.showMessageDialog(null, "Press enter to start", "STUDENT FEEDBACK SYSTEM", JOptionPane.INFORMATION_MESSAGE);
			
			boolean exit = false;
			while (!exit) {
				String option = "==================================\n"
							+ "[1] Add Student's Feedback\n"
							+ "[2] View Student's Feedback Summary\n"
							+ "[3] Exit\n"
							+ "==================================\n"
							+ "Please Select Option:";
				
				String choice = JOptionPane.showInputDialog(null, option, "STUDENT FEEDBACK SYSTEM", JOptionPane.INFORMATION_MESSAGE);
				
				if (choice == null) {
				    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);

				    if (response == JOptionPane.YES_OPTION) {
				    	JOptionPane.showMessageDialog(null, "Thank You.", "STUDENT FEEDBACK SYSTEM", JOptionPane.INFORMATION_MESSAGE);
				        exit = true;
				        break;
				    } else if (response == JOptionPane.CLOSED_OPTION) {
				        JOptionPane.showMessageDialog(null, "Thank You.", "STUDENT FEEDBACK SYSTEM", JOptionPane.INFORMATION_MESSAGE);
				    }
				    continue;
				}
				
				if (choice.isBlank()) {
					JOptionPane.showMessageDialog(null, "Input cannot be empty. Please try again.", "STUDENT FEEDBACK SYSTEM", JOptionPane.ERROR_MESSAGE);
					continue;
				}
				
				
				
				switch (choice) {
				case "1":
					boolean addFeedback = false;
					while (!addFeedback) {
						String studentName = JOptionPane.showInputDialog(null, "Enter Student Name:", "STUDENT FEEDBACK SYSTEM", JOptionPane.QUESTION_MESSAGE);
						if (studentName == null || studentName.isBlank()) {
							JOptionPane.showMessageDialog(null, "Input cannot be empty. Please try again.", "STUDENT FEEDBACK SYSTEM", JOptionPane.ERROR_MESSAGE);
							continue;
						}
						
						String crsSubName = JOptionPane.showInputDialog(null, "Enter Course/Subject:", "STUDENT FEEDBACK SYSTEM", JOptionPane.QUESTION_MESSAGE);
						if (crsSubName == null || crsSubName.isBlank()) {
							JOptionPane.showMessageDialog(null, "Input cannot be empty. Please try again.", "STUDENT FEEDBACK SYSTEM", JOptionPane.ERROR_MESSAGE);
							continue;
						}
						
						String fdbckMess = JOptionPane.showInputDialog(null, "Enter Feedback Message:", "STUDENT FEEDBACK SYSTEM", JOptionPane.QUESTION_MESSAGE);
						if (fdbckMess == null || fdbckMess.isBlank()) {
							JOptionPane.showMessageDialog(null, "Input cannot be empty. Please try again.", "STUDENT FEEDBACK SYSTEM", JOptionPane.ERROR_MESSAGE);
							continue;
						}
						
						String ratingInput = JOptionPane.showInputDialog(null, "Enter Rating (1-5):", "STUDENT FEEDBACK SYSTEM", JOptionPane.QUESTION_MESSAGE);
						if (ratingInput == null || ratingInput.isBlank()) {
							JOptionPane.showMessageDialog(null, "Input cannot be empty. Please try again.", "STUDENT FEEDBACK SYSTEM", JOptionPane.ERROR_MESSAGE);
							continue;
						}
						
						int rating;
						try {
							rating = Integer.parseInt(ratingInput);
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.", "STUDENT FEEDBACK SYSTEM", JOptionPane.ERROR_MESSAGE);
							continue;
						}
						
						if (rating < 1 || rating > 5) {
							JOptionPane.showMessageDialog(null, "Invalid rating! Please enter a number between 1 and 5.", "STUDENT FEEDBACK SYSTEM", JOptionPane.ERROR_MESSAGE);
							continue;
						}
						
						String ratingCategory = "";
						switch (rating) {
						case 5:
							ratingCategory = "Excellent";
							excellentCount++;
							break;
						case 4:
							ratingCategory = "Good";
							goodCount++;
							break;
						case 3:
							ratingCategory = "Average";
							averageCount++;
							break;
						case 2:
							ratingCategory = "Poor";
							poorCount++;
							break;
						case 1:
							ratingCategory = "Very Poor";
							veryPoorCount++;
							break;
						}
						
						br.write("\nStudent Name: " + studentName);
						br.write("\nCourse: " + crsSubName);
						br.write("\nFeedback: " + fdbckMess);
						br.write("\nRating: " + rating + " (" + ratingCategory + ")\n");
						totalRating += rating;
						totalFeedbacks++;
						
						int response = JOptionPane.showConfirmDialog(null, "Do you want to enter more feedback?", "STUDENT FEEDBACK SYSTEM", JOptionPane.YES_NO_OPTION);
						if (response == JOptionPane.YES_OPTION) {
							continue;
						}
						if (response == JOptionPane.NO_OPTION) {
							break;
						}
					}
					break;
				case "2":
					if (totalFeedbacks == 0) {
						JOptionPane.showMessageDialog(null, "No feedback data available.", "STUDENT FEEDBACK SYSTEM", JOptionPane.INFORMATION_MESSAGE);
						continue;
					} else {
						double averageRating;

						if (totalFeedbacks > 0) {
						    averageRating = totalRating / totalFeedbacks;
						} else {
						    averageRating = 0;
						}
						
						String avgRating = "Total Feedbacks: " + totalFeedbacks
								+ String.format("\nAverage Rating: %.2f", averageRating)
								+ "\n\nRATING SUMMARY\n"
								+ "Excellent: " + excellentCount
								+ "\nGood: " + goodCount
								+ "\nAverage: " + averageCount
								+ "\nPoor: " + poorCount
								+ "\nVery Poor: " + veryPoorCount;
						
						JOptionPane.showMessageDialog(null, avgRating, "STUDENT FEEDBACK SYSTEM", JOptionPane.INFORMATION_MESSAGE);
					}
					continue;
				case "3":
					JOptionPane.showMessageDialog(null, "Thank You.", "STUDENT FEEDBACK SYSTEM", JOptionPane.INFORMATION_MESSAGE);
					exit = true;
					continue;
				default:
					JOptionPane.showMessageDialog(null, "Invalid selection. Please try again.", "STUDENT FEEDBACK SYSTEM", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				JOptionPane.showMessageDialog(null, "Feedback data saved successfully!", "STUDENT FEEDBACK SYSTEM", JOptionPane.INFORMATION_MESSAGE);
			}
			
			br.write("==================================\n");
			br.write("Total Feedbacks: " + totalFeedbacks + "\n");
			double averageRating;
			if (totalFeedbacks > 0) {
			    averageRating = totalRating / totalFeedbacks;
			} else {
			    averageRating = 0;
			}
			br.write(String.format("Average Rating: %.2f%n", averageRating));
			br.write("\nRATING SUMMARY:\n");
			br.write("Excellent: " + excellentCount + "\n");
			br.write("Good: " + goodCount + "\n");
			br.write("Average: " + averageCount + "\n");
			br.write("Poor: " + poorCount + "\n");
			br.write("Very Poor: " + veryPoorCount + "\n");
			br.write("==================================\n");
			
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "An error occurred while saving the feedback. Please try again.", "STUDENT FEEDBACK SYSTEM", JOptionPane.ERROR_MESSAGE);
		}
	}
}