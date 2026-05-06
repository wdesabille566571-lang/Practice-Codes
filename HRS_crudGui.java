package desabille;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;

public class HRS_crudGui extends JFrame {
	JLabel lblGuestName, lblRoomType, lblCheckInDate, lblCheckOutDate;
	JTextField txtGuestName, txtRoomType, txtCheckInDate, txtCheckOutDate;
	JButton btnAdd, btnUpdate, btnDelete, btnExit;
	JTable table;
	DefaultTableModel model;
	JScrollPane scrollTable;

	
	
	public static void main(String[] args) {
		new HRS_crudGui();
	}

	
	
	HRS_crudGui() {
		String[] columns = { "Guest Name", "Room Type", "Check In Date", "Check Out Date" };
		model = new DefaultTableModel(columns, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		scrollTable = new JScrollPane(table);
		scrollTable.setBounds(10, 20, 720, 530);
		add(scrollTable);
		
		
		lblGuestName = new JLabel("Guest Name");
		lblGuestName.setBounds(10, 563, 100, 18);
		lblGuestName.setFont(new Font("Serif", Font.BOLD, 12));
		add(lblGuestName);
		
		txtGuestName = new JTextField();
		txtGuestName.setBounds(10, 581, 125, 18);
		txtGuestName.setFont(new Font("Serif", Font.PLAIN, 12));
		add(txtGuestName);
		
		
		lblRoomType = new JLabel("Room Type");
		lblRoomType.setBounds(150, 563, 100, 18);
		lblRoomType.setFont(new Font("Serif", Font.BOLD, 12));
		add(lblRoomType);
		
		txtRoomType = new JTextField();
		txtRoomType.setBounds(150, 581, 125, 18);
		txtRoomType.setFont(new Font("Serif", Font.PLAIN, 12));
		add(txtRoomType);
		
		
		lblCheckInDate = new JLabel("Check In Date");
		lblCheckInDate.setBounds(285, 563, 100, 18);
		lblCheckInDate.setFont(new Font("Serif", Font.BOLD, 12));
		add(lblCheckInDate);
		
		txtCheckInDate = new JTextField();
		txtCheckInDate.setBounds(285, 581, 125, 18);
		txtCheckInDate.setFont(new Font("Serif", Font.PLAIN, 12));
		add(txtCheckInDate);
		
		
		lblCheckOutDate = new JLabel("Check Out Date");
		lblCheckOutDate.setBounds(420, 563, 100, 18);
		lblCheckOutDate.setFont(new Font("Serif", Font.BOLD, 12));
		add(lblCheckOutDate);
		
		txtCheckOutDate = new JTextField();
		txtCheckOutDate.setBounds(420, 581, 125, 18);
		txtCheckOutDate.setFont(new Font("Serif", Font.PLAIN, 12));
		add(txtCheckOutDate);
		
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(600, 581, 80, 18);
		btnAdd.setFont(new Font("Serif", Font.BOLD, 12));
		add(btnAdd);
		btnAdd.addActionListener(e -> addData());

		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(600, 604, 80, 18);
		btnUpdate.setFont(new Font("Serif", Font.BOLD, 12));
		add(btnUpdate);
		btnUpdate.addActionListener(e -> updateData());
		
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(600, 627, 80, 18);
		btnDelete.setFont(new Font("Serif", Font.BOLD, 12));
		add(btnDelete);
		btnDelete.addActionListener(e -> deleteData());
		
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(600, 650, 80, 18);
		btnExit.setFont(new Font("Serif", Font.BOLD, 12));
		add(btnExit);
		btnExit.addActionListener(e -> exit());
		
		
		
		viewTable();
		
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if(row != -1) {
					txtGuestName.setText(model.getValueAt(row, 0).toString());
					txtRoomType.setText(model.getValueAt(row, 1).toString());
					txtCheckInDate.setText(model.getValueAt(row, 2).toString());
					txtCheckOutDate.setText(model.getValueAt(row, 3).toString());
				}
			}
		});
		
		
		
		setLayout(null);
		setSize(760, 730);
		setTitle("WYZ HOTEL RESERVATION");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	
	
	void addData() {
		if (txtGuestName.getText().trim().isEmpty() || txtRoomType.getText().trim().isEmpty() || txtCheckInDate.getText().trim().isEmpty() ||
			txtCheckOutDate.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill-up the requirements.", "Missing Requirement/s", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if (!txtCheckInDate.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
		    JOptionPane.showMessageDialog(this, "Date must be MM/DD/YYYY", "Invalid Date", JOptionPane.WARNING_MESSAGE);
		    return;
		}
		
		if (!txtCheckOutDate.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
		    JOptionPane.showMessageDialog(this, "Date must be MM/DD/YYYY", "Invalid Date", JOptionPane.WARNING_MESSAGE);
		    return;
		}

		int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to add this reservation?", "Confirm Add", JOptionPane.YES_NO_OPTION);
	    if (confirm != JOptionPane.YES_OPTION) {
	        return;
	    }
		
		try {
			String data = txtGuestName.getText().trim() + " # "
						+ txtRoomType.getText().trim() + " # "
						+ txtCheckInDate.getText().trim() + " # "
						+ txtCheckOutDate.getText().trim();
			
	
			FileWriter fw = new FileWriter("HRS.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(data);
			bw.newLine();
			
			bw.close();
		} catch (IOException e){
			JOptionPane.showMessageDialog(this, "Error Occurred: " + e.getMessage(), "Data not saved", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		JOptionPane.showMessageDialog(this,"Reservation added successfully.");
		clear();
		table.clearSelection();
		viewTable();
	}
	
	
	
	void updateData() {
		int selectedRow = table.getSelectedRow();
	    
	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(this, "Please select a reservation to update.", "No Selection", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    
	    
	    if (txtGuestName.getText().trim().isEmpty() || txtRoomType.getText().trim().isEmpty() || txtCheckInDate.getText().trim().isEmpty() ||
				txtCheckOutDate.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please fill-up the requirements.", "Missing Requirement/s", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if (!txtCheckInDate.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
			    JOptionPane.showMessageDialog(this, "Date must be MM/DD/YYYY", "Invalid Date", JOptionPane.WARNING_MESSAGE);
			    return;
			}
			
			if (!txtCheckOutDate.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
			    JOptionPane.showMessageDialog(this, "Date must be MM/DD/YYYY", "Invalid Date", JOptionPane.WARNING_MESSAGE);
			    return;
			}
	    
			
	    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to update this reservation?", "Confirm Update", JOptionPane.YES_NO_OPTION);
	    if (confirm != JOptionPane.YES_OPTION) {
	        return;
	    }
	    
	    
	    
	    ArrayList<String> lines = new ArrayList<>();
	    try {
	    	FileReader fr = new FileReader("HRS.txt");
	        BufferedReader br = new BufferedReader(fr);
	        
	        String line = "";
	        int rowIndex = 0;
	        
	        while ((line = br.readLine()) != null) {
	        	if (rowIndex == selectedRow) {
	    			
	        		String updateData = txtGuestName.getText().trim() + " # "
									+ txtRoomType.getText().trim() + " # "
									+ txtCheckInDate.getText().trim() + " # "
									+ txtCheckOutDate.getText().trim();
	        		
	        		lines.add(updateData);
	        	} else {
	        		lines.add(line);
	        	}
	        	
	        	rowIndex++;
	        }
	        
	        br.close();
	    } catch (IOException e) {
	    	JOptionPane.showMessageDialog(this, "Error Occurred: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
	    	return;
	    }
	    
	    
	    
	    try {
	        FileWriter fw = new FileWriter("HRS.txt");
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
	    
	    JOptionPane.showMessageDialog(this,"Reservation updated successfully.");
	    clear();
	    table.clearSelection();
	    viewTable();
	}
	
	
	
	void deleteData() {
		int selectedRow = table.getSelectedRow();
	    
	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(this, "Please select a reservation to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    
	    
	    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this reservation?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
	    if (confirm != JOptionPane.YES_OPTION) {
	        return;
	    }

	    

	    ArrayList<String> lines = new ArrayList<>();
	    try {
	    	FileReader fr = new FileReader("HRS.txt");
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
	        FileWriter fw = new FileWriter("HRS.txt");
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
	    
	    JOptionPane.showMessageDialog(this,"Reservation deleted successfully.");
	    clear();
	    table.clearSelection();
	    viewTable();
	}
	
	
	
	void exit() {
		int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
	    if (confirm != JOptionPane.YES_OPTION) {
	        return;
	    }
	    
	    System.exit(0);
	}
	
	
	
	void viewTable() {
		model.setRowCount(0);
		
		try {
			FileReader fr = new FileReader("HRS.txt");
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
		txtGuestName.setText("");
		txtRoomType.setText("");
		txtCheckInDate.setText("");
		txtCheckOutDate.setText("");
	}

}