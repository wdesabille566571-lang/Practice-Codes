package desabille;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;


public class EMS_gui extends JFrame{
	JLabel lblTitle, lblEmpID, lblFullName, lblBirthDate, lblAge, lblCivilStatus, lblNationality, lblGender, lblContactNum, lblEmail, lblDepartment, lblJobTitle;
	JTextField txtEmpID, txtFullName, txtBirthDate, txtAge, txtNationality, txtContactNum, txtEmail, txtDepartment, txtJobTitle;
	JComboBox boxCivilStatus;
	JRadioButton rbnMale, rbnFemale;
	ButtonGroup grpGender;
	JButton btnAdd, btnDelete, btnUpdate;
	JTable table;
	DefaultTableModel model;
	JScrollPane scrollTable;
	
	
	public static void main(String[] args) {
		new EMS_gui();
	}
	
	
	
	
	
	EMS_gui() {
		lblTitle = new JLabel("EMS Inc.");
		lblTitle.setBounds(40, 20, 150, 18);
		lblTitle.setFont(new Font("Serif", Font.BOLD, 16));
		add(lblTitle);
		
		
		lblEmpID = new JLabel("Employee ID");
		lblEmpID.setBounds(40, 50, 150, 18);
		lblEmpID.setFont(new Font("Serif", Font.BOLD, 12));
		add(lblEmpID);
		
		txtEmpID = new JTextField();
		txtEmpID.setBounds(40, 68, 150, 18);
		txtEmpID.setFont(new Font("Serif", Font.PLAIN, 12));
		add(txtEmpID);
		
		
		lblAge = new JLabel("Age");
		lblAge.setBounds(220, 50, 150, 18);
		lblAge.setFont(new Font("Serif", Font.BOLD, 12));
		add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setBounds(220, 68, 150, 18);
		txtAge.setFont(new Font("Serif", Font.PLAIN, 12));
		add(txtAge);
		
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(395, 50, 150, 18);
		lblGender.setFont(new Font("Serif", Font.BOLD, 12));
		add(lblGender);
		
		rbnMale = new JRadioButton("Male");
		rbnMale.setBounds(395, 68, 60, 18);
		rbnMale.setFont(new Font("Serif", Font.BOLD, 12));
		add(rbnMale);
		
		rbnFemale = new JRadioButton("Female");
		rbnFemale.setBounds(455, 68, 70, 18);
		rbnFemale.setFont(new Font("Serif", Font.BOLD, 12));
		add(rbnFemale);
		
		grpGender = new ButtonGroup();
		grpGender.add(rbnMale);
		grpGender.add(rbnFemale);
		
		lblFullName = new JLabel("Fullname");
		lblFullName.setBounds(40, 87, 150, 18);
		lblFullName.setFont(new Font("Serif", Font.BOLD, 12));
		add(lblFullName);
		
		txtFullName = new JTextField();
		txtFullName.setBounds(40, 105, 150, 18);
		txtFullName.setFont(new Font("Serif", Font.PLAIN, 12));
		add(txtFullName);
		
		
		lblCivilStatus = new JLabel("Civil Status");
		lblCivilStatus.setBounds(220, 87, 150, 18);
		lblCivilStatus.setFont(new Font("Serif", Font.BOLD, 12));
		add(lblCivilStatus);
		
		String civilStatusOption[] = {"", "Single", "Married", "Widowed", "Separated", "Divorced"};
		boxCivilStatus = new JComboBox<>(civilStatusOption);
		boxCivilStatus.setBounds(220, 105, 150, 18);
		boxCivilStatus.setFont(new Font("Serif", Font.BOLD, 12));
		add(boxCivilStatus);
		
		
		lblContactNum = new JLabel("Contact Number");
		lblContactNum.setBounds(395, 87, 150, 18);
		lblContactNum.setFont(new Font("Serif", Font.BOLD, 12));
		add(lblContactNum);
		
		txtContactNum = new JTextField();
		txtContactNum.setBounds(395, 105, 150, 18);
		txtContactNum.setFont(new Font("Serif", Font.PLAIN, 12));
		add(txtContactNum);
		
		
		lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(570, 87, 150, 18);
		lblDepartment.setFont(new Font("Serif", Font.BOLD, 12));
		add(lblDepartment);
		
		txtDepartment = new JTextField();
		txtDepartment.setBounds(570, 105, 150, 18);
		txtDepartment.setFont(new Font("Serif", Font.PLAIN, 12));
		add(txtDepartment);
		
		
		lblBirthDate = new JLabel("Date of Birth");
		lblBirthDate.setBounds(40, 124, 150, 18);
		lblBirthDate.setFont(new Font("Serif", Font.BOLD, 12));
		add(lblBirthDate);
		
		txtBirthDate = new JTextField();
		txtBirthDate.setBounds(40, 144, 150, 18);
		txtBirthDate.setFont(new Font("Serif", Font.PLAIN, 12));
		add(txtBirthDate);
		
		
		lblNationality = new JLabel("Nationality");
		lblNationality.setBounds(220, 124, 150, 18);
		lblNationality.setFont(new Font("Serif", Font.BOLD, 12));
		add(lblNationality);
		
		txtNationality = new JTextField();
		txtNationality.setBounds(220, 144, 150, 18);
		txtNationality.setFont(new Font("Serif", Font.PLAIN, 12));
		add(txtNationality);
		
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(395, 124, 150, 18);
		lblEmail.setFont(new Font("Serif", Font.BOLD, 12));
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(395, 144, 150, 18);
		txtEmail.setFont(new Font("Serif", Font.PLAIN, 12));
		add(txtEmail);
		
		
		lblJobTitle = new JLabel("Job Title / Position");
		lblJobTitle.setBounds(570, 124, 150, 18);
		lblJobTitle.setFont(new Font("Serif", Font.BOLD, 12));
		add(lblJobTitle);
		
		txtJobTitle = new JTextField();
		txtJobTitle.setBounds(570, 144, 150, 18);
		txtJobTitle.setFont(new Font("Serif", Font.PLAIN, 12));
		add(txtJobTitle);
		
		
		btnAdd = new JButton("Add Employee");
		btnAdd.setBounds(235, 177, 120, 18);
		btnAdd.setFont(new Font("Serif", Font.PLAIN, 12));
		add(btnAdd);
		btnAdd.addActionListener(e -> addData());
		
		
		btnUpdate = new JButton("Update Employee");
		btnUpdate.setBounds(410, 177, 120, 18);
		btnUpdate.setFont(new Font("Serif", Font.PLAIN, 12));
		add(btnUpdate);
		btnUpdate.addActionListener(e -> updateData());
		
		
		btnDelete = new JButton("Delete Employee");
		btnDelete.setBounds(585, 177, 120, 18);
		btnDelete.setFont(new Font("Serif", Font.PLAIN, 12));
		add(btnDelete);
		btnDelete.addActionListener(e -> deleteData());


		
		String[] columns = {"Employee ID", "Fullname", "Birth", "Age", "Civil Status", "Nationality", "Gender", "Contact", "Email", "Department", "Job Title / Position"};
		model = new DefaultTableModel(columns, 0) {
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		scrollTable = new JScrollPane(table);
		scrollTable.setBounds(40, 210, 720, 200);
		scrollTable.setFont(new Font("Serif", Font.PLAIN, 12));
		add(scrollTable);
		
		
		viewTable();
		
		
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if(row != -1) {
					txtEmpID.setText(model.getValueAt(row, 0).toString());
					txtFullName.setText(model.getValueAt(row, 1).toString());
					txtBirthDate.setText(model.getValueAt(row, 2).toString());
					txtAge.setText(model.getValueAt(row, 3).toString());
					boxCivilStatus.setSelectedItem(model.getValueAt(row, 4).toString());
					txtNationality.setText(model.getValueAt(row, 5).toString());

	                String gender = model.getValueAt(row, 6).toString();

	                if(gender.equals("Male")) {
	                    rbnMale.setSelected(true);
	                } 
	                else if(gender.equals("Female")) {
	                    rbnFemale.setSelected(true);
	                }
	                
					txtContactNum.setText(model.getValueAt(row, 7).toString());
					txtEmail.setText(model.getValueAt(row, 8).toString());
					txtDepartment.setText(model.getValueAt(row, 9).toString());
					txtJobTitle.setText(model.getValueAt(row, 10).toString());
				}
			}
		});

	    
		
		setLayout(null);
		setTitle("WYZ EMPLOYEE MANAGEMENT SYSTEM");
		setSize(800, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	
	
	
	void addData() {
		if (txtEmpID.getText().trim().isEmpty() || txtFullName.getText().trim().isEmpty() || txtBirthDate.getText().trim().isEmpty() ||
			txtAge.getText().trim().isEmpty() || boxCivilStatus.getSelectedIndex() == 0 || txtNationality.getText().trim().isEmpty() ||
			txtContactNum.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty() || txtDepartment.getText().trim().isEmpty() || 
			txtJobTitle.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill-up the requirements.", "Missing Requirement/s", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		
		String gender =  "";
		if (rbnMale.isSelected()) {
			gender = "Male";
		} else if (rbnFemale.isSelected()) {
			gender = "Female";
		}
		
		if (!rbnMale.isSelected() && !rbnFemale.isSelected()) {
			JOptionPane.showMessageDialog(this, "Please select gender.", "Missing Requirement", JOptionPane.WARNING_MESSAGE);
			return;
		}

		
		
		try {
			int empId = Integer.parseInt(txtEmpID.getText().trim());
			int age = Integer.parseInt(txtAge.getText().trim());
			
			if (!txtBirthDate.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
			    JOptionPane.showMessageDialog(this, "Birthdate must be MM/DD/YYYY", "Invalid Birthdate", JOptionPane.WARNING_MESSAGE);
			    return;
			}
			
			if (age < 18) {
				JOptionPane.showMessageDialog(this, "Employee's age is not eligible.", "Age Not Eligible", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if (!txtContactNum.getText().trim().startsWith("09") || !txtContactNum.getText().trim().matches("\\d{11}")) {
				JOptionPane.showMessageDialog(this, "Contact number must contain 11 numbers & starts with \"09\"", "Invalid Contact Number", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if (!txtEmail.getText().contains("@") || !txtEmail.getText().contains(".")) {
				JOptionPane.showMessageDialog(this, "Invalid email format.", "Invalid Email", JOptionPane.WARNING_MESSAGE);
			    return;
			}
			
			
			int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to add this employee?", "Confirm Add", JOptionPane.YES_NO_OPTION);
		    if (confirm != JOptionPane.YES_OPTION) {
		        return;
		    }
			
			
			String data = empId + " # "
						+ txtFullName.getText().trim() + " # "
						+ txtBirthDate.getText().trim() + " # "
						+ txtAge.getText().trim() + " # "
						+ boxCivilStatus.getSelectedItem().toString() + " # "
						+ txtNationality.getText().trim() + " # "
						+ gender + " # "
						+ txtContactNum.getText().trim() + " # "
						+ txtEmail.getText().trim() + " # "
						+ txtDepartment.getText().trim() + " # "
						+ txtJobTitle.getText().trim();
			
			
			
			FileWriter fw = new FileWriter("Employees.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(data);
			bw.newLine();
			
			bw.close();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Error Occurred: " + e.getMessage(), "Data not saved", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (IOException e){
			JOptionPane.showMessageDialog(this, "Error Occurred: " + e.getMessage(), "Data not saved", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		JOptionPane.showMessageDialog(this,"Employee added successfully.");
		clear();
		table.clearSelection();
		viewTable();
	}
	
	
	
	void deleteData() {
		int selectedRow = table.getSelectedRow();
	    
	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(this, "Please select an employee to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    
	    
	    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this employee?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
	    if (confirm != JOptionPane.YES_OPTION) {
	        return;
	    }

	    

	    ArrayList<String> lines = new ArrayList<>();
	    try {
	    	FileReader fr = new FileReader("Employees.txt");
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
	    } catch (IOException e) {
	    	JOptionPane.showMessageDialog(this, "Error Occurred: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
	    	return;
	    }
	    
	    
	    
	    try {
	        FileWriter fw = new FileWriter("Employees.txt");
	        BufferedWriter bw = new BufferedWriter(fw);

	        for (String data : lines) {
	        	bw.write(data);
	        	bw.newLine();
	        }

	        bw.close();
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(this, "Error Occurred: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    JOptionPane.showMessageDialog(this,"Employee deleted successfully.");
	    clear();
	    table.clearSelection();
	    viewTable();
	}
	
	
	
	void updateData() {
		int selectedRow = table.getSelectedRow();
	    
	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(this, "Please select an employee to update.", "No Selection", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    
	    
	    if (txtEmpID.getText().trim().isEmpty() || txtFullName.getText().trim().isEmpty() || txtBirthDate.getText().trim().isEmpty() ||
				txtAge.getText().trim().isEmpty() || boxCivilStatus.getSelectedIndex() == 0 || txtNationality.getText().trim().isEmpty() ||
				txtContactNum.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty() || txtDepartment.getText().trim().isEmpty() || 
				txtJobTitle.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please fill-up the requirements.", "Missing Requirement/s", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
	    
		String gender = "";
		if (rbnMale.isSelected()) {
			gender = "Male";
		} else if (rbnFemale.isSelected()) {
			gender = "Female";
		}
			
		if (!rbnMale.isSelected() && !rbnFemale.isSelected()) {
			JOptionPane.showMessageDialog(this, "Please select gender.", "Missing Requirement", JOptionPane.WARNING_MESSAGE);
			return;
		}
	    
			
	    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to update this employee?", "Confirm Update", JOptionPane.YES_NO_OPTION);
	    if (confirm != JOptionPane.YES_OPTION) {
	        return;
	    }
	    
	    
	    
	    ArrayList<String> lines = new ArrayList<>();
	    try {
	    	int empId = Integer.parseInt(txtEmpID.getText().trim());
			int age = Integer.parseInt(txtAge.getText().trim());
			
			if (!txtBirthDate.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
			    JOptionPane.showMessageDialog(this, "Birthdate must be MM/DD/YYYY", "Invalid Birthdate", JOptionPane.WARNING_MESSAGE);
			    return;
			}
			
			if (age < 18) {
				JOptionPane.showMessageDialog(this, "Employee's age is not eligible.", "Age Not Eligible", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if (!txtContactNum.getText().trim().startsWith("09") || !txtContactNum.getText().trim().matches("\\d{11}")) {
				JOptionPane.showMessageDialog(this, "Contact number must contain 11 numbers & starts with \"09\"", "Invalid Contact Number", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if (!txtEmail.getText().contains("@") || !txtEmail.getText().contains(".")) {
				JOptionPane.showMessageDialog(this, "Invalid email format.", "Invalid Email", JOptionPane.WARNING_MESSAGE);
			    return;
			}
			
			
			
	    	FileReader fr = new FileReader("Employees.txt");
	        BufferedReader br = new BufferedReader(fr);
	        
	        String line = "";
	        int rowIndex = 0;
	        
	        while ((line = br.readLine()) != null) {
	        	if (rowIndex == selectedRow) {
	    			if (rbnMale.isSelected()) {
	    				gender = "Male";
	    			} else if (rbnFemale.isSelected()) {
	    				gender = "Female";
	    			}
	    			
	        		String updateData = empId + " # "
							+ txtFullName.getText().trim() + " # "
							+ txtBirthDate.getText().trim() + " # "
							+ age + " # "
							+ boxCivilStatus.getSelectedItem().toString() + " # "
							+ txtNationality.getText().trim() + " # "
							+ gender + " # "
							+ txtContactNum.getText().trim() + " # "
							+ txtEmail.getText().trim() + " # "
							+ txtDepartment.getText().trim() + " # "
							+ txtJobTitle.getText().trim();
	        		lines.add(updateData);
	        	} else {
	        		lines.add(line);
	        	}
	        	
	        	rowIndex++;
	        }
	        
	        br.close();
	    } catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Error Occurred: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
			return;
	    } catch (IOException e) {
	    	JOptionPane.showMessageDialog(this, "Error Occurred: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
	    	return;
	    }
	    
	    
	    
	    try {
	        FileWriter fw = new FileWriter("Employees.txt");
	        BufferedWriter bw = new BufferedWriter(fw);

	        for (String data : lines) {
	        	bw.write(data);
	        	bw.newLine();
	        }

	        bw.close();
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(this, "Error Occurred: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    JOptionPane.showMessageDialog(this,"Employee updated successfully.");
	    clear();
	    table.clearSelection();
	    viewTable();
	}
	
	
	
	void viewTable() {
		model.setRowCount(0);
		
		try {
			FileReader fr = new FileReader("Employees.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] row = line.split(" # ");
				model.addRow(row);
			}
			
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "ERROR OCCURRED: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	void clear() {
		txtEmpID.setText("");
		txtFullName.setText("");
		txtBirthDate.setText("");
		txtAge.setText("");
		boxCivilStatus.setSelectedIndex(0);
		txtNationality.setText("");
		grpGender.clearSelection();
		txtContactNum.setText("");
		txtEmail.setText("");
		txtDepartment.setText("");
		txtJobTitle.setText("");
	}

}
