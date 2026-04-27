package desabille;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;


public class JTableExpenseTracker extends JFrame{
	
	// Initializations
	JLabel lblTitle, lblReceiptNum, lblStoreName, lblTotalCost, lblTax, lblFinalAmount;
	JTextField txtReceiptNum, txtStoreName, txtTotalCost, txtTax, txtFinalAmount;
	JButton btnRecord, btnClear;
	DefaultTableModel model;
	JTable table;
	JScrollPane scrollTable;
	
	
	// Main
	public static void main(String[] args) {
		new JTableExpenseTracker();	// Calling the gui
	}
	
	
	
	
	
	// Shows the GUI, Input and Output of the User
	JTableExpenseTracker() {
		// Title
		lblTitle = new JLabel("WYZ EXPENSE TRACKER", SwingConstants.CENTER);
		lblTitle.setBounds(150, 10, 250, 30);
		lblTitle.setFont(new Font("Serif", Font.BOLD, 20));
		add(lblTitle);
		
		
		// Shows the text
		lblReceiptNum = new JLabel("Receipt Number:");				// Making a text on the GUI
		lblReceiptNum.setBounds(30, 50, 250, 30);					// Coordinates and creates the bounds of the text
		lblReceiptNum.setFont(new Font("Serif", Font.BOLD, 16));	// Adding font and size to the text
		add(lblReceiptNum);											// Displays the text
		// Shows the input textbox
		txtReceiptNum = new JTextField();							// Making a textbox on the GUI
		txtReceiptNum.setBounds(200, 50, 250, 30);					// Coordinates and creates the size of the textbox
		txtReceiptNum.setFont(new Font("Serif", Font.PLAIN, 16));	// Adding font and size of the text on the textbox
		add(txtReceiptNum);											// Displays the textbox
		
		
		lblStoreName = new JLabel("Store Name:");
		lblStoreName.setBounds(30, 90, 250, 30);
		lblStoreName.setFont(new Font("Serif", Font.BOLD, 16));
		add(lblStoreName);
		
		txtStoreName = new JTextField();
		txtStoreName.setBounds(200, 90, 250, 30);
		txtStoreName.setFont(new Font("Serif", Font.PLAIN, 16));
		add(txtStoreName);
		
		
		lblTotalCost = new JLabel("Total Cost:");
		lblTotalCost.setBounds(30, 130, 250, 30);
		lblTotalCost.setFont(new Font("Serif", Font.BOLD, 16));
		add(lblTotalCost);
		
		txtTotalCost = new JTextField();
		txtTotalCost.setBounds(200, 130, 250, 30);
		txtTotalCost.setFont(new Font("Serif", Font.PLAIN, 16));
		add(txtTotalCost);
		
		
		lblTax = new JLabel("Tax(12%):");
		lblTax.setBounds(30, 200, 250, 30);
		lblTax.setFont(new Font("Serif", Font.BOLD, 16));
		add(lblTax);
		
		txtTax = new JTextField();
		txtTax.setBounds(200, 200, 250, 30);
		txtTax.setFont(new Font("Serif", Font.PLAIN, 16));
		txtTax.setEditable(false);									// Makes the textbox not editable
		add(txtTax);
		
		
		lblFinalAmount = new JLabel("Final Amount:");
		lblFinalAmount.setBounds(30, 240, 250, 30);
		lblFinalAmount.setFont(new Font("Serif", Font.BOLD, 16));
		add(lblFinalAmount);
		
		txtFinalAmount = new JTextField();
		txtFinalAmount.setBounds(200, 240, 250, 30);
		txtFinalAmount.setFont(new Font("Serif", Font.PLAIN, 16));
		txtFinalAmount.setEditable(false);
		add(txtFinalAmount);
		
		
		// Shows a button
		btnRecord = new JButton("Record");							// Makes a button with a text on the GUI
		btnRecord.setBounds(90, 300, 125, 30);						// Coordinates and creates the size of the button
		btnRecord.setFont(new Font("Serif", Font.PLAIN, 16));		// Adding font and size of the text on the button
		btnRecord.addActionListener(e -> record());					// Getting action after pressing the button
		add(btnRecord);												// Displays the button
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(255, 300, 125, 30);
		btnClear.setFont(new Font("Serif", Font.PLAIN, 16));
		btnClear.addActionListener(e -> clear());
		add(btnClear);
		
		
		// Shows a table
		String[] columns = {"Receipt Number",						// Making the text for columns on the table
							"Store Name",
							"Total Cost",
							"Tax(12%)",
							"Final Amount"};
		model = new DefaultTableModel(columns, 0) {					// Built-in data handler for the table
		    public boolean isCellEditable(int row, int column) {	// Making the table not editable
		        return false;
		    }
		};
		table = new JTable(model);									// Display the data in a table format
		scrollTable = new JScrollPane(table);						// Adds scrollbars in a table
		scrollTable.setBounds(500, 50, 450, 220);					// Coordinates and creates the size of the table
		add(scrollTable);											// Displays the table
		refreshTable();												// Calling to refresh the data in the table
		
		// Defaults of the GUI
		setLayout(null);
		setTitle("WYZ EXPENSE TRACKER");
		setSize(1000, 400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	
	
	
	// Records the data to the text file and displays it on the GUI
	void record() {
		// Checks if any required field is empty
		if (txtReceiptNum.getText().isEmpty() ||
			    txtStoreName.getText().isEmpty() ||
			    txtTotalCost.getText().isEmpty()) {

			    JOptionPane.showMessageDialog(this, "Please fill-up the requirements");
			    return;	// Stops the method if a textbox is empty
			}
		
		
		
		// Validates the input using try-catch
		try {
			int receiptNum = Integer.parseInt(txtReceiptNum.getText());		// Validate if the input is a number
			double totalCost = Double.parseDouble(txtTotalCost.getText());	// Converts input to double
			double tax = totalCost * 0.12;									// Computes the 12% tax
			double finalAmount = totalCost + tax;							// Computes the final amount
			
			
			txtTax.setText(String.format("₱%.2f", tax));					// Displays computed tax
			txtFinalAmount.setText(String.format("₱%.2f", finalAmount));	// Displays final amount
			
			
			FileWriter fw = new FileWriter("ExpenseTracker.txt", true);		// Creates file
			BufferedWriter bw = new BufferedWriter(fw);						// Writes efficiently to file
			
			String strReceiptNum = String.format("%d", receiptNum);					// Gets receipt number
			String storeName = txtStoreName.getText();						// Gets store name
			String strTotalCost = String.format("₱%.2f", totalCost);		// Formats total cost
			String strTax = String.format("₱%.2f", tax);					// Formats tax
			String strFinalAmount = String.format("₱%.2f", finalAmount);	// Formats final amount
			
			bw.write(strReceiptNum + " || " + storeName + " || " + strTotalCost + " || " + strTax + " || " + strFinalAmount);	// Writes data to file
			bw.newLine();																									// Moves to next line
			
			bw.close();														// Closes the writer
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(this, "ERROR OCCURED: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); 	// Shows number error
		} catch (IOException x) {
			JOptionPane.showMessageDialog(this, "ERROR OCCURED: " + x.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); 	// Shows file error
		}
		
		refreshTable();														// Updates the table after recording
	}
	
	
	
	void clear() {
		txtReceiptNum.setText("");	// Clears receipt number field
		txtStoreName.setText("");	// Clears store name field
		txtTotalCost.setText("");	// Clears total cost field
		txtTax.setText("");			// Clears tax field
		txtFinalAmount.setText("");	// Clears final amount field
	}
	
	
	
	void refreshTable() {
		model.setRowCount(0);		// Clears existing rows in table
		try {
			FileReader fr = new FileReader("ExpenseTracker.txt");	// Opens the file
			BufferedReader br = new BufferedReader(fr);				// Reads file line by line
			
			String line = "";										// Stores each line
			while ((line = br.readLine()) != null) {					// Loops through file
				String row[] = line.split(" \\|\\| ");				// Splits data by delimiter
				model.addRow(row);									// Adds row to table
			}
			
			br.close();												// Closes the reader
		} catch (IOException e){
			JOptionPane.showMessageDialog(this, "ERROR OCCURED: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);	// Shows error if file fails
		}
		
		revalidate();	// Refresh layout
		repaint();		// Refresh GUI display
	}

}
