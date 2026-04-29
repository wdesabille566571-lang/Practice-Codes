package desabille;

import java.awt.Font;
import java.io.*;
import javax.swing.*;

public class Desabille extends JFrame {
	static JLabel lblTitle, lblRcptNum, lblStoreName, lblTotalCost, lblTax, lblFinalAmount;
	static JTextField txtRcptNum, txtStoreName, txtTotalCost, txtTax, txtFinalAmount;
	static JButton btnRecord, btnClear;

	public static void main(String[] args) {
		new Desabille();
	}

	Desabille() {
		lblTitle = new JLabel("WYZ EXPENSE TRACKER");
		lblTitle.setBounds(150, 10, 200, 30);
		lblTitle.setHorizontalTextPosition(JLabel.CENTER);
		lblTitle.setFont(new Font("Arial Black", Font.PLAIN, 14));
		add(lblTitle);
		lblRcptNum = new JLabel("Receipt Number:");
		add(lblRcptNum).setBounds(40, 60, 100, 30);
		txtRcptNum = new JTextField();
		add(txtRcptNum).setBounds(200, 60, 250, 30);
		lblStoreName = new JLabel("Store Name:");
		add(lblStoreName).setBounds(40, 100, 100, 30);
		txtStoreName = new JTextField();
		add(txtStoreName).setBounds(200, 100, 250, 30);
		lblTotalCost = new JLabel("Total Cost:");
		add(lblTotalCost).setBounds(40, 140, 100, 30);
		txtTotalCost = new JTextField();
		add(txtTotalCost).setBounds(200, 140, 250, 30);
		lblTax = new JLabel("Tax (12%):");
		add(lblTax).setBounds(40, 210, 100, 30);
		txtTax = new JTextField();
		txtTax.setBounds(200, 210, 250, 30);
		txtTax.setEditable(false);
		add(txtTax);
		lblFinalAmount = new JLabel("Final Amount:");
		add(lblFinalAmount).setBounds(40, 250, 100, 30);
		txtFinalAmount = new JTextField();
		txtFinalAmount.setBounds(200, 250, 250, 30);
		txtFinalAmount.setEditable(false);
		add(txtFinalAmount);
		btnRecord = new JButton("Record");
		add(btnRecord).setBounds(100, 320, 100, 30);
		btnRecord.addActionListener(e -> record());
		btnClear = new JButton("Clear");
		add(btnClear).setBounds(270, 320, 100, 30);
		btnClear.addActionListener(e -> clear());
		setLayout(null);
		setTitle("WYZ EXPENSE TRACKER");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		setResizable(false);
	}

	public static double tax(double tax) {
		return tax * 0.12;
	}

	public static double finalAmount(double totalCost, double tax) {
		return totalCost + tax;
	}

	public static void record() {
		double totalCost = Double.parseDouble(txtTotalCost.getText());
		txtTax.setText(String.format("P%.2f", tax(totalCost)));
		txtFinalAmount.setText(String.format("P%.2f", finalAmount(totalCost, tax(totalCost))));
		try {
			FileWriter fw = new FileWriter("Expense Tracker.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(txtRcptNum.getText() + " || ");
			bw.write(txtStoreName.getText() + " || ");
			bw.write(txtTotalCost.getText() + " || ");
			bw.write(txtTax.getText() + " || ");
			bw.write(txtFinalAmount.getText() + "\n");
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Saving Failed", "EXPENSE TRACKER", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void clear() {
		txtRcptNum.setText("");
		txtStoreName.setText("");
		txtTotalCost.setText("");
		txtTax.setText("");
		txtFinalAmount.setText("");
	}
}
