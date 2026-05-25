package practice;

import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class dump2 extends JFrame{
	DefaultTableModel model;
	JTable table;
	JScrollPane scroll;
	JLabel lblFullName, lblCourseDept, lblYearLevel, lblWalletBalance, lblStatus;
	JTextField txtFullName, txtCourseDept, txtYearLevel, txtWalletBalance, txtStatus;
	JButton btnAdd, btnUpdate, btnDelete, btnClear;
	
	

	public static void main(String[] args) throws IOException {
		new dump2();
	}
	
	
 
	dump2() throws IOException {
		String[] columns = {"Full Name", "Course/Department", "Year Level", "Wallet Balance", "Status"};
		model = new DefaultTableModel(columns, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if (row != -1) {
					txtFullName.setText(model.getValueAt(row, 0).toString());
					txtCourseDept.setText(model.getValueAt(row, 1).toString());
					txtYearLevel.setText(model.getValueAt(row, 2).toString());
					txtWalletBalance.setText(model.getValueAt(row, 3).toString());
					txtStatus.setText(model.getValueAt(row, 4).toString());
				}
			}
		});
		scroll = new JScrollPane(table);
		scroll.setBounds(10, 10, 470, 250);
		add(scroll);
		
		
		lblFullName = new JLabel("Full Name:");
		lblCourseDept = new JLabel("Course/Department:");
		lblYearLevel = new JLabel("Year Level:");
		lblWalletBalance = new JLabel("Wallet Balance:");
		lblStatus = new JLabel("Status:");
		
		
		txtFullName = new JTextField();
		txtCourseDept = new JTextField();
		txtYearLevel = new JTextField();
		txtWalletBalance = new JTextField();
		txtStatus = new JTextField();
		
		
		btnAdd = new JButton("Add");
		btnUpdate = new JButton("Update");
		btnDelete = new JButton("Delete");
		btnClear = new JButton("Clear");
		
		
		Font fontBold = new Font("Serif", Font.BOLD, 16);
		Font fontPlain = new Font("Serif", Font.PLAIN, 16);
		lblFullName.setFont(fontBold);
		lblCourseDept.setFont(fontBold);
		lblYearLevel.setFont(fontBold);
		lblWalletBalance.setFont(fontBold);
		lblStatus.setFont(fontBold);
		
		txtFullName.setFont(fontPlain);
		txtCourseDept.setFont(fontPlain);
		txtYearLevel.setFont(fontPlain);
		txtWalletBalance.setFont(fontPlain);
		txtStatus.setFont(fontPlain);
		
		btnAdd.setFont(fontBold);
		btnUpdate.setFont(fontBold);
		btnDelete.setFont(fontBold);
		btnClear.setFont(fontBold);
		
		
		lblFullName.setBounds(10, 300, 150, 20);
		txtFullName.setBounds(170, 300, 200, 20);
		btnAdd.setBounds(380, 300, 100, 20);
		
		lblCourseDept.setBounds(10, 330, 150, 20);
		txtCourseDept.setBounds(170, 330, 200, 20);
		btnUpdate.setBounds(380, 330, 100, 20);
		
		lblYearLevel.setBounds(10, 360, 150, 20);
		txtYearLevel.setBounds(170, 360, 200, 20);
		btnDelete.setBounds(380, 360, 100, 20);
		
		lblWalletBalance.setBounds(10, 390, 150, 20);
		txtWalletBalance.setBounds(170, 390, 200, 20);
		btnClear.setBounds(380, 390, 100, 20);
		
		lblStatus.setBounds(10, 420, 150, 20);
		txtStatus.setBounds(170, 420, 200, 20);
		
		
		add(lblFullName);
		add(txtFullName);
		add(btnAdd);
		add(lblCourseDept);
		add(txtCourseDept);
		add(btnUpdate);
		add(lblYearLevel);
		add(txtYearLevel);
		add(btnDelete);
		add(lblWalletBalance);
		add(txtWalletBalance);
		add(btnClear);
		add(lblStatus);
		add(txtStatus);
		
		
		btnAdd.addActionListener(e -> add());
		btnUpdate.addActionListener(e -> update());
		btnDelete.addActionListener(e -> delete());
		btnClear.addActionListener(e -> clear());
		
		
		File file = new File("SCW.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		
		
		viewTable();
		
		
		
		setLayout(null);
		setTitle("SCW");
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	
	void add() {
		if (valid()) {
			return;
		}
		
		if (duplicate()) {
			return;
		}
		
		int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to add this data?", "Confirm Add", JOptionPane.YES_NO_OPTION);
		if (choice != JOptionPane.YES_OPTION) {
			return;
		}
		
		
		try {
			int yearLevel = Integer.parseInt(txtYearLevel.getText().trim());
			double walletBalance = Double.parseDouble(txtWalletBalance.getText().trim());
			
			if (yearLevel < 1 || yearLevel > 4) {
				JOptionPane.showMessageDialog(this, "Year level must be between 1-4.", "Invalid Year Level", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if (walletBalance < 0) {
				JOptionPane.showMessageDialog(this, "Wallet balance must be not less than 0.", "Invalid Wallet Balance", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			
			FileWriter fw = new FileWriter("SCW.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String data = txtFullName.getText().trim() + "#"
						+ txtCourseDept.getText().trim() + "#"
						+ yearLevel + "#"
						+ String.format("%.2f", walletBalance) + "#"
						+ txtStatus.getText().trim();
			
			bw.write(data);
			bw.newLine();
			
			bw.close();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Year Level & Wallet Balance must be valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error Occurred", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		JOptionPane.showMessageDialog(this, "Data added successfully!", "Data Added", JOptionPane.INFORMATION_MESSAGE);
		clear();
		viewTable();
	}
	
	
	
	void update() {
		int selectedRow = table.getSelectedRow();
		
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Select data to update.", "No Selected", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if (valid()) {
			return;
		}
		
		int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to update this data?", "Confirm Update", JOptionPane.YES_NO_OPTION);
		if (choice != JOptionPane.YES_OPTION) {
			return;
		}
		
		
		ArrayList<String> lines = new ArrayList<>();
		try {
			int yearLevel = Integer.parseInt(txtYearLevel.getText().trim());
			double walletBalance = Double.parseDouble(txtWalletBalance.getText().trim());
			
			if (yearLevel < 1 || yearLevel > 4) {
				JOptionPane.showMessageDialog(this, "Year level must be between 1-4.", "Invalid Year Level", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if (walletBalance < 0) {
				JOptionPane.showMessageDialog(this, "Wallet balance must be not less than 0.", "Invalid Wallet Balance", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			
			FileReader fr = new FileReader("SCW.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			int rowIndex = 0;
			while ((line = br.readLine()) != null) {
				if (rowIndex == selectedRow) {
					String updateData = txtFullName.getText().trim() + "#"
							+ txtCourseDept.getText().trim() + "#"
							+ yearLevel + "#"
							+ String.format("%.2f", walletBalance) + "#"
							+ txtStatus.getText().trim();
					
					lines.add(updateData);
				} else {
					lines.add(line);
				}
			rowIndex++;
			}
			
			br.close();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Year Level & Wallet Balance must be valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error Occurred", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		try {
			FileWriter fw = new FileWriter("SCW.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (String data : lines) {
				bw.write(data);
				bw.newLine();
			}

			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error Occurred", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		JOptionPane.showMessageDialog(this, "Data updated successfully!", "Data Updated", JOptionPane.INFORMATION_MESSAGE);
		clear();
		viewTable();
	}
	
	
	
	void delete() {
		int selectedRow = table.getSelectedRow();
		
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Select data to delete.", "No Selected", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this data?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
		if (choice != JOptionPane.YES_OPTION) {
			return;
		}
		
		
		ArrayList<String> lines = new ArrayList<>();
		try {
			FileReader fr = new FileReader("SCW.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			int rowIndex = 0;
			while ((line = br.readLine()) != null) {
				if (rowIndex != selectedRow) {
					lines.add(line);
				}
			rowIndex++;
			}
			
			br.close();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Year Level & Wallet Balance must be valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error Occurred", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		try {
			FileWriter fw = new FileWriter("SCW.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (String data : lines) {
				bw.write(data);
				bw.newLine();
			}

			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error Occurred", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		JOptionPane.showMessageDialog(this, "Data deleted successfully!", "Data Deleted", JOptionPane.INFORMATION_MESSAGE);
		clear();
		viewTable();
	}
	
	
	
	void clear() {
		txtFullName.setText("");
		txtCourseDept.setText("");
		txtYearLevel.setText("");
		txtWalletBalance.setText("");
		txtStatus.setText("");
		table.clearSelection();
	}
	
	
	
	void viewTable() {
		model.setRowCount(0);
		
		try {
			FileReader fr = new FileReader("SCW.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String lines = "";
			while ((lines = br.readLine()) != null) {
				String[] row = lines.split("#");
				model.addRow(row);
			}
			
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error Occurred", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	boolean valid() {
		if (txtFullName.getText().trim().isEmpty() || txtCourseDept.getText().trim().isEmpty() ||
			txtYearLevel.getText().trim().isEmpty() || txtWalletBalance.getText().trim().isEmpty() ||
			txtStatus.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill-up the missing requirement/s.", "Missing Requirement/s", JOptionPane.WARNING_MESSAGE);
			return true;
		}
			
		if (!txtStatus.getText().trim().equals("Active") && !txtStatus.getText().trim().equals("Suspended")) {
			JOptionPane.showMessageDialog(this, "Enter valid status: Active/Suspended", "Invalid Status", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		
		return false;
	}
	
	
	
	boolean duplicate() {
		try {
			FileReader fr = new FileReader("SCW.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String lines = "";
			while ((lines = br.readLine()) != null) {
				String[] row = lines.split("#");
				String fullName = row[0];
				String courseDept = row[1];
				String yearLevel = row[2];
				
				if (row.length >= 3) {
					if (txtFullName.getText().trim().equals(fullName) && txtCourseDept.getText().trim().equals(courseDept) &&
						txtYearLevel.getText().trim().equals(yearLevel)) {
						JOptionPane.showMessageDialog(this, "This data is already created.", "Data Duplicate", JOptionPane.WARNING_MESSAGE);
						br.close();
						return true;
					}
				}
			}
			
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error Occurred", JOptionPane.ERROR_MESSAGE);
			return true;
		}
		return false;
	}

}
